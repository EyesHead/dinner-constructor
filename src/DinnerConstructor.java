import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class DinnerConstructor {

    HashMap<String, ArrayList<String>> dishMenu = new HashMap<>(); // HashMap (K - dishType , V - dishNameList)

    void addNewDish(String dishType, String dishName) {

        // Checking for an existing type
        if (dishMenu.containsKey(dishType)) { // We have type already - add new dish in list of current type
            dishMenu.get(dishType).add(dishName);
        } else { // Type doesn't exist - create new list and put in our map
            ArrayList<String> newDishNames = new ArrayList<>();
            newDishNames.add(dishName);
            dishMenu.put(dishType, newDishNames);
        }
    }

    void generateDishCombo(int numberOfCombos, ArrayList<String> inputDishTypes) {
        Random random = new Random();

        for (int bound = 1; bound <= numberOfCombos; bound++) {
            System.out.println("Комбо " + bound);
            ArrayList<String> randomisedDishNames = new ArrayList<>();

            // search through the types of dish types inputted by the user for the combo
            for (String dishType : inputDishTypes) {
                ArrayList<String> dishNamesFromMenu = dishMenu.get(dishType); //
                int randomIndex = random.nextInt(dishNamesFromMenu.size());
                String randomDish = dishNamesFromMenu.get(randomIndex);

                randomisedDishNames.add(randomDish);
            }
            System.out.println(randomisedDishNames);
        }
    }

    void showMenu() {
        for (String dishType : dishMenu.keySet()) {
            System.out.println(dishType);
            System.out.println(dishMenu.get(dishType));
            System.out.println();
        }
    }

    boolean checkType(String type) {
        return dishMenu.containsKey(type);
    }

    boolean checkDuplicateName(String dishType, String dishName) {
        if (dishMenu.containsKey(dishType)) {
            return dishMenu.get(dishType).contains(dishName);
        } else {
            return false;
        }
    }

    boolean hasDuplicateName(String dishType, String dishName) {
        if (!dishMenu.isEmpty()) {
            return checkDuplicateName(dishType, dishName);
        } else {
            return false;
        }
    }

}