package io.github.com.javafaktura.s01.e08.guts;

public class Functions {
    public static int doStuff(int x) {
        return x + 3;
    }

    public static boolean isOk(Point p) {
        return Math.sqrt(p.x * p.x + p.y * p.y) <= 1.0;
    }
}
