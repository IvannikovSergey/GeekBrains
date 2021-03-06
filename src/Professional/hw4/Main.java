package Professional.hw4;

public class Main {

    volatile int status = 0;
    public static void main(String[] args) {
        Main lock = new Main();
        Thread t1 = new Thread(new Threader("A", lock,1));
        Thread t2 = new Thread(new Threader("B", lock,2));
        Thread t3 = new Thread(new Threader("C", lock,3));
        t1.start();
        t2.start();
        t3.start();
    }
}

class Threader implements Runnable {

    private final String message;
    private final Main lock;
    private final int p;

    Threader(String text, Main obj, int p) {
        message = text;
        this.lock = obj;
        this.p = p;
    }

    @Override
    public void run() {

        while(lock.status < 13) {
            synchronized (lock) {

                while(!((lock.status % 3) == 0) && p == 1){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                while(!((lock.status % 3) == 1) && p == 2){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                while(!((lock.status % 3) == 2) && p == 3){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(message);
                lock.status++;
                if ((lock.status % 3) == 0) System.out.println("---");
                lock.notifyAll();
            }
        }
    }
}