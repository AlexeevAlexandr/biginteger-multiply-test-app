package com.test.service;

import java.math.BigInteger;

public class CalculateImpl implements Calculate {

    @Override
    public BigInteger multiply(String alg, BigInteger one, BigInteger two) throws UnsupportedOperationException {

        switch (alg) {
            case "alg1":
                return multiplyMethodOne(one, two);
            case "alg2":
                return multiplyMethodTwo(one, two);
            default:
                throw new UnsupportedOperationException("Unsupported operation - " + alg);
        }
    }

    private BigInteger multiplyMethodOne(BigInteger one, BigInteger two) {
        return one.multiply(two);
    }

    private BigInteger multiplyMethodTwo(BigInteger one, BigInteger two) {
        String numOne = String.valueOf(one);
        String numTwo = String.valueOf(two);

        int lengthOne = numOne.length();
        int lengthTwo = numTwo.length();

        int[] result = new int[lengthOne + lengthTwo];

        int indexOne = 0;
        int indexTwo;

        for (int i = lengthOne - 1; i >= 0; i--) {
            int carry = 0;
            int n1 = numOne.charAt(i) - '0';

            indexTwo = 0;

            for (int j = lengthTwo - 1; j >= 0; j--) {
                int n2 = numTwo.charAt(j) - '0';

                int sum = n1 * n2 + result[indexOne + indexTwo] + carry;

                carry = sum / 10;

                result[indexOne + indexTwo] = sum % 10;

                indexTwo++;
            }

            if (carry > 0)
                result[indexOne + indexTwo] += carry;

            indexOne++;
        }

        int i = result.length - 1;
        while (i >= 0 && result[i] == 0) {
            i--;
        }

        StringBuilder s = new StringBuilder();
        while (i >= 0) {
            s.append(result[i--]);
        }

        return new BigInteger(s.toString());
    }
}
