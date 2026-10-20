
import java.util.Scanner;

class Vehicle {
    String vehicleNumber;
    double rentPerDay;

    Vehicle(String vehicleNumber, double rentPerDay) {
        this.vehicleNumber = vehicleNumber;
        this.rentPerDay = rentPerDay;
    }

    double calculateRent(int days) {
        return rentPerDay * days;
    }
}

class Car extends Vehicle {
    Car(String vehicleNumber, double rentPerDay) {
        super(vehicleNumber, rentPerDay);
    }

    @Override
    double calculateRent(int days) {
        return rentPerDay * days;
    }
}

class Bike extends Vehicle {
    Bike(String vehicleNumber, double rentPerDay) {
        super(vehicleNumber, rentPerDay);
    }

    @Override
    double calculateRent(int days) {
        return rentPerDay * days * 0.90;
    }
}

class Truck extends Vehicle {
    Truck(String vehicleNumber, double rentPerDay) {
        super(vehicleNumber, rentPerDay);
    }

    @Override
    double calculateRent(int days) {
        return rentPerDay * days * 1.20;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int vehicleType = sc.nextInt();
            String vehicleNumber = sc.next();
            double rentPerDay = sc.nextDouble();
            int days = sc.nextInt();

            Vehicle vehicle;

            switch (vehicleType) {
                case 1:
                    vehicle = new Car(vehicleNumber, rentPerDay);
                    break;
                case 2:
                    vehicle = new Bike(vehicleNumber, rentPerDay);
                    break;
                case 3:
                    vehicle = new Truck(vehicleNumber, rentPerDay);
                    break;
                default:
                    continue;
            }

            double totalRent = vehicle.calculateRent(days);

            System.out.printf("%s %.2f%n",
                    vehicle.vehicleNumber, totalRent);
        }

        sc.close();
    }
}
