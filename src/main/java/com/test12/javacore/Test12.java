package com.test12.javacore;

public class Test12 {

    public static void main(String[] args) {
        for(int i = 0; i < 1000; ++i) {

            System.out.println(Thread.currentThread().getName() + ", Number: " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
