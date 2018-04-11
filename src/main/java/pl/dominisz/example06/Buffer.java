package pl.dominisz.example06;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
    private Lock lock;
    private Condition notFull;
    private Condition notEmpty;
    private int[] elements;
    private int inIndex;
    private int outIndex;
    private int count;

    public Buffer(int size) {
        elements = new int[size];
        lock = new ReentrantLock();
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
        inIndex = 0;
        outIndex = 0;
        count = 0;
    }

    public void put(int element) throws InterruptedException {
        lock.lock();
        try {
            while (count == elements.length) {
                notFull.await();
            }
            elements[inIndex] = element;
            inIndex = (inIndex + 1) % elements.length;
            count++;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public int get() throws InterruptedException {
        int element;
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            element = elements[outIndex];
            outIndex = (outIndex + 1) % elements.length;
            count--;
            notFull.signal();
            return element;
        } finally {
            lock.unlock();
        }
    }

}
