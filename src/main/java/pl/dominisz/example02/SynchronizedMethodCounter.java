package pl.dominisz.example02;

public class SynchronizedMethodCounter implements Counter {

    private int counter;

    public synchronized void increment() {
        counter++;
    }

    public synchronized void decrement() {
        counter--;
    }

    public int getCounter() {
        return counter;
    }
}
