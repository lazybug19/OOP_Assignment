import java.util.Scanner;

class Login {
    private String name; // read-only : only getter no setter
    private int id; // read-only : only getter no setter
    private int pin; // rw : getter, setter

    Login(String name, int id, int pin) {
        this.name = name;
        this.id = id;
        this.pin = pin;
    }

    String getName() {
        return name;
    }

    int getID() {
        return id;
    }

    int getPin() {
        return pin;
    }

    void changePIN(int pin) {
        this.pin = pin;
    }

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int users = sc.nextInt();
        System.out.println("User info");
        System.out.println("-------------");
        while (users > 0) {
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Unique ID: ");
            int id = sc.nextInt();
            System.out.print("Name: ");
            int pin = sc.nextInt();
            Login login = new Login(name, id, pin);
            users--;
        }

        // System.out.println("New pin: ");
        // int pin = sc.nextInt();
        // db.changePIN(pin);
        System.out.println("1. Login");
        System.out.println("2. Change PIN");
        System.out.println("3. Exit");
        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Enter Unique ID: ");
                int id = sc.nextInt();
                System.out.print("Enter PIN: ");
                int pin = sc.nextInt();
                break;

            default:
                break;
        }

    }
}
