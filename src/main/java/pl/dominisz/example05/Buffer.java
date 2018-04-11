package pl.dominisz.example05;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {

    private Queue<Integer> buffer;
    private int maxSize;

    public Buffer(int maxSize) {
        buffer = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public synchronized void put(int element) {
        while (buffer.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
        buffer.add(element);
        notifyAll();
    }

    public synchronized int get() {
        while (buffer.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
        int element = buffer.remove();
        notifyAll();
        return element;
    }

}

