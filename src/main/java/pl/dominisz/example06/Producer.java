package pl.dominisz.example06;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer extends Thread {
    private Buffer buffer;
    private int id;

    public Producer(int id, Buffer buffer) {
        this.id = id;
        this.buffer = buffer;
    }

    public void run() {
        Random generator = new Random();
        int number;

        while (true) {
            number = generator.nextInt();
            try {
                buffer.put(number);
                System.out.println("Producer " + id + " put " + number);
                sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
