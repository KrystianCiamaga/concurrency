package pl.dominisz.example02;

public class UnsafeCounter implements Counter {

    private int counter;

    public void increment() {
        counter++;
    }

    public void decrement() {
        counter--;
    }

    public int getCounter() {
        return counter;
    }
}
