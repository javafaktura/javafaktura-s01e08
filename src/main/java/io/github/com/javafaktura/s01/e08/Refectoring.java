package io.github.com.javafaktura.s01.e08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static io.github.com.javafaktura.s01.e08.guts.Input.A_LIST;


public class Refectoring {
    public static void main(String[] args) {
        // printList
        printList();












        // product
        Integer product = 1;
        for (Integer x : A_LIST) {
            product *= x;
        }
        System.out.println(product);

        // sum
        Integer sum = 0;
        for (Integer x : A_LIST) {
            sum += x;
        }
        System.out.println(sum);












        // obsługa IO - panowanie nad efektami
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(Refectoring.class.getResourceAsStream("/sample.txt")))) {
            screamAtMe(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    private static void printList() {
        for (var x : A_LIST) {
            System.out.println(x);
        }
    }





    private static void screamAtMe(BufferedReader reader) throws IOException {
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            String screaming = line.toUpperCase();
            System.out.println(screaming);
        }
    }
}
