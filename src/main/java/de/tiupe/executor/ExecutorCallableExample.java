package de.tiupe.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorCallableExample {
    // the programm starts here
    public static void main(String[] args) throws InterruptedException {
        Runnable r1 = new Runnable() {
            @Override public void run() {
                try {
                    Thread.sleep( 600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println( "A1 " + Thread.currentThread() );
                System.out.println( "A2 " + Thread.currentThread() );
            }
        };

        Runnable r2 = new Runnable() {
            @Override public void run() {
                try {
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println( "B1 " + Thread.currentThread() );
                System.out.println( "B2 " + Thread.currentThread() );
            }
        };

        ExecutorService executor = Executors.newCachedThreadPool();

        executor.submit( r1 );
        executor.submit( r2 );

        System.out.println("Pause beginnt ...");
        Thread.sleep( 5000 );
        System.out.println("Pause beendet ...");

        executor.execute( r1 );
        executor.execute( r2 );

        executor.shutdown();
    }

}
