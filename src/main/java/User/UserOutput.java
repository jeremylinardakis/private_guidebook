package User;

public class UserOutput {

    public static void openingBanner() {
        System.out.println("|--------------------------------------------------------");
        System.out.println("| Private Guidebook -------------------------------------");
        System.out.println("|--------------------------------------------------------");
    }

    public static void displayMenu() {
        System.out.println("_________________________________________________________");
        System.out.println("| Main Menu  -------------------------------------------|");
        System.out.println("| 1. View All Boulders  --------------------------------|");
        System.out.println("| 2. View Boulder Options  -----------------------------|");
        System.out.println("| 3. Log a circuit   -----------------------------------|");
        System.out.println("| 4. Exit  ---------------------------------------------|");
        System.out.println("|_______________________________________________________|");
    }

    public static void displayErr(String errorMessage) {
        System.out.println(errorMessage + "\n");
    }

    public static void displayPrompt(String prompt){
        System.out.println(prompt);
    }

    public static void boulderOptions() {
        System.out.println("Please select an option: ");
        System.out.println("(G)et boulder info by name");
        System.out.println("(L)ist all boulders");
        System.out.println("(A)dd new boulder");
        System.out.println("(D)elete boulder");
        System.out.println("(U)pdate boulder list");
        System.out.println("(S)earch for a boulder");

    }
}
