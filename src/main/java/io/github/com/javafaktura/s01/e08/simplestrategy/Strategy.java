package io.github.com.javafaktura.s01.e08.simplestrategy;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Strategy {
    private static final List<Product> products = List.of(
            new Item("DumbTV 38 cali", new BigDecimal("500"), 10.0),
            new Service("VOD", new BigDecimal("30"), 120),
            new Item("Dune", new BigDecimal("50"), 1.0),
            new Item("Kroniki Amberu, t. 1 i 2", new BigDecimal("85"), 2.0),
            new Service("Movie stream", new BigDecimal("10"), 2)
    );

    public static void main(String[] args) {





        BigDecimal sum1 = cartBruttoSum1(Strategy::taxOnItems, itemTax(new BigDecimal("0.42")), products);
        System.out.println(sum1.toPlainString());









        BigDecimal sum2 = cartBruttoSum2(Strategy::taxOnItems, itemTax(new BigDecimal("0.42")), products);
        System.out.println(sum2.toPlainString());










        BigDecimal sum3 = cartBruttoSum1(Strategy::taxOnService, itemTax(new BigDecimal("0.1")), products);
        System.out.println(sum3.toPlainString());









        BigDecimal sum4 = cartBruttoSum2(Strategy::taxEverything, itemTax(new BigDecimal("0.23")), products);
        System.out.println(sum4.toPlainString());






    }

    private static BigDecimal cartBruttoSum1(
            Predicate<Product> policy,
            Function<BigDecimal, BigDecimal> tax,
            List<Product> products) {

        return products
                .stream()
                .map((Product p) -> policy.test(p) ? tax.apply(p.getPrice()) : p.getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }









    private static BigDecimal cartBruttoSum2(
            Predicate<Product> policy,
            Function<BigDecimal, BigDecimal> tax,
            List<Product> products) {

        return products
                .stream()
                .collect(Collectors.groupingBy(policy::test))
                .entrySet()
                .stream()
                .flatMap(group -> group.getKey() ? group.getValue().stream().map(p -> tax.apply(p.getPrice())) : group.getValue().stream().map(Product::getPrice))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }










    private static boolean taxOnItems(Product p) {
        return p instanceof Item;
    }

    private static boolean taxOnService(Product p) {
        return p instanceof Service;
    }

    private static boolean taxEverything(Product p) {
        return true;
    }











    private static Function<BigDecimal, BigDecimal> itemTax(BigDecimal tax) {
        BigDecimal percent = tax.add(BigDecimal.ONE);
        return p -> p.multiply(percent);
    }

}
