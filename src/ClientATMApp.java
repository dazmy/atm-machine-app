import entity.Client;
import repository.ClientRepository;
import repository.ClientRepositoryImpl;
import service.ClientService;
import service.ClientServiceImpl;
import view.ClientView;

public class ClientATMApp {
    public static void main(String[] args) {
        Client client = new Client(112233, 123123);
        runApp(client);
    }

    public static void runApp(Client client) {
        ClientRepository clientRepository = new ClientRepositoryImpl(client);
        ClientService clientService = new ClientServiceImpl(clientRepository);
        ClientView clientView = new ClientView(clientService);
        clientView.login(client);
    }
}
