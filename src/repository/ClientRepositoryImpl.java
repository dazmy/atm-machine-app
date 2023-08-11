package repository;

import entity.Client;

import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class ClientRepositoryImpl implements ClientRepository {
    private final Client client;

    public ClientRepositoryImpl() {
        this.client = new Client();
    } // for testing

    public ClientRepositoryImpl(Client client) {
        this.client = client;
    }

    @Override
    public double balance() {
        return client.getBalance();
    }

    @Override
    public boolean deposit(double deposit, String message) {
        if (deposit > 0) {
            client.setBalance(client.getBalance() + deposit);
            Date date = new Date(System.currentTimeMillis());
            // UUID date = UUID.randomUUID(); // for testing
            client.addHistory(date.toString(), message + " - $" + deposit + " - DEPOSIT");
            return true;
        }
        return false;
    }

    @Override
    public boolean withdraw(double withdraw, String message) {
        if (withdraw <= 0 || withdraw > client.getBalance()) {
            return false;
        }
        if (withdraw % 500 == 0) {
                client.setBalance(client.getBalance() - withdraw);
                Date date = new Date(System.currentTimeMillis());
                // UUID date = UUID.randomUUID(); // for testing
                client.addHistory(date.toString(), message + " - $" + withdraw + " - WITHDRAW");
                return true;
        } else {
            throw new IllegalArgumentException("Withdraw must be a multiple of 500");
        }
    }

    @Override
    public Map<String, String> history() {
        return Collections.unmodifiableMap(client.getHistories());
    }
}
