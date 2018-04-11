package pl.dominisz.example06;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer extends Thread {
    private Buffer buffer;
    private int id;

    public Consumer(int id, Buffer buffer) {
        this.id = id;
        this.buffer = buffer;
    }

    public void run() {
        int number;

        while (true) {
            try {
                number = buffer.get();
                System.out.println("Consumer " + id + " got " + number);
                sleep(250);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
