import DiaryTasks.*;
import Exceptions.IncorrectArgumentException;
import Exceptions.TaskNotFoundException;
import Verifications.Validations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class TaskService {
    private static final Map<Integer, TaskRepeatability> currentTasks = new HashMap<>();

    public static void addTask(Scanner scan) {
        try {
            scan.nextLine();
            System.out.println("Введите название задачи: ");
            String title = Validations.checkString(scan.nextLine());
            System.out.println("Введите описание задачи: ");
            String description = Validations.checkString(scan.nextLine());
            System.out.println("Введите тип задачи: w - рабочаа; p - личная");
            TaskType taskType = TaskType.values(scan.nextLine());
            System.out.println("Введите периодичность задачи: 0 - однократная; 1 - ежедневная; 2 - еженедельная; 3 - ежемесячная; 4 - ежегодная");
            int repeatability = scan.nextInt();
            System.out.println("Введите дату и время окончания задачи в формате dd.MM.yyyy HH:mm");
            scan.nextLine();
            LocalDateTime date = LocalDateTime.parse(scan.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
            TaskRepeatability task = createTask(repeatability, title, description, taskType, date);
            System.out.println("Создана задача " + task);
            System.out.println("Для выхода нажмите Enter\n");
            scan.nextLine();
        } catch (IncorrectArgumentException | DateTimeParseException e) {
            System.out.println("Неверно введены данные!\nПопробуйте еще раз.\n");
        }
    }

    public static TaskRepeatability createTask(int repeatability, String title, String description, TaskType taskType, LocalDateTime localDateTime) throws IncorrectArgumentException {
        switch (repeatability) {
            case 0:
                OneTimeTask oncelyTask = new OneTimeTask(title, description, taskType, localDateTime);
                currentTasks.put(oncelyTask.getId(), oncelyTask);
                return oncelyTask;

            case 1:
                DailyTask dailyTask = new DailyTask(title, description, taskType, localDateTime);
                currentTasks.put(dailyTask.getId(), dailyTask);
                return dailyTask;

            case 2:
                WeeklyTask weeklyTask = new WeeklyTask(title, description, taskType, localDateTime);
                currentTasks.put(weeklyTask.getId(), weeklyTask);
                return weeklyTask;

            case 3:
                MonthlyTask monthlyTask = new MonthlyTask(title, description, taskType, localDateTime);
                currentTasks.put(monthlyTask.getId(), monthlyTask);
                return monthlyTask;

            case 4:
                YearlyTask yearlyTask = new YearlyTask(title, description, taskType, localDateTime);
                currentTasks.put(yearlyTask.getId(), yearlyTask);
                return yearlyTask;

            default:
                throw new IncorrectArgumentException();
        }
    }

    public static void getAllByDate(Scanner scan) {
        try {
            System.out.println("Введите дату в формате dd.MM.yyyy");
            LocalDate requestDate = LocalDate.parse(scan.next(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            List<TaskRepeatability> tasksList = new ArrayList<>();
            for (TaskRepeatability task : currentTasks.values()) {
                if (task.isAppearOnTheDay(requestDate.atStartOfDay())) {
                    tasksList.add(task);
                }
            }
            System.out.println(tasksList);

        } catch (DateTimeParseException e) {
            System.out.println("Проверьте формат даты dd.MM.yyyy и попробуйте еще раз.");
        }
        scan.nextLine();
        System.out.println("Для выхода нажмите Enter\n");
        scan.nextLine();
    }

    public static void deleteTask(Scanner scanner) {
        System.out.println("Текущие задачи\n");
        printActualTasks();
        try {
            System.out.println("Для удаления введите ID задачи");
            int id = scanner.nextInt();
            if (currentTasks.containsKey(id)) {
                currentTasks.remove(id);
                System.out.println("Задача " + id + " удалена\n");
            } else {
                throw new TaskNotFoundException();
            }
        } catch (TaskNotFoundException e) {
            System.out.println("Такой задачи не существует\n");
        }

    }

    public static void printActualTasks() {
        for (TaskRepeatability task : currentTasks.values()) {
            System.out.println(task + "\n");
        }
    }

}
