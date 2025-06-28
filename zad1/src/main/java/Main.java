import model.BankAccount;

public class Main {

  public static void main(String[] args) {
    BankAccount acc1 = new BankAccount("Иван Иванов");
    BankAccount acc2 = new BankAccount("Петр Петров");

    System.out.println("Попытка депозита 1000: " + acc1.deposit(1000));
    System.out.println("Баланс acc1: " + acc1.getBalance());

    System.out.println("Попытка снятия 500: " + acc1.withdraw(500));
    System.out.println("Баланс acc1: " + acc1.getBalance());

    System.out.println("Перевод 300 с acc1 на acc2: " + acc1.transfer(acc2, 300));
    System.out.println("Баланс acc1: " + acc1.getBalance());
    System.out.println("Баланс acc2: " + acc2.getBalance());

    System.out.println("Попытка перевода 500 (больше баланса): " + acc1.transfer(acc2, 500));
    System.out.println("Баланс acc1 после неудачного перевода: " + acc1.getBalance());
  }
}
