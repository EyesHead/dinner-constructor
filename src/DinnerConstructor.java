import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DinnerConstructor {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    HashMap<String, ArrayList<String>> dishMap; // HashMap (K - dishType , V - dishNameList)

    DinnerConstructor() {
        dishMap = new HashMap<>();
    }

    void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        // Checking for an existing type
        for (String dishMapKey : dishMap.keySet()) {
            if (dishType.equals(dishMapKey)) { // We have type already - add new dish in list of current type
                ArrayList<String> existingDishNameList = dishMap.get(dishMapKey);
                existingDishNameList.add(dishName);
            } else { // Type doesn't exist - create new list and put in our map
                ArrayList<String> newExistingDishNameList = new ArrayList<>();
                newExistingDishNameList.add(dishName);
                dishMap.put(dishType, newExistingDishNameList);
            }
        }
        System.out.println("Блюдо успешно добавлено!");
    }

    void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). " +
                "Для завершения ввода введите пустую строку");

        ArrayList<String> inputDishTypes = new ArrayList<>();
        while (true) { // adding input Types to new list
            String dishType = scanner.nextLine();
            if (dishType.isEmpty()) {
                break;
            }

            if (dishMap.containsKey(dishType)) { // if we have dish type in map - add this type in new list
                inputDishTypes.add(dishType);
            } else { // if we don't - exception
                System.out.println("Такого типа блюда нет в меню \n Попробуйте ещё раз");
            }
        }
        //at this stage, we have a list of the inputted types of dishes

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
            System.out.println("Тип блюда " + dishType);
            System.out.println("Блюда: ");
            System.out.println(dishMap.get(dishType));
            System.out.println();
        }
    }

}