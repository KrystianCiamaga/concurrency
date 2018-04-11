package pl.dominisz.example04;

import java.util.concurrent.Semaphore;

public class Example04 {

    private static final int BUFFER_SIZE = 5;

    public static void main(String[] args) {
        Semaphore elements = new Semaphore(0);
        Semaphore freeSpace = new Semaphore(BUFFER_SIZE);
        Buffer buffer = new Buffer(BUFFER_SIZE);
        Producer producer = new Producer(buffer, elements, freeSpace);
        Consumer consumer = new Consumer(buffer, elements, freeSpace);
        producer.start();
        consumer.start();
    }

}

