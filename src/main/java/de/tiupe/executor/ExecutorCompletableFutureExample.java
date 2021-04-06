package de.tiupe.executor;

import java.util.concurrent.*;

public class ExecutorCompletableFutureExample {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Integer> integerCompletableFuture1 = CompletableFuture.supplyAsync(() -> 7 + 8);
        CompletableFuture<Integer> integerCompletableFuture2 = CompletableFuture.supplyAsync(() -> 6 + 7);

        integerCompletableFuture2.handle((a, b) -> {
            return integerCompletableFuture1.handle((d, e) -> {
                Integer ergebnis = a + d;
                System.out.println( ergebnis );
                return ergebnis;
            });
        });
    }
}
