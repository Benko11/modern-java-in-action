package Threads;

public class Introduction {
    public static void process(Runnable r) {
        r.run();
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1: 93pigeons");                
            }
        });
        
        Thread t2 = new Thread(() -> System.out.println("t2: 93pigeons"));
        
        Thread t3 = new Thread(() -> {
            System.out.println("t3: 93pigeons");
        });

        t1.start();
        t2.start();
        t3.start();

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("r1: 93pigeons");                
            }
        };

        Runnable r2 = () -> System.out.println("r2: 93pigeons");

        process(r1);
        process(r2);
        process(() -> System.out.println("r3: 93pigeons"));
    }
}
