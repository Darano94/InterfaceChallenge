package InterfacesChallenge;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //create 2 players
        Players p1 = new Players("yannik", "sword", 100);
        Players p2 = new Players("ryan", "arrows and bow", 100);

        // "save" both players (instead of saving we just getting their stats printed out)
        System.out.println("############# PLAYERS #############");
        saveValues(p1);
        saveValues(p2);
        System.out.println("###################################\n");

        // now we're faking that our restoreValues-method reads a saved object and overrides p1 with it (when entering
        // new input, the first two inputs have to be String, the third one has to be an int (there is no check for input over 100 HP atm)
        restoreValues(p1);

        //now printing (and "saving) the restored p1
        saveValues(p1);
    }

    static void restoreValues(ISaveable object) {
        object.populateFields(generateList());
    }

    //  " We haven't covered I/O yet, so your method should just print the values which are going to be saved onto the screen." -->
    static void saveValues(ISaveable object) {
        System.out.println(object.valuesToBeSaved());
    }

    //faking that we would read an ArrayList from file..instead we're creating just a new one
    public static ArrayList<String> generateList() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;

                case 1:
                    System.out.print("Enter data: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }
}
