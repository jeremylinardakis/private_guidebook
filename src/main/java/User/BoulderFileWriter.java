package User;

import java.io.*;

public class BoulderFileWriter {
    private File boulderFile;
    private PrintWriter writer;

    public BoulderFileWriter(String pathName){
        this.boulderFile = new File(pathName);
        if(!boulderFile.exists()){
            try {
                this.writer = new PrintWriter(this.boulderFile);
            } catch (FileNotFoundException fnfe) {
                fnfe.printStackTrace();
            }
        } else {
            try {
                this.writer = new PrintWriter(new FileWriter(this.boulderFile, false));
            } catch (IOException io) {
                io.printStackTrace();
            }
        }
    }

    public void write(String logMessage){
        this.writer.println(logMessage);
        this.writer.flush();
    }

    public void close() throws IOException {
        this.writer.close();
    }

    public void delete() throws IOException{
        boulderFile.delete();
    }

}
