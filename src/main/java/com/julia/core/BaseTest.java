package com.julia.core;

import org.junit.After;

public class BaseTest {

    @After
    public void tearDown() {
        DriverFactory.killDriver();
    }

}
