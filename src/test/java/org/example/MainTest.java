package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void taxEarnings() {
        int earnings = 500;
        int except = 500 * 6 / 100;
        int result = Main.taxEarnings(earnings);
        Assertions.assertEquals(except, result);
    }

    @Test
    void taxEarningsMinusSpendings() {
        int earnings = 800;
        int spendings = 300;
        int extectedTax = (earnings - spendings) * 15 / 100;
        int result = Main.taxEarningsMinusSpendings(earnings, spendings);
        Assertions.assertEquals(extectedTax, result);
    }

    @Test
    void taxEarningsMinusSpendings2() {
        int earnings = 800;
        int spendings = 900;
        int extectedTax = 0;
        int result = Main.taxEarningsMinusSpendings(earnings, spendings);
        Assertions.assertEquals(extectedTax, result);
    }
}