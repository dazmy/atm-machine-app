package service;

import repository.ClientRepository;

import java.util.Map;

public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void totalBalance() {
        System.out.print("Total Balance in Your Account is : $");
        System.out.println(clientRepository.balance());
    }

    @Override
    public void addDeposit(double deposit, String message) {
        if (deposit != 0 && message != null) {
            boolean isSuccess = clientRepository.deposit(deposit, message);
            if (isSuccess) {
                System.out.println("Success add deposit $" + deposit);
            } else System.out.println("Failed add deposit");
        } else System.out.println("Deposit Can't be 0 or Message Can't Be Blank");
    }

    @Override
    public void addWithdraw(double withdraw, String message) {
        if (withdraw != 0 && message != null) {
            try {
                boolean isSuccess = clientRepository.withdraw(withdraw, message);
                if (isSuccess) System.out.println("Success");
                else System.out.println("Failed");
            } catch (IllegalArgumentException e) {
                System.out.println("Failed : " + e.getMessage());
            }
        } else System.out.println("Withdraw Can't be 0 or Message Can't Be Blank");
    }

    @Override
    public void showAllHistory() {
        if (!clientRepository.history().isEmpty()) {
            for (Map.Entry<String, String> item : clientRepository.history().entrySet()) {
                System.out.println(item.getKey() + " - " + item.getValue());
            }
        } else {
            System.out.println("Empty History");
        }
    }
}
