package com.test;

import com.test.service.Calculate;
import com.test.service.CalculateImpl;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class CalculateTest {

    private Calculate calculate;
    private BigInteger one;
    private BigInteger two;

    @Before
    public void init() {
        calculate = new CalculateImpl();
        one = new BigInteger("12345678901234567890");
        two = new BigInteger("11111111111111111111");
    }

    @Test
    public void test_alg1() {
        String alg ="alg1";

        BigInteger expectedSum = one.multiply(two);
        BigInteger currentSum = calculate.multiply(alg, one, two);

        assertEquals(expectedSum, currentSum);
    }

    @Test
    public void test_alg2() {
        String alg ="alg2";

        BigInteger expectedSum = one.multiply(two);
        BigInteger currentSum = calculate.multiply(alg, one, two);

        assertEquals(expectedSum, currentSum);
    }

    @Test (expected = UnsupportedOperationException.class)
    public void test_UnsupportedOperationException() {
        String alg ="algUnknown";

        calculate.multiply(alg, one, two);
    }
}
