package entity;

import java.util.LinkedHashMap;
import java.util.Map;

public class Client {
    private int atmNumber;
    private int atmPinNumber;
    private double balance;
    private final Map<String, String> history = new LinkedHashMap<>();

    public Client() {} // for testing

    public Client(int atmNumber, int atmPinNumber) {
        this.atmNumber = atmNumber;
        this.atmPinNumber = atmPinNumber;
    }

    public int getAtmNumber() {
        return atmNumber;
    }

    public int getAtmPinNumber() {
        return atmPinNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Map<String, String> getHistories() {
        return history;
    }

    public void addHistory(String history, String message) {
        this.history.put(history, message);
    }
}
