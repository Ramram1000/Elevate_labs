import java.util.Scanner;

class Calculator {
    static int add(int a1, int a2) {
        return a1 + a2;
    }

    static int sub(int s1, int s2) {
        return s1 - s2;
    }

    static int mul(int m1, int m2) {
        return m1 * m2;
    }

    static int div(int d1, int d2) {
        return d1 / d2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Calculator Menu ---");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter two numbers for addition: ");
                    int a1 = scanner.nextInt();
                    int a2 = scanner.nextInt();
                    System.out.println("Result = " + Calculator.add(a1, a2));
                    break;

                case 2:
                    System.out.print("Enter two numbers for subtraction: ");
                    int s1 = scanner.nextInt();
                    int s2 = scanner.nextInt();
                    System.out.println("Result = " + Calculator.sub(s1, s2));
                    break;

                case 3:
                    System.out.print("Enter two numbers for multiplication: ");
                    int m1 = scanner.nextInt();
                    int m2 = scanner.nextInt();
                    System.out.println("Result = " + Calculator.mul(m1, m2));
                    break;

                case 4:
                    System.out.print("Enter two numbers for division: ");
                    int d1 = scanner.nextInt();
                    int d2 = scanner.nextInt();
                    if (d2 != 0) {
                        System.out.println("Result = " + Calculator.div(d1, d2));
                    } else {
                        System.out.println("Error: Division by zero not allowed.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
