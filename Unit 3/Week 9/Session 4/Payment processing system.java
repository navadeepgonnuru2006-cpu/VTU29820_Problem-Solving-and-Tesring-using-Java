
import java.util.Scanner;

interface Payment {
    void pay(double amount);
}

class CreditCardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("CreditCard payment initiated.");
    }
}

class UPIPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("UPI payment initiated.");
    }
}

class NetBankingPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("NetBanking payment initiated.");
    }
}

abstract class PaymentProcessor {
    abstract double processPayment(Payment payment, double amount);
}

class OnlinePaymentProcessor extends PaymentProcessor {
    @Override
    double processPayment(Payment payment, double amount) {
        double fee;

        if (payment instanceof CreditCardPayment) {
            fee = amount * 0.02;
        } else if (payment instanceof UPIPayment) {
            fee = amount * 0.01;
        } else if (payment instanceof NetBankingPayment) {
            fee = amount * 0.015;
        } else {
            fee = 0;
        }

        payment.pay(amount);
        return amount + fee;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        OnlinePaymentProcessor processor = new OnlinePaymentProcessor();

        for (int i = 0; i < N; i++) {
            int paymentType = sc.nextInt();
            double amount = sc.nextDouble();

            Payment payment;
            String typeName;

            switch (paymentType) {
                case 1:
                    payment = new CreditCardPayment();
                    typeName = "CreditCard";
                    break;
                case 2:
                    payment = new UPIPayment();
                    typeName = "UPI";
                    break;
                case 3:
                    payment = new NetBankingPayment();
                    typeName = "NetBanking";
                    break;
                default:
                    continue;
            }

            double finalAmount = processor.processPayment(payment, amount);

            System.out.printf("%s %.2f%n", typeName, finalAmount);
        }

        sc.close();
    }
}
