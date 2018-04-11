package pl.dominisz.example00;

public class Example00 extends Thread {

    private String name;
    private int count;

    public Example00(String name, int count) {
        super();
        this.name = name;
        this.count = count;
    }

    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println("My name is " + name);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread01 = new Example00("Albert", 5);
        Thread thread02 = new Example00("Bartlomiej", 10);
        Thread thread03 = new Example00("Cezary", 7);

        System.out.println("Thread state " + thread01.getState());
        thread01.start();
        thread02.start();
        thread03.start();
        System.out.println("Threads started");
        System.out.println("Thread state " + thread01.getState());

        thread01.join();
        thread02.join();
        thread03.join();
        System.out.println("Threads finished");
        System.out.println("Thread state " + thread01.getState());
    }
}
