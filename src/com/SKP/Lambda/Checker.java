package com.SKP.Lambda;

@FunctionalInterface
public interface Checker<T> {

    boolean check(T object);
}
