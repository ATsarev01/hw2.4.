public class ValidatorService {

    private static final String ALLOWED_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_0123456789";
    private ValidatorService() {
    }

    public static boolean validate(String login, String password, String confirmPassword) {
        try {
            check(login, password, confirmPassword);
            return true;
        } catch (WrongLoginExeption | WrongPasswordExeption e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static void check(String login, String password, String confirmPassword)
        throws  WrongLoginExeption, WrongPasswordExeption {
        if (login == null || login.length() > 20) {
            throw new WrongLoginExeption("Длина логина должна быть меньше или равна 20");
        }
        if (password == null || password.length() >= 20) {
            throw new WrongPasswordExeption("Длина пароля должна быть меньше 20");
        }
        if (password != confirmPassword) {
            throw new WrongPasswordExeption("Пароли должны совпадать");
        }

        checkSymbols(login, true);
        checkSymbols(password, false);
    }

    private static void checkSymbols(String string, boolean login)
        throws WrongLoginExeption, WrongPasswordExeption {
        for (int i = 0; i < string.length(); i++) {
            if (!ALLOWED_CHARACTERS.contains(String.valueOf(string.charAt(i)))) {
                if (login) {
                    throw new WrongLoginExeption("Символ " + string.charAt(i) + " в логине невалидный");
                } else {
                    throw new WrongPasswordExeption("Символ " + string.charAt(i) + " в пароле невалидный");
                }
            }

        }
    }
}
