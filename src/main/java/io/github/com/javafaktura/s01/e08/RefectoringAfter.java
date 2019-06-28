package io.github.com.javafaktura.s01.e08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static io.github.com.javafaktura.s01.e08.guts.Input.A_LIST;


public class RefectoringAfter {
    public static void main(String[] args) {
        // printList
        printList(A_LIST);












        // product
        Integer product = makeProduct(A_LIST);
        System.out.println(product);

        // sum
        Integer sum = makeSum(A_LIST);
        System.out.println(sum);














        // obsługa IO - panowanie nad efektami
        withResource(
                () -> new BufferedReader(new InputStreamReader(RefectoringAfter.class.getResourceAsStream("/sample.txt"))),
                andThen(RefectoringAfter::screamAtMe, RefectoringAfter::show)
        );


    }




    private static <T> void printList(List<T> what) {
        forEach(what, System.out::println);
    }

    private static <T> void forEach(List<T> what, Consumer<T> how) {
        for (T x : what) {
            how.accept(x);
        }
    }






    private static Integer makeProduct(List<Integer> list) {
        return reduce(list, (a, b) -> a * b, 1);
    }

    private static Integer makeSum(List<Integer> list) {
        return reduce(list, (a, b) -> a + b, 0);
    }

    private static <I, O> O reduce(List<I> what, BiFunction<I, O, O> how, O init) {
        O accum = init;
        for (I x : what) {
            accum = how.apply(x, accum);
        }
        return accum;
    }







    private static void withResource(Supplier<BufferedReader> readerSupplier, Function<String, ?> lineEnjoyer) {
        try (BufferedReader reader = readerSupplier.get()) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                lineEnjoyer.apply(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String screamAtMe(String line) {
        return line.toUpperCase();
    }

    private static String show(String line) {
        System.out.println(line);
        return line;
    }

    private static <A, B, C> Function<A, C> andThen(Function<A, B> f, Function<B, C> g) {
        return f.andThen(g);
    }
}
