package DiaryTasks;

import Exceptions.IncorrectArgumentException;

import java.time.LocalDateTime;

public class YearlyTask extends Task implements TaskRepeatability{
    public YearlyTask(String title, String description, TaskType taskType, LocalDateTime deadlineTime) throws IncorrectArgumentException {
        super(title, description, taskType, deadlineTime);
    }

    @Override
    public boolean isAppearOnTheDay(LocalDateTime localDateTime) {
        return localDateTime.getYear()==getDeadlineTime().getYear();
    }
}
