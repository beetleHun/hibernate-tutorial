package com.beetle.junit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

public class MathTest {

    @BeforeClass
    public static void beforeClassTest() {
        System.out.println("before class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("after class");
    }

    @Test
    public void sumTest() {
        System.out.println("actual test");
        Assert.assertEquals(new Math().sum(Arrays.asList(3, 5, 6)), 14);
    }

}
