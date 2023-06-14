package DiaryTasks;

import Exceptions.IncorrectArgumentException;

public enum TaskType {
    WORK("w"),
    PRIVATE("p");

    public final String name;

    TaskType(String name) {
        this.name = name;
    }

    public static TaskType values(String str) throws IncorrectArgumentException {
        switch (str){
            case "w":
                return WORK;
            case "p":
                return PRIVATE;
        }
        throw new IncorrectArgumentException();
    }
}
