package test.view;

import repository.ClientRepository;
import repository.ClientRepositoryImpl;
import service.ClientService;
import service.ClientServiceImpl;
import view.ClientView;

public class ClientViewTest {
    private static final ClientRepository clientRepository = new ClientRepositoryImpl();
    private static final ClientService clientService = new ClientServiceImpl(clientRepository);
    private static final ClientView clientView = new ClientView(clientService);
    public static void main(String[] args) {
        testViewAddWithdraw();
    }

    public static void testViewMenu() {
        clientView.menu();
    }

    public static void testViewAddDeposit() {
        clientView.viewAddDeposit();
        clientView.viewAddDeposit();
        clientService.showAllHistory();
    }

    public static void testViewAddWithdraw() {
        clientService.addDeposit(10000, "Saving");
        clientView.viewAddWithdraw();
        clientView.viewAddWithdraw();
        clientService.showAllHistory();
        clientService.totalBalance();
    }

    public static void testViewShowAllHistory() {
        clientService.addDeposit(1000, "Saving");
        clientView.viewShowAllHistory();
    }
}
