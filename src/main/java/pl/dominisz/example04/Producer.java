package pl.dominisz.example04;

import java.util.Random;
import java.util.concurrent.Semaphore;

class Producer extends Thread {

    private Buffer buffer;
    private Semaphore elements;
    private Semaphore freeSpace;

    public Producer(Buffer buffer, Semaphore elements, Semaphore freeSpace) {
        this.buffer = buffer;
        this.elements = elements;
        this.freeSpace = freeSpace;
    }

    public void run() {
        Random random = new Random();
        while (true) {
            int element = random.nextInt(1000);
            freeSpace.acquireUninterruptibly();
            buffer.put(element);
            System.out.println("Saved to buffer " + element);
            elements.release();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

