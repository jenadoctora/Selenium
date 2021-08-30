package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class TriangleTest {


    @Test
    void numberNotNull() {

        assertNotNull(3);
    }

    @Test
    void numberPositive() {

        int a = 3;
        int b = 4;
        int c = 5;

        if (a > 0 || b > 0 || c > 0) {
            assert true;
        }
    }
}

