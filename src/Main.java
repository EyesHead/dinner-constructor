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
                    dc.addNewDish();
                    break;
                case "2":
                    dc.generateDishCombo();
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