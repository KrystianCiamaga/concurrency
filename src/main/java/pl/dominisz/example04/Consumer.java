package pl.dominisz.example04;

import java.util.concurrent.Semaphore;

class Consumer extends Thread {

    private Buffer buffer;
    private Semaphore elements;
    private Semaphore freeSpace;

    public Consumer(Buffer buffer, Semaphore elements, Semaphore freeSpace) {
        this.buffer = buffer;
        this.elements = elements;
        this.freeSpace = freeSpace;
    }

    public void run() {
        while (true) {
            elements.acquireUninterruptibly();
            int element = buffer.get();
            System.out.println("Read from buffer " + element);
            freeSpace.release();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

