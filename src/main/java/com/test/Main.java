package com.test;

import com.test.service.Calculate;
import com.test.service.CalculateImpl;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        Calculate calculate = new CalculateImpl();

        String alg = args[0];
        BigInteger one = new BigInteger(args[1]);
        BigInteger two = new BigInteger(args[2]);

        try {
            BigInteger result = calculate.multiply(alg, one, two);
            System.out.println(result);
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }
}
