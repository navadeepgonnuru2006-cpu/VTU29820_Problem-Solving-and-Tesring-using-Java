import java.util.Scanner;

class BankAccount {
    int balance = 0;

    void deposit(int amount) {
        balance += amount;
    }

    void withdraw(int amount) {
        balance -= amount;
    }

    int getBalance() {
        return balance;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount();

        System.out.print("Enter number of transactions: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter transaction type (deposit/withdraw): ");
            String type = sc.next();

            System.out.print("Enter amount: ");
            int amount = sc.nextInt();

            if (type.equalsIgnoreCase("deposit")) {
                account.deposit(amount);
            } else if (type.equalsIgnoreCase("withdraw")) {
                account.withdraw(amount);
            } else {
                System.out.println("Invalid transaction type!");
            }
        }

        System.out.println(account.getBalance());

        sc.close();
    }
}
