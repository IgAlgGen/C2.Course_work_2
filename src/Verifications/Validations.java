package Verifications;

import Exceptions.IncorrectArgumentException;

public class Validations {

    public static String checkString(String str) throws IncorrectArgumentException {
        if (str == null || str.isEmpty() || str.isBlank()) {
            throw new IncorrectArgumentException("Некорректный ввод данных");
        }else {
            return str;
        }
    }
}
