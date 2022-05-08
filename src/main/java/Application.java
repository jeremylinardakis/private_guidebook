import Models.Boulder;
import User.UserInput;
import User.UserOutput;
import dao.BoulderFileDao;

import java.io.File;

import java.util.*;

public class Application {
    private BoulderFileDao dao;
    private List<Boulder> boulders = new ArrayList<>();
    public Application() {
        dao = new BoulderFileDao("boulderFile.txt");
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    public void run() {
        boulders = dao.getAllBoulders();
        UserOutput.openingBanner();
        boolean running = true;
        while (running) {
            UserOutput.displayMenu();
            prompt("Please select an option: ");
            int selection = UserInput.promptForInt();
            switch (selection) {
                case 1 :
                    listAllBoulders();
                    break;
                case 2 :
                    UserOutput.boulderOptions();
                    boulderLoop();
                    break;
                case 3 :
                    printList("Your boulder circuit includes: ", populateCircuit());
                    break;
                case 4 :
                    running = false;
                default:
                    UserOutput.displayErr("Bad selection, try again!");
            }
        }
    }

    public List<Boulder> populateCircuit() {
        List<Boulder> circuit = new ArrayList<>();

        int sum = 0;
        boolean running = true;
            while (running) {
                UserOutput.displayPrompt("Please enter the name of boulders to add them to your circuit, or type (F) and hit enter to finish.");
                String selection = UserInput.promptForString();
                if (selection.equals("F")) {
                    running = false;
                } else {
                    Boulder boulder = dao.getBoulderByName(selection, boulders);
                    circuit.add(boulder);
                    sum += boulder.getGrade();
                }
            }
            UserOutput.displayPrompt("Your V-point total is :" + sum);
            return circuit;
    }

    public void printList(String banner, List<Boulder> boulders) {
        UserOutput.displayPrompt(banner);
        for (Boulder boulder : boulders) {
            System.out.println(boulder.getName());
        }
    }

    public void boulderLoop() {
        boolean running = true;
        String selection = UserInput.promptForString();
        while (running) {
            switch (selection) {
                case "L" :
                    listAllBoulders();
                    break;
                case "A" :
                    createBoulder();
                    break;
                case "D" :
                    deleteBoulder();
                    break;
                case "U" :
                    updateBoulder();
                    break;
                case "S" :
                    listBouldersByArea();
                    break;
                case "G" :
                    getBoulderByName();
                default :
                    running = false;
            }
            running = false;
        }
    }

    public void getBoulderByName() {
        UserOutput.displayPrompt("Please enter the full name of the boulder : ");
        String name = UserInput.promptForString();

        Boulder boulder = dao.getBoulderByName(name, boulders);
        UserOutput.displayPrompt(boulder.toString());
    }

    public void prompt(String message){
        System.out.println(message);
    }

    public Boulder boulderPrompts() {
        UserOutput.displayPrompt("Please enter boulder name: ");
        String name = UserInput.promptForString();
        UserOutput.displayPrompt("Please enter boulder grade: ");
        int grade = UserInput.promptForInt();
        UserOutput.displayPrompt("Is the boulder dangerous? Enter (T) of (F) : ");
        boolean isDangerous = UserInput.promptForBoolean();
        UserOutput.displayPrompt("Please enter description of boulder: ");
        String description = UserInput.promptForString();
        UserOutput.displayPrompt("Please enter area name: ");
        String areaName = UserInput.promptForString();

        return new Boulder(name, grade, isDangerous, description, areaName);
    }

    public void createBoulder(){
        Boulder boulderToBeCreated = boulderPrompts();
        boulders.add(boulderToBeCreated);
        dao.saveBoulders(boulders);
    }

    public void listAllBoulders() {
        UserOutput.displayPrompt("LIST OF BOULDERS");
        for (Boulder boulder : boulders) {
            UserOutput.displayPrompt((boulders.indexOf(boulder) + 1) + " " + boulder.getName());
        }

    }

    public void deleteBoulder() {
        UserOutput.displayPrompt("Please enter the full name of the boulder to be deleted : ");
        String name = UserInput.promptForString();

        boulders = dao.deleteBoulder(boulders, name);

        dao.saveBoulders(boulders);
    }

    public void listBouldersByArea() {
        UserOutput.displayPrompt("Please enter the name of the area to view associated boulders :");
        String areaName = UserInput.promptForString();

        for (Boulder boulder : boulders) {
            if (boulder.getArea().equals(areaName)) {
                UserOutput.displayPrompt(boulder.getName());
            }
        }

    }

    public void updateBoulder() {
        Boulder updatedBoulder = boulderPrompts();

        boulders = dao.updateBoulder(boulders, updatedBoulder);

        dao.saveBoulders(boulders);

    }



}