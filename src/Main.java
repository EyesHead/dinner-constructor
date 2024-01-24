import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DinnerConstructor dc = new DinnerConstructor();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    System.out.println("Введите тип блюда:");
                    String dishType = scanner.nextLine();
                    System.out.println("Введите название блюда:");
                    String dishName = scanner.nextLine();
                    if (!dc.hasDuplicateName(dishType, dishName)) {
                        dc.addNewDish(dishType, dishName);
                    } else {
                        System.out.println("Такое блюдо уже есть!");
                    }
                    break;
                case "2":
                    System.out.println("Начинаем конструировать обед...");

                    System.out.println("Введите количество наборов, которые нужно сгенерировать:");
                    int numberOfCombos = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). " +
                            "Для завершения ввода введите пустую строку");
                    ArrayList<String> inputDishTypes = new ArrayList<>();

                    while (true) {
                        String nextItem = scanner.nextLine().trim();
                        if (nextItem.isBlank()) {
                            break;
                        } else {
                            if (dc.checkType(nextItem)) { // we have input item in keys of dish hash map
                                inputDishTypes.add(nextItem);
                            } else {
                                System.out.println("Вы ввели тип блюда, которого нет в меню.");
                            }
                        }
                    }
                    //реализуйте ввод типов блюд

                    dc.generateDishCombo(numberOfCombos, inputDishTypes);
                    break;
                case "3":
                    dc.showMenu();
                    break;
                case "4":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Показать меню");
        System.out.println("4 - Выход");
    }

}