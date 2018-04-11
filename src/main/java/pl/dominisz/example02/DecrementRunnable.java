package pl.dominisz.example02;

import static pl.dominisz.example02.Example02.LOOP_SIZE;

public class DecrementRunnable implements Runnable {

    private Counter counter;

    public DecrementRunnable(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < LOOP_SIZE; i++) {
            counter.decrement();
        }
    }

}
