package pl.dominisz.example02;

public class Example02 {

    public static final int LOOP_SIZE = 20_000_000;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Unsafe counter");
        incrementAndDecrement(new UnsafeCounter());
        System.out.println("Synchronized method counter");
        incrementAndDecrement(new SynchronizedMethodCounter());
        System.out.println("Synchronized statement counter");
        incrementAndDecrement(new SynchronizedStatementCounter());

    }

    private static void incrementAndDecrement(Counter counter) throws InterruptedException {
        Thread incrementThread = new Thread(new IncrementRunnable(counter));
        Thread decrementThread = new Thread(new DecrementRunnable(counter));
        long startTime = System.currentTimeMillis();
        incrementThread.start();
        decrementThread.start();
        incrementThread.join();
        decrementThread.join();
        long endTime = System.currentTimeMillis();
        System.out.println("Counter: " + counter.getCounter());
        System.out.println("Time: " + (endTime - startTime));
    }

}
