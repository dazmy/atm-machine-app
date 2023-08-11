package util;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static int login(String info) {
        System.out.print(info + " : ");
        String input = scanner.nextLine();
        int login;
        try {
            login = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 0;
        }
        return login;
    }

    public static int menuInput(String info) {
        System.out.print(info + " : ");
        String input = scanner.nextLine();
        int menu;
        try {
            menu = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 0;
        }
        return menu;
    }

    public static int depositAndWithdrawInput(String info) {
        System.out.print(info + " : ");
        String input = scanner.nextLine();
        int depositAndWithdraw;
        try {
            depositAndWithdraw = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 0;
        }
        return depositAndWithdraw;
    }

    public static String messageDepositAndWithdrawInput(String info) {
        System.out.print(info + " : ");
        String messageDepositAndWithdrawInput = scanner.nextLine();
        if (!messageDepositAndWithdrawInput.isBlank()) {
            return messageDepositAndWithdrawInput;
        }
        return null;
    }
}
