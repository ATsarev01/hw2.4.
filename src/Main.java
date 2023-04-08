public class Main {
    public static void main(String[] args) {
        boolean result = ValidatorService.validate("anton_1233", "HJF_dfg1235", "HJF_dfg1235");
        if (result) {
            System.out.println("Логин и пароль введены корректно");
        }
    }
}