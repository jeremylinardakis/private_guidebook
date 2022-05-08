package dao;

import Models.Boulder;
import User.BoulderFileWriter;
import User.UserInput;
import User.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoulderFileDao implements BoulderDao{
    private File file;
    private Scanner input;

    public BoulderFileDao(String fileName) {
        file = new File(fileName);
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Boulder> getAllBoulders() {
        List<Boulder> boulders = new ArrayList<>();
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] boulderInfo = line.split("~");
            Boulder boulder = new Boulder(boulderInfo[0], Integer.parseInt(boulderInfo[1]),
                    Boolean.parseBoolean(boulderInfo[2]), boulderInfo[3], boulderInfo[4]);
            boulders.add(boulder);
        }
        return boulders;
    }

    @Override
    public Boulder getBoulderByName(String name, List<Boulder> boulders) {
        Boulder selectedBoulder = new Boulder();
        for (Boulder boulder : boulders) {
            if (boulder.getName().contains(name)) {
                selectedBoulder = boulder;
            }
        }
        return selectedBoulder;
    }

    @Override
    public List<Boulder> updateBoulder(List<Boulder> boulders, Boulder boulderToBeUpdated) {
        boulders.removeIf(boulder -> boulder.getName().equals(boulderToBeUpdated.getName()));
        boulders.add(boulderToBeUpdated);
        return boulders;
    }

    @Override
    public List<Boulder> deleteBoulder(List<Boulder> boulders, String boulderName) {
        boulders.removeIf(boulder -> boulder.getName().equals(boulderName));
        return boulders;
    }

    @Override
    public void saveBoulders(List<Boulder> boulders) {
        BoulderFileWriter boulderFileWriter = new BoulderFileWriter("boulderFile.txt");
        for (Boulder boulder : boulders) {
            boulderFileWriter.write(boulder.getName() + "~" + boulder.getGrade() + "~"
                    + boulder.isDangerous() + "~" + boulder.getDescription() + "~" + boulder.getArea());
        }

    }

    @Override
    public List<Boulder> searchBouldersByArea(String areaName, List<Boulder> boulders) {
        List<Boulder> bouldersByArea = new ArrayList<>();

        for (Boulder boulder : boulders) {
            if (boulder.getArea().equals(areaName)) {
                bouldersByArea.add(boulder);
            }
        }
        return bouldersByArea;
    }

}
