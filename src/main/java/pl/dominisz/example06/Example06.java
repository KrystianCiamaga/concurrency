package pl.dominisz.example06;

public class Example06 {

    public static void main(String[] args) {
        Buffer buffer = new Buffer(20);
        Producer producer = new Producer(1, buffer);
        Consumer consumer = new Consumer(100, buffer);
        producer.start();
        consumer.start();
    }

}
