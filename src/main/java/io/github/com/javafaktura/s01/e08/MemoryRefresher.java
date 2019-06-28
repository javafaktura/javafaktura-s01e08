package io.github.com.javafaktura.s01.e08;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MemoryRefresher {
    private static Optional<Integer> validatedRange(int x) {
        return x > 0 ? Optional.of(x) : Optional.empty();
    }

    public static void main(String[] args) {
        System.out.println(validatedRange(10));
        System.out.println(validatedRange(-1));

        System.out.println(validatedRange(10).orElse(0));
        System.out.println(validatedRange(-1).orElse(0));




        var numbers = Stream.iterate(-10, x -> x + 1).dropWhile(x -> x <= 0).limit(10);
        System.out.println(numbers.collect(toList()));





        var f1 = CompletableFuture.completedFuture(1);
        var f2 = CompletableFuture.failedFuture(new Exception("Puff!"));

        f1.thenAccept(System.out::println).orTimeout(1, TimeUnit.DAYS);
        f2.thenAccept(System.out::println).whenComplete((x, t) -> System.out.println(t.getMessage()));
    }
}
