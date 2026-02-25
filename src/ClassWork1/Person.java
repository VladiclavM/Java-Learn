package ClassWork1;

import java.util.HashMap;
import java.util.Map;

public abstract class Person implements Finansable {
    private int id;
    private String name;
    private double balance;
    // HashMap для задач (ключ - ID задачи, значение - описание или статус)
    private Map<Integer, String> tasks = new HashMap<>();

    public Person(int id, String name, double initialBalance) {
        this.id = id;
        this.name = name;
        this.balance = initialBalance;
    }

    // Метод, который "дает" деньги (пополнение баланса)
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println(name + " получил: " + amount + ". Текущий баланс: " + balance);
        }
    }

    // Метод, который "убирает" деньги (списание с баланса)
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            this.balance -= amount;
            System.out.println(name + " потратил: " + amount + ". Текущий баланс: " + balance);
        } else {
            System.out.println("Недостаточно средств у " + name);
        }
    }

    public void payTo(Person recipient, double amount) {
        // 1. Проверяем, хватает ли денег у того, кто платит
        if (this.getBalance() >= amount) {
            // 2. Убираем деньги у текущего объекта (Клиента)
            this.makePayment(amount);

            // 3. Добавляем деньги получателю (Мастеру)
            recipient.receivePayment(amount);

            System.out.println("[Успех] Перевод выполнен: " + amount + " от " + this.getName() + " к " + recipient.getName());
        } else {
            // 4. Если денег нет — выводим ошибку
            System.out.println("[Ошибка] У " + this.getName() + " недостаточно средств! Нужно: " + amount + ", есть: " + getBalance());
        }
    }

    // Геттеры для полей
    public int getId() { return id; }
    public String getName() { return name; }
    public double getBalance() { return balance; }
    public Map<Integer, String> getTasks() { return tasks; }

    // Реализуем метод получения денег из интерфейса
    @Override
    public void receivePayment(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println(name + " получил оплату: " + amount);
        }
    }

    // Реализуем метод совершения платежа из интерфейса
    @Override
    public void makePayment(double amount) {
        if (amount > 0 && balance >= amount) {
            this.balance -= amount;
            System.out.println(name + " оплатил сумму: " + amount);
        } else {
            System.out.println("Ошибка платежа: недостаточно средств у " + name);
        }
    }
}