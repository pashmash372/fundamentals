package com.scaler.addersub;

import lombok.AllArgsConstructor;

import java.util.concurrent.locks.Lock;

@AllArgsConstructor
public class Subtractor implements Runnable {
    private Count count;
    private Lock lock;

    @Override
    public void run() {
        // 1. Iterate from 1 to 100
        // 2. Decrement count

        for (int index = 1; index <= 100; index++) {

//            Acquire the lock
            lock.lock();

            count.value -= index;

//            Release the lock
            lock.unlock();
        }
    }
}
