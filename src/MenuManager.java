
import java.util.Scanner;

public class MenuManager {

    Helper helper = new Helper();

    public void printMenu() {
        System.out.println("Welcome to Food Management - @ 2021 by SE150058 - Dau Le Duc");
        System.out.println("Select the options below :");
        System.out.println("1. Add a new food");
        System.out.println("2. Search a food by name");
        System.out.println("3. Remove the food by ID");
        System.out.println("4. Print the food list in the descending order of expired date");
        System.out.println("5. Save to file");
        System.out.println("6. Quit");
    }

    public void printConfirmMenu(String msg) {
        System.out.println(msg);
        System.out.println("1. Yes");
        System.out.println("2. No");
    }

    public int getUserChoice() {
        int choice = helper.getInt("your selection : ");;
        return choice;
    }
}
