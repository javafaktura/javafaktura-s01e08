package io.github.com.javafaktura.s01.e08;

import io.github.com.javafaktura.s01.e08.guts.Functions;
import io.github.com.javafaktura.s01.e08.guts.Point;

import java.util.ArrayList;
import java.util.List;

import static io.github.com.javafaktura.s01.e08.guts.Input.*;

public class Imperative {
    public static void main(String[] args) {

        var arr2 = new Integer[ARR_1.length];
        for (var i = 0; i < ARR_1.length; ++i) {
            arr2[i] = Functions.doStuff(ARR_1[i]);
        }
        System.out.println(List.of(arr2));







        var newLine = new ArrayList<>();
        for (Point p : OLD_LINE) {
            if (Functions.isOk(p)) {
                newLine.add(p);
            }
        }
        System.out.println(newLine);







        var total = 0;
        for (var i = 0; i < A_LIST.size(); ++i) {
            total += A_LIST.get(i);
        }
        System.out.println(total);
    }
}
