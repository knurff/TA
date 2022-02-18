package com.company;

public class Main {

    public static void main(String[] args) {
        try {
            Combinator combinator = new Combinator();
            System.out.println(CombinatorHelper.toString(combinator.generateSubsets(3, 2)));
            System.out.println(CombinatorHelper.toString(combinator.generateSubsets(5, 3)));
            System.out.println(CombinatorHelper.toString(combinator.generateSubsets(10, 5)));
        }catch (NegativeArraySizeException e){
            System.err.println("N must be positive!");
        }
        try {
            Combinator combinator = new Combinator();
            System.out.println(CombinatorHelper.toString(combinator.generateSubsets(3, 4)));
            System.out.println(CombinatorHelper.toString(combinator.generateSubsets(3, 0)));
            System.out.println(CombinatorHelper.toString(combinator.generateSubsets(-1, 4)));
        }catch (NegativeArraySizeException e){
            System.err.println("N must be positive!");
        }
    }
}
