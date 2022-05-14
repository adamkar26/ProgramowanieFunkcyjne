package com.SKP.Lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SortingString {

    public static void sort(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj 4 lancuchy znakow oddzielajac je znakiem nwoej lini");
        List<String> strings = new ArrayList<>();

        for(int i=0; i<4; i++){
            strings.add(scanner.nextLine());
        }

        System.out.println(strings);
        strings.sort((a,b) -> b.length() - a.length());
        strings.sort(Comparator.comparingInt(String::length).reversed());
        System.out.println(strings);
    }
}
