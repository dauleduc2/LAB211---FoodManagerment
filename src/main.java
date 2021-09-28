
import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException {
        MenuManager menu = new MenuManager();
        FoodManager foodManager = new FoodManager();
        Helper helper = new Helper();
        int userChoice;
        String decoyString;
        int isContinue;
        int decoyInt;
        do {
            System.out.println("-------------------------------------------------------------");
            menu.printMenu();
            do {
                userChoice = menu.getUserChoice();
            } while (userChoice <= 0 || userChoice > 6);
            switch (userChoice) {
                case 1:
                    do {
                        Food newFood1 = foodManager.getNewFood();
                        foodManager.AddFood(newFood1);
                        do {
                            menu.printConfirmMenu("Do you want to add another food?");
                            isContinue = menu.getUserChoice();
                        } while (isContinue < 1 || isContinue > 2);

                        if (isContinue == 2) {
                            break;
                        }
                    } while (true);

                    break;
                case 2:
                    if (foodManager.isEmpty()) {
                        System.out.println("No food in refrigerator to search");
                        break;
                    }
                    do {
                        decoyString = helper.getString("In put name of food you want to search : ", "");
                        foodManager.searchFoodByNameAndPrint(decoyString);
                        do {
                            menu.printConfirmMenu("Do you want to search another food?");
                            isContinue = menu.getUserChoice();
                        } while (isContinue < 1 || isContinue > 2);
                        if (isContinue == 2) {
                            break;
                        }
                    } while (true);

                    break;
                case 3:
                    if (foodManager.isEmpty()) {
                        System.out.println("No food in refrigerator to delete");
                        break;
                    }
                    decoyString = helper.getString("input the ID of food you want to delete : ", "");
                    decoyInt = foodManager.findIndexOfFoodByID(decoyString);
                    if (decoyInt == -1) {
                        System.out.println("can't find this ID in the list to delete");
                        break;
                    }
                    do {
                        menu.printConfirmMenu("Do you really want to delete this food?");
                        isContinue = menu.getUserChoice();
                    } while (isContinue < 1 || isContinue > 2);
                    if (isContinue == 2) {
                        System.out.println("remove food failed because the confirmation rejected!");
                    }
                    if (isContinue == 1) {
                        foodManager.removeFood(decoyInt);
                        System.out.println("remove food success!");
                    }
                    break;
                case 4:
                    if (foodManager.isEmpty()) {
                        System.out.println("No food in refrigerator");
                        break;
                    }
                    foodManager.printFoodInDes();

                    break;
                case 5:
                    decoyString = helper.getString("Input name of file you want to save : ", "");
                    foodManager.save(decoyString);
                    break;
                default:
                    break;
            }
        } while (userChoice != 6);
    }

}
