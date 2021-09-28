
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class FoodManager {

    Helper helper = new Helper();
    ArrayList<Food> foodList = new ArrayList<Food>();
    int count = 0;

    public boolean isEmpty() {
        return foodList.size() == 0;
    }

    public boolean checkDuplicateID(String ID) {
        for (int i = 0; i < foodList.size(); i++) {
            Food food = foodList.get(i);
            if (food.ID.equals(ID)) {
                return true;
            }
        }
        return false;
    }

    public Food getNewFood() {
        String ID;
        boolean isTrue;
        while (true) {
            ID = helper.getString("Input ID : ", "");
            isTrue = checkDuplicateID(ID);
            if (!isTrue) {
                break;
            } else {
                System.out.println("This ID already existed");
            }
        }

        String name = helper.getString("Input name : ", "");
        int weight = helper.getInt("Input weight : ");
        String type = helper.getString("Input type : ", "");
        String place = helper.getString("Input place : ", "");
        Date expriredDate = helper.getDate("Input exprired Date (dd/MM/yyyy) 1:");
        Food food = new Food(ID, name, weight, type, place, expriredDate);
        return food;
    }

    public void AddFood(Food food) {
        foodList.add(food);
    }

    public void removeFood(int i) {
        foodList.remove(i);
    }

    public int findIndexOfFoodByID(String ID) {
        for (int i = 0; i < foodList.size(); i++) {
            Food food = foodList.get(i);
            if (food.ID.equals(ID)) {
                return i;
            }
        }
        return -1;
    }

    public void printFood() {

        System.out.printf("%-15s|%-15s|%-15s|%-15s|%-15s|%-15s\n", "ID", "Name", "Weight", "Type", "Place", "Date");
        for (int i = 0; i < foodList.size(); i++) {
            Food food = foodList.get(i);
            System.out.printf("%-15s|%-15s|%-15s|%-15s|%-15s|%-15s\n", food.ID, food.name, food.weight, food.type, food.place, food.dayToString());
        }
    }

    public void printAFood(Food food) {
        System.out.printf("%-15s|%-15s|%-15s|%-15s|%-15s|%-15s\n", food.ID, food.name, food.weight, food.type, food.place, food.dayToString());
    }

    public void printFoodInDes() {
        Collections.sort(foodList, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return -o1.expriredDate.compareTo(o2.expriredDate);
            }
        });

        printFood();
    }

    public Food searchFoodByNameAndPrint(String name) {
        Food food = null;
        count = 0;
        for (int i = 0; i < foodList.size(); i++) {
            Food currentFood = foodList.get(i);
            if (currentFood.name.contains(name)) {
                printAFood(currentFood);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("This food does not exist");
        }
        return food;
    }

    public void save(String nameOfFile) throws IOException {
        nameOfFile = nameOfFile + ".dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nameOfFile));
        for (Food food : foodList) {
            oos.writeObject(food);
        }
        oos.close();
    }

}
