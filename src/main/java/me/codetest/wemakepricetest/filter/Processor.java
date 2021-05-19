package me.codetest.wemakepricetest.filter;

import java.util.function.Function;

public class Processor<T> {

    private final T t;

    private Processor(T t) {
        this.t = t;
    }

    public static <T> Processor<T> start(T t) {
        if(t == null) {
            throw new IllegalArgumentException("Must not be empty or null");
        }
        return new Processor<>(t);
    }

    public <R> Processor<R> next(Function<T, R> function) {
        return new Processor<>(function.apply(t));
    }

    public <R> R end(Function<T, R> function) {
        return function.apply(t);
    }
}
