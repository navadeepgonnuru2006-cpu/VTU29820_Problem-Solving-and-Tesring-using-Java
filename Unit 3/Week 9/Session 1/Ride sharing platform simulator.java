import java.util.Scanner;

abstract class Vehicle {
    abstract int calculateFare(int distance);
}

class Bike extends Vehicle {
    @Override
    int calculateFare(int distance) {
        return distance * 5;
    }
}

class Auto extends Vehicle {
    @Override
    int calculateFare(int distance) {
        return distance * 12;
    }
}

class Cab extends Vehicle {
    @Override
    int calculateFare(int distance) {
        return distance * 12;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int distance = sc.nextInt();

            Vehicle vehicle;

            switch (type.toLowerCase()) {
                case "bike":
                    vehicle = new Bike();
                    break;

                case "auto":
                    vehicle = new Auto();
                    break;

                case "cab":
                    vehicle = new Cab();
                    break;

                default:
                    System.out.println("Invalid vehicle type");
                    continue;
            }

            try {
                System.out.println(vehicle.calculateFare(distance));
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }

        sc.close();
    }
}
