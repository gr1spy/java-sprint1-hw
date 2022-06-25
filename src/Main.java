import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StepTracker stepTracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {

            if (userInput == 1) {
                System.out.println("Введите номер месяца (0 - январь ... 11 - декабрь):\n");
                int month = scanner.nextInt();
                if (month < 0){
                    System.out.println("Такого месяца не существует, попробуйте снова!\n");
                    continue;
                } else if(month > 11){
                    System.out.println("Такого месяца не существует, попробуйте снова!\n");
                    continue;
                }
                System.out.println("Введите число месяца (с 1 по 30):\n");
                int day = scanner.nextInt();
                if (day < 1){
                    System.out.println("Такого дня не существует, попробуйте снова!\n");
                    continue;
                } else if(day > 30){
                    System.out.println("Такого дня не существует, попробуйте снова!\n");
                    continue;
                }
                System.out.println("Введите число шагов за этот день:\n");
                int step = scanner.nextInt();
                if (step < 0){
                    System.out.println("Введите положительное число!\n");
                    break;
                } else {
                    stepTracker.selectPushDay(month, day-1, step);
                }
            } else if (userInput == 2) {
                System.out.println("Введите номер месяца (0 - январь ... 11 - декабрь):\n");
                int month = scanner.nextInt();
                if (month < 0){
                    System.out.println("Такого месяца не существует, попробуйте снова!\n");
                    continue;
                } else if(month > 11){
                    System.out.println("Такого месяца не существует, попробуйте снова!\n");
                    continue;
                }
                stepTracker.statusForMonth(month);
            } else if (userInput == 3) {
                System.out.println("Выберите новую цель шагов в день:\n");
                int countStepPerDay = scanner.nextInt();
                if (countStepPerDay < 0){
                    System.out.println("Цель шагов не может быть отрицательной, попробуйте снова!\n");
                    continue;
                }
                stepTracker.maxStepPerDay(countStepPerDay);
            } else if (userInput == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }

            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выход");
    }
}