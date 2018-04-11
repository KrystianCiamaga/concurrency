package pl.dominisz.example05;

import java.util.Random;

public class Producer extends Thread {

    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        Random random = new Random();

        while (true) {
            int number = random.nextInt(100);
            System.out.println("Producer inserted " + number);
            buffer.put(number);
            try {
                sleep(400);
            } catch (InterruptedException ex) {
            }
        }
    }

}

