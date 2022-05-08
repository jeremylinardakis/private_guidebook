package User;

import Models.Boulder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput {

    private static Scanner input = new Scanner(System.in);

    public static int promptForInt() {
        while (true) {
            String choice = input.nextLine();
            try {
                return Integer.parseInt(choice);
            } catch (NumberFormatException e) {
                if (choice.isBlank()) {
                    return -1;
                } else {
                    UserOutput.displayErr("This is not a valid selection, try again!");
                }
            }
        }
    }

    public static String promptForString(){
        String name = "";
        while(name.isBlank()){
            name = input.nextLine();
        }
        return name;
    }


    public static boolean promptForBoolean() {
        String choice = input.nextLine();
        return Boolean.parseBoolean(choice);
    }
}
