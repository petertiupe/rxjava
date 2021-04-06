package de.tiupe.javafuture;

import org.w3c.dom.ls.LSOutput;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class FutureExample {


    public static void main(String[] args)  {
        int counter = 0;

        while(counter < 10) {
            final CompletableFuture<Integer> future1 =
                    CompletableFuture.supplyAsync(() -> {
                        try {
                            Long lg = getRandLong();
                            Thread.sleep(lg);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return 5 + 6;
                    });
            final CompletableFuture<Integer> future2 =
                    CompletableFuture.supplyAsync(() -> {

                        try {
                            Long lg = getRandLong();
                            Thread.sleep(lg);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return 7 + 8;
                    });
            CompletableFuture<Object> result = CompletableFuture.anyOf(future1, future2);
            try {
                Integer res = (Integer) result.get();
                System.out.println(res);
            } catch (Exception ex) {

            }
            counter ++;
        }
    }

    static Long getRandLong() {
        long leftLimit = 1L;
        long rightLimit = 1000;
        long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
        return generatedLong;
    }
}
