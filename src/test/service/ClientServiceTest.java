package test.service;

import repository.ClientRepository;
import repository.ClientRepositoryImpl;
import service.ClientService;
import service.ClientServiceImpl;

public class ClientServiceTest {
    private final static ClientRepository clientRepository = new ClientRepositoryImpl();
    private final static ClientService clientService = new ClientServiceImpl(clientRepository);
    public static void main(String[] args) {
        testAddWithdraw();
    }

    public static void testTotalBalance() {
        clientService.totalBalance();
    }

    public static void testAddDeposit() {
        clientService.addDeposit(1000, "Saving");
        clientService.totalBalance();
    }

    public static void testAddWithdraw() {
        clientService.addWithdraw(1000, "Withdraw 1");
        clientService.addWithdraw(1000, "Withdraw 2");
        clientService.addWithdraw(1000, "Withdraw 3");
        clientService.totalBalance();
        clientService.showAllHistory();
    }

    public static void testShowAllHistory() {
        clientService.addDeposit(1000, "Saving 1");
        clientService.addDeposit(1000, "Saving 2");
        clientService.addDeposit(1000, "Saving 3");
        clientService.addDeposit(1000, "Saving 4");
        clientService.addDeposit(1000, "Saving 5");
        clientService.totalBalance();
        clientService.showAllHistory();
    }
}
