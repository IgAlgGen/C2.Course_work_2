package DiaryTasks;

import Exceptions.IncorrectArgumentException;

import java.time.LocalDateTime;

public class WeeklyTask extends Task implements TaskRepeatability{
    public WeeklyTask(String title, String description, TaskType taskType, LocalDateTime deadlineTime) throws IncorrectArgumentException {
        super(title, description, taskType, deadlineTime);
    }

    @Override
    public boolean isAppearOnTheDay(LocalDateTime localDateTime) {
        return localDateTime.getDayOfWeek().equals(getDeadlineTime().getDayOfWeek());
    }
}
