package com.test12.javacore;


import java.util.LinkedList;
import java.util.List;

/**
 * -Xms10m -Xmx10m -XX:+HeapDumpOnOutOfMemoryError
 *
 * @author zhanglong
 *
 */

public class GarbageTest {

    public static void main(String[] args) {

        List<GarbageTest> list = new LinkedList<>();

        for(;;)
        {
            list.add(new GarbageTest());

            System.out.println("running");
        }

    }
}
