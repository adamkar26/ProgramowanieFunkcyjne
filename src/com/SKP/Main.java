package com.SKP;

import com.SKP.AnonymousClass.SomeInterface;
import com.SKP.Generic.*;

public class Main {

    public static void main(String[] args) {
        generic();
        anonymous();


    }

    private static void anonymous(){
        SomeInterface someInterface = new SomeInterface() {
            @Override
            public void doSomething() {
                System.out.println("Robie cos!");
            }
        };

        someInterface.doSomething();
        System.out.println(someInterface.getClass());
    }

    private static void generic(){
        FruitBox fruitBox = new FruitBox(new Orange());
        Orange orange = (Orange) fruitBox.getFruit();

        BoxOnSteroids<Apple> appleBoxOnSteroids = new BoxOnSteroids<Apple>(new Apple());
        BoxOnSteroids<Orange> orangeBoxOnSteroids = new BoxOnSteroids<>(new Orange());

        Orange fruit = orangeBoxOnSteroids.getFruit();

        Pair<BoxOnSteroids<Orange>, BoxOnSteroids<Apple>> pair =
                new Pair<>(new BoxOnSteroids<>(new Orange()),
                        new BoxOnSteroids<>(new Apple()));

        FigureBox<Circle> circleFigureBox = new FigureBox<>(new Circle());
        // FigureBox<Orange> box = new FigureBox<Orange>(new Orange());
    }
}
