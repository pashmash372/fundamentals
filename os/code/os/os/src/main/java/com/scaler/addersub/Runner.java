package com.scaler.addersub;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
    public static void main(String[] args) throws InterruptedException {

//         1.Create a count variable (Shared resource)
        Count count = new Count();

//        1.5 . Create a common lock instance
        Lock lock=new ReentrantLock();

//         2. Create adders and subtractors
        Adder adder = new Adder(count,lock);
        Subtractor subtractor = new Subtractor(count,lock);

//        3.Created threads for each task
        Thread adderThread = new Thread(adder);
        Thread subThread = new Thread(subtractor);

//        4. Executed threads using start()
        adderThread.start();
        subThread.start();

//        5. Wait until completion
        adderThread.join();//Blocked
        subThread.join();//Blocked

        System.out.println("The final value was: "+count.value);
    }
}
