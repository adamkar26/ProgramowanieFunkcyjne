package com.SKP.Generic;

public class BoxOnSteroids<T> {
    private T fruit;

    public BoxOnSteroids(T fruit) {
        this.fruit = fruit;
    }

    public T getFruit() {
        return fruit;
    }
}
