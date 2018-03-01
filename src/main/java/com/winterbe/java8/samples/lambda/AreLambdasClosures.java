//http://bruceeckel.github.io/2015/10/17/are-java-8-lambdas-closures/
package com.winterbe.java8.samples.lambda;

import java.util.function.*;

//Use Supplier if it takes nothing.
//Use Consumer if it returns nothing.
//Use Runnable if it does neither.

class MyInt {
	public Integer i = 0;
}

public class AreLambdasClosures {
    public Function<Integer, Integer> make_fun() {
        // Outside the scope of the returned function:
        Integer n = 0;
        return arg -> {
            System.out.print(n + " " + arg + " : ");
            // n += arg; // Produces error message: local variables referenced from a lambda expression must be final or effectively final.
            return n;
        };
    }
    
    public Function<Integer, Integer> make_fun2() {
        MyInt n = new MyInt();
        return arg -> {
            System.out.print(n + " " + arg + " : ");
            n.i += arg;
            return n.i;
        };
    }
    
    public void try_it() {
        Function<Integer, Integer>
            x = make_fun(),
            y = make_fun2();
        for(int i = 0; i < 5; i++)
            System.out.println(x.apply(i));
        for(int i = 0; i < 5; i++)
            System.out.println(y.apply(i));
    }
    
    public static void main(String[] args) {
        new AreLambdasClosures().try_it();
    }
}
