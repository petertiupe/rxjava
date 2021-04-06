package de.tiupe.executor;

import java.sql.SQLOutput;
import java.util.ConcurrentModificationException;
import java.util.concurrent.*;

public class ExecutorRunnableExample {

    public static void main(String[] args) throws InterruptedException {
        Callable c1 = new Callable<Integer>() {
            @Override public Integer call() {
                try {
                    Thread.sleep( 600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return 6 + 7;
            }
        };

        Callable c2 = new Callable<Integer>() {
            @Override public Integer call() {
                try {
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
               return 7 + 8;
            }
        };

        ExecutorService executor = Executors.newCachedThreadPool();

        Future future1 = executor.submit(c1);
        Future future2 = executor.submit(c2);
        try {
            Integer i1 = (Integer) future1.get();
            Integer i2 = (Integer) future2.get();
            System.out.println(i1 + i2);
        } catch(ExecutionException cmex) {

        }

        System.out.println("Pause beginnt ...");
        Thread.sleep( 5000 );
        System.out.println("Pause beendet ...");
        executor.shutdown();
    }
}
