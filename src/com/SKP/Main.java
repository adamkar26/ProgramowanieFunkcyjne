package com.SKP;

import com.SKP.AnonymousClass.SomeInterface;
import com.SKP.Generic.*;
import com.SKP.Lambda.Checker;
import com.SKP.Lambda.Human;
import com.SKP.Lambda.SortingString;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
       // generic();
        //anonymous();
       // check();
       // lambda();
       // SortingString.sort();
        humanCreator();


    }

    private static void humanCreator(){
        BiFunction<Integer, String, Human> humanBiFunction = Human::new;
        Human human = humanBiFunction.apply(37, "Mirek");
        System.out.println(human.getAge());
        System.out.println(human.getName());
    }

    private static void check() {
        Checker<Integer> isOdd = new Checker<Integer>() {
            @Override
            public boolean check(Integer object) {
                return  object %2 != 0;
            }
        };

        System.out.println(isOdd.check(123));
        System.out.println(isOdd.check(124));

        Checker<Integer> isOddLambda = (object) -> object %2 != 0;
        System.out.println(isOddLambda.check(123));
        System.out.println(isOddLambda.check(124));

        // Interfejsy funkcyjne
        Function<Integer, Long> func = x -> {
            if(x != null && x%2==0){
                return  (long)x*x;
            }
            else {
                return  0L;
            }
        };

        System.out.println(func.apply(125));

        Consumer<Integer> consumer = (i) -> System.out.println("Dostalam "+i);
        consumer.accept(15);

        Supplier<String> someString = () -> "jakis tekst";
        System.out.println(someString.get());

        UnaryOperator<Integer> pow = x -> x*x;
        System.out.println(pow.apply(10));

        BiPredicate<Integer, Integer> equals = (a,b) -> a == b;
        System.out.println(equals.test(10, 10));

        Object o = new Object();
        Supplier<Integer> method = o::hashCode;
        System.out.println(method.get());
        // To samo
        IntSupplier method2 = o::hashCode;
        System.out.println(method2.getAsInt());

        //bez podania instancji
        ToIntFunction<Object> hash = Object::hashCode;
        System.out.println(hash.applyAsInt(o));

        //Odwolywanie sie do konstruktora
        Supplier<Object> objectSupplier = Object::new;
        System.out.println(objectSupplier.get());


    }

    private static void lambda(){
        List<Integer> numbers = Arrays.asList(1,2,3,4);
        // podejscie klasyczne
        for(Integer number : numbers)
            System.out.println(number);

        // podejscie funkcyjne
        Consumer<Integer> integerConsumer = n -> System.out.println(n);
        numbers.forEach(integerConsumer);
        numbers.forEach(System.out::println);

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
