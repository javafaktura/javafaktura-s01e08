package io.github.com.javafaktura.s01.e08.simplestrategy;

import java.math.BigDecimal;
import java.util.Objects;

public class Service extends Product {

    private final Integer time;

    public Service(String name, BigDecimal price, Integer time) {
        super(name, price);
        this.time = time;
    }

    public Integer getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Service)) return false;
        if (!super.equals(o)) return false;
        Service service = (Service) o;
        return Objects.equals(time, service.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), time);
    }
}
