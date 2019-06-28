package io.github.com.javafaktura.s01.e08.simplestrategy;

import java.math.BigDecimal;
import java.util.Objects;

public class Item extends Product {

    private final Double weight;

    public Item(String name, BigDecimal price, Double weight) {
        super(name, price);
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        if (!super.equals(o)) return false;
        Item item = (Item) o;
        return Objects.equals(weight, item.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weight);
    }
}
