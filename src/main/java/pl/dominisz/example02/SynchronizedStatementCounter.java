package pl.dominisz.example02;

public class SynchronizedStatementCounter implements Counter {

    private int counter;

    public void increment() {

        synchronized (this) {
            counter++;
        }
    }

    public void decrement() {
        synchronized (this) {
            counter--;
        }
    }

    public int getCounter() {
        return counter;
    }
}
