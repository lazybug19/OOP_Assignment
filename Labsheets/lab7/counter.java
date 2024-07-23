class Counter {
    private int count = 0;

    public void Count() {
        for (int i = 0; i < 1000; i++) {
            count++;
        }
        System.out.println(Thread.currentThread().getName() + " " + count);
    }
}

public class counter {
    // we create an array of threads for multithreaded counter
    public static void main(String[] args) {
        Counter count = new Counter();
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> count.Count());
            threads[i].start();

        }
    }
}
