package com.test.service;

import java.math.BigInteger;

public interface Calculate {

    BigInteger multiply(String alg, BigInteger one, BigInteger two) throws UnsupportedOperationException;
}
