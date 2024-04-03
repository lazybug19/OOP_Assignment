import java.io.*;
import java.util.*;

class UserAccount {
    private int userBalance = 0;
    private boolean depositFlag = true;

    synchronized void withdraw(int amount) {
        while (depositFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
        depositFlag = true;
        if (userBalance < amount) {
            System.out.println("java.lang.ArithmeticException: Illegal mathematical operation");
            return;
        }
        userBalance -= amount;
        System.out.println(userBalance);
        notify();
    }

    synchronized void deposit(int amount) {
        while (!depositFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
        depositFlag = false;
        userBalance += amount;
        System.out.println(userBalance);
        notify();
    }

}

public class Bank {
    public static void main(String[] args) {
        UserAccount account = new UserAccount();
        List<Thread> threads = new ArrayList<>();

        int l = 0;
        try {
            File file = new File(args[0]);

            Scanner scanner = new Scanner(file);

            List<String> inputLineStrings = new ArrayList<>();
            while (scanner.hasNextLine()) {
                inputLineStrings.add(scanner.nextLine());
                l++;
            }

            for (int i = 0; i < l; i++) {
                String inputLine = inputLineStrings.get(i);
                char transaction = inputLine.charAt(0);
                int amount = Integer.parseInt(inputLine.substring(1));

                switch (transaction) {
                    case 'd':
                        threads.add(new Thread(() -> account.deposit(amount)));
                        break;
                    case 'w':
                        threads.add(new Thread(() -> account.withdraw(amount)));
                        break;
                    default:
                        System.out.println("java.lang.IllegalArgumentException: Wrong argument provided");
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("java.io.FileNotFoundException: Error opening the specified file");
        } catch (NumberFormatException e) {
            System.out.println("java.lang.NumberFormatException: Error in string to number conversion");
        }

        for (int i = 0; i < threads.size(); i++) {
            threads.get(i).start();
        }

        for (int i = 0; i < threads.size(); i++) {
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}