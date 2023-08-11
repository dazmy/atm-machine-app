package service;

public interface ClientService {
    void totalBalance();

    void addDeposit(double deposit, String message);

    void addWithdraw(double withdraw, String message);

    void showAllHistory();
}
