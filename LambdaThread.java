import java.util.*;

interface FunctionalInterface<T> {
    T LambdaFunc(T t);
}

class NumericException extends Exception {
    NumericException() {
        super("Invalid number entered");
    }
}

public class LambdaThread {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String s = sc.next();
    // sc.close() -> cannot be used outside constructor/method

    FunctionalInterface<Integer> factorial = (num) -> {
        if (num < 0)
            try {
                throw new NumericException();
            } catch (NumericException e) {
                e.printStackTrace();
            }
        int result = 1;
        for (int i = 2; i <= num; i++)
            result *= i;
        return result;
    };
    FunctionalInterface<String> reverse = (str) -> {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--)
            result += str.charAt(i); // NOT s[i] -> not cpp
        return result;
    };

    Runnable r1 = () -> {
        System.out.println("Factorial of " + String.valueOf(n) + " : " + factorial.LambdaFunc(n));
    };
    Runnable r2 = () -> {
        System.out.println("Reverse of " + s + " : " + reverse.LambdaFunc(s));
    };

    // will throw error if you try to run this code outside of a constructor
    public LambdaThread() {
        sc.close();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        t2.start();
    }

    public static void main(String[] args) {
        new LambdaThread();
    }
}
