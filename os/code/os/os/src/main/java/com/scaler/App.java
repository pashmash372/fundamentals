package com.scaler;

import com.scaler.threads.Printer;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

//        example1();
//        example2();
//        example3();


    }

    private static void example3() {
        System.out.println("Hello World. Printed by : " + Thread.currentThread().getName());
        Executor executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 100; i++) {
            Printer printer = new Printer(String.valueOf(i));
            executor.execute(printer);
        }
    }

    private static void example2() {
        System.out.println("Hello World. Printed by : " + Thread.currentThread().getName());

        for (int i = 0; i < 10; i++) {
            Printer printer = new Printer(String.valueOf(i));
            Thread thread = new Thread(printer);
            thread.start();
        }
    }

    private static void example1() {
        System.out.println("Hello world. Printed by : " + Thread.currentThread().getName());

        Printer printer = new Printer("Hello World");
        Thread thread = new Thread(printer);
        thread.start();
    }

}
// Print number 1 to 10 on a single thread
// Print number 1 to 10 each on different threads

// 1 - Thread 1
// 2 - Thread 2
// ...
// 10 - Thread 10