import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class DinnerConstructor {
    Random random = new Random();
    HashMap<String, ArrayList<String>> dishMap; // HashMap (K - dishType , V - dishNameList)

    DinnerConstructor() {
        dishMap = new HashMap<>();
    }

    void addNewDish(String dishType, String dishName) {

        // Checking for an existing type
        if (dishMap.containsKey(dishType)) { // We have type already - add new dish in list of current type
            dishMap.get(dishType).add(dishName);
        } else { // Type doesn't exist - create new list and put in our map
            ArrayList<String> newDishNameList = new ArrayList<>();
            newDishNameList.add(dishName);
            dishMap.put(dishType, newDishNameList);
        }
    }

    void generateDishCombo(int numberOfCombos, ArrayList<String> inputDishTypes) {
        for (int bound = 1; bound <= numberOfCombos; bound++) {
            System.out.println("Комбо " + bound);
            ArrayList<String> randomisedDishNames = new ArrayList<>();

            // search through the types of dish types inputted by the user for the combo
            for (String dishType : inputDishTypes) {
                ArrayList<String> hashMapDishNamesList = dishMap.get(dishType); //
                int randomIndex = random.nextInt(hashMapDishNamesList.size());
                String randomDish = hashMapDishNamesList.get(randomIndex);

                randomisedDishNames.add(randomDish);
            }
            System.out.println(randomisedDishNames);
        }
    }

    void showMenu() {
        for (String dishType : dishMap.keySet()) {
            System.out.println(dishType);
            System.out.println(dishMap.get(dishType));
            System.out.println();
        }
    }

    boolean checkType(String type) {
        return dishMap.containsKey(type);
    }

    boolean checkName(String type, String name) {
        return dishMap.get(type).contains(name);
    }

    boolean hasDuplicateName(String dishType, String dishName) {
        if (!dishMap.isEmpty()) {
            return checkName(dishType, dishName);
        } else {
            return false;
        }
    }
}