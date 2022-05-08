package dao;

import Models.Boulder;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.List;

public interface BoulderDao {

    List<Boulder> getAllBoulders();

    Boulder getBoulderByName(String name, List<Boulder> boulders);

    List<Boulder> updateBoulder(List<Boulder> boulders, Boulder boulder);

    List<Boulder> deleteBoulder(List<Boulder> boulders, String boulderName);

    void saveBoulders(List <Boulder> boulders);

    List<Boulder> searchBouldersByArea(String name, List<Boulder> boulders);


}
