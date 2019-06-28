package io.github.com.javafaktura.s01.e08;

import io.github.com.javafaktura.s01.e08.guts.Functions;

import java.util.List;
import java.util.stream.Stream;

import static io.github.com.javafaktura.s01.e08.guts.Input.*;
import static java.util.stream.Collectors.toList;

public class Declarative {
    public static void main(String[] args) {

        var arr2 = Stream.of(ARR_1)
                .map(Functions::doStuff)
                .toArray(Integer[]::new);

        // ...

        System.out.println(List.of(arr2));







        var newLine = OLD_LINE.stream()
                .filter(Functions::isOk)
                .collect(toList());


        // ...


        System.out.println(newLine);







        var total = A_LIST.stream()
                .reduce(0, (a, b) -> a + b);

        // ...

        System.out.println(total);
    }
}
