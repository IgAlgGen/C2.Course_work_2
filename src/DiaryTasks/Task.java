package DiaryTasks;

import Exceptions.IncorrectArgumentException;
import Verifications.Validations;

import java.time.LocalDateTime;
import java.util.Objects;


public abstract class Task {
    private String title, description;
    private TaskType taskType;
    private final LocalDateTime creationTime;
    private LocalDateTime deadlineTime;
    private static int counter = 1;
    private final int id;

    public Task(String title, String description, TaskType taskType, LocalDateTime deadlineTime) throws IncorrectArgumentException {
        this.title = Validations.checkString(title);
        this.description = Validations.checkString(description);
        this.taskType = taskType;
        this.creationTime = LocalDateTime.now();
        this.deadlineTime = deadlineTime;
        id = counter++;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public LocalDateTime getDeadlineTime() {
        return deadlineTime;
    }

    public void setDeadlineTime(LocalDateTime deadlineTime) {
        this.deadlineTime = deadlineTime;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Task.counter = counter;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && Objects.equals(description, task.description) && taskType == task.taskType && Objects.equals(deadlineTime, task.deadlineTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, taskType, deadlineTime, id);
    }

    @Override
    public String toString() {
        return "Задача" + " id: " + id + " {" +
                "заголовок: " + title +
                ", описание: " + description +
                ", тип задачи: " + taskType +
                ", дата выполнения: " + deadlineTime +
                '}';
    }
}
