package view;

import entity.Client;
import service.ClientService;
import util.InputUtil;

public class ClientView {
    private final ClientService clientService;

    public ClientView(ClientService clientService) {
        this.clientService = clientService;
    }

    public void login(Client client) {
        System.out.println("---------- *** LOGIN *** ---------");
        int atmNumber = InputUtil.login("ATM Number");
        int atmPinNumber = InputUtil.login("ATM PIN Number");
        if (atmNumber == client.getAtmNumber() && atmPinNumber == client.getAtmPinNumber()) {
            menu();
        } else {
            System.out.println("ATM NUMBER or ATM PIN NUMBER WRONG");
            System.exit(0);
        }
    }

    public void menu() {
        while (true) {
            System.out.println("---------- *** WELCOME TO ATM MACHINE *** ---------");
            System.out.println("1. View Total Balance");
            System.out.println("2. View Add Deposit");
            System.out.println("3. View Add Withdraw");
            System.out.println("4. View History");
            System.out.println("5. Exit Application");

            int menuInput = InputUtil.menuInput("Select Menu");

            if (menuInput == 1) {
                viewTotalBalance();
            } else if (menuInput == 2) {
                viewAddDeposit();
            } else if (menuInput == 3) {
                viewAddWithdraw();
            } else if (menuInput == 4) {
                viewShowAllHistory();
            } else if (menuInput == 5) {
                System.out.println("Thanks for using my application");
                System.exit(0);
            } else {
                System.out.println("Command is unexpected (FORCE EXIT APPLICATION)");
                System.exit(0);
            }
        }
    }

    public void viewTotalBalance() {
        clientService.totalBalance();
    }

    public void viewAddDeposit() {
        System.out.println("---------- *** ADD DEPOSIT *** ---------");
        int deposit = InputUtil.depositAndWithdrawInput("Deposit");
        String message = InputUtil.messageDepositAndWithdrawInput("Message");
        clientService.addDeposit(deposit, message);
    }

    public void viewAddWithdraw() {
        System.out.println("---------- *** ADD WITHDRAW *** ---------");
        int withdraw = InputUtil.depositAndWithdrawInput("Withdraw");
        String message = InputUtil.messageDepositAndWithdrawInput("Message");
        clientService.addWithdraw(withdraw, message);
    }

    public void viewShowAllHistory() {
        System.out.println("---------- *** ALL HISTORY *** ---------");
        clientService.showAllHistory();
    }
}
