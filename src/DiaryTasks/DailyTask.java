package DiaryTasks;

import Exceptions.IncorrectArgumentException;

import java.time.LocalDateTime;

public class DailyTask extends Task implements TaskRepeatability {


    public DailyTask(String title, String description, TaskType taskType, LocalDateTime deadlineTime) throws IncorrectArgumentException {
        super(title, description, taskType, deadlineTime);
    }

    @Override
    public boolean isAppearOnTheDay(LocalDateTime localDateTime) {
        return localDateTime.toLocalDate().equals(getDeadlineTime().toLocalDate());
    }


}
