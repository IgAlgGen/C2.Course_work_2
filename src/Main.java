import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
//        DailyTask dailyTask = new DailyTask("qwe", "sdaads", TaskType.PRIVATE, LocalDateTime.of(2023, 3, 20, 15, 0));
//        TaskRepeatability dailyTask1 = new DailyTask("qwe", "sdaads", TaskType.PRIVATE, LocalDateTime.of(2023, 3, 21, 15, 0));
//        Task dailyTask2 = new DailyTask("qwe", "sdaads", TaskType.PRIVATE, LocalDateTime.of(2023, 3, 22, 15, 0));
//        DailyTask dailyTask3 = new DailyTask("qwe", "sdaads", TaskType.PRIVATE, LocalDateTime.of(2023, 3, 23, 15, 0));
//        Scanner scanner = new Scanner(System.in);
//        TaskService.addTask(scanner);
//        TaskService.getAllByDate(scanner);

        Scanner scanner = new Scanner(System.in);
        label:
        while (true) {
            System.out.println("Выберете пункт меню:");
            printMenu();
            if (scanner.hasNextInt()) {
                int menu = scanner.nextInt();
                switch (menu) {
                    case 1:
                        TaskService.addTask(scanner);
                        break;
                    case 2:
                        TaskService.getAllByDate(scanner);
                        break;
                    case 3:
                        TaskService.deleteTask(scanner);
                        break;
                    case 4:
                        TaskService.printActualTasks();
                        break;
                    case 0:
                        break label;
                }
            } else {
                scanner.next();
                System.out.println("Выберете пункт меню из списка!");
            }
        }
    }


    private static void printMenu() {
        System.out.println("1. Добавить задачу\n" +
                "2. Получить задачи на день\n" +
                "3. Удалить задачу по id\n" +
                "4. Получить список всех созданных задач\n" +
                "0. Выход");

    }


}