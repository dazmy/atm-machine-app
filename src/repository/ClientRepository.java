package repository;

import java.util.Map;

public interface ClientRepository {
    double balance();

    boolean deposit(double deposit, String message);

    boolean withdraw(double withdraw, String message);

    Map<String, String> history();
}
