import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            int n = input.nextInt();

            PrimeSumCalculation primeSum = new PrimeSumCalculation(n);
            MultiplesSumCalculation multiplesSum = new MultiplesSumCalculation(n);

            if (n > 500000000) {
                throw new IllegalArgumentException("Wrong argument provided");
            }
            if (n < 10) {
                throw new IllegalArgumentException("Wrong argument provided");
            }

            List<Thread> PrimeThreads = new ArrayList<Thread>();
            PrimeThreads.add(new Thread(() -> primeSum.PrimeSum(n)));
            for (Thread primeThread : PrimeThreads) {
                primeThread.start();
            }

            Thread multipleThread = new Thread(() -> multiplesSum.MultiplesSum(n));
            multipleThread.start();

            for (Thread primeThread : PrimeThreads) {
                primeThread.join();
            }
            multipleThread.join();

            System.out.println(primeSum.getPrimeSum() + " " + multiplesSum.getMultiplesSum());

            input.close();
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: Error in string to number conversion");
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: Wrong argument provided");
        } catch (InterruptedException e) {
            System.out.println("InterruptedException: Thread interrupted");
        }
    }
}

class PrimeSumCalculation {
    private int n;
    private long sum;

    PrimeSumCalculation(int n) {
        this.n = n;
        this.sum = 0;
    }

    synchronized void PrimeSum(int n) {
        int[] sirve = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            sirve[i] = 1;
        }

        sirve[0] = 1;
        sirve[1] = 1;
        sirve[2] = 1;

        for (int i = 2; i <= n; i++) {
            if (sirve[i] == 1) {
                sum += i;

                for (int j = i; j <= n; j += i) {
                    sirve[j] = 0;
                }
            }
        }

    }

    public long getPrimeSum() {
        return sum;
    }
}

class MultiplesSumCalculation {
    private int n;
    private long sum;

    MultiplesSumCalculation(int n) {
        this.n = n;
        this.sum = 0;
    }

    synchronized void MultiplesSum(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                sum += i;
            }
        }
    }

    public long getMultiplesSum() {
        return sum;
    }

}