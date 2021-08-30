package org.example;

import org.junit.jupiter.api.Test;

;import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

//    @Test
//    void groupAssertions() {
//        int[]numbers = {3, 4, 5};
//        assertAll("numbers",
//                () -> assertNotNull() numbers[0], 1),
//                () -> assertEquals(numbers[3], 3),
//                () -> assertEquals(numbers[4], 1)
//        );
//    }

    @Test
    void groupAssertions1() {
        int[]numbers = {0, 1, 2, 3, 4};
        assertAll("numbers",
                () -> assertEquals(numbers[0], 0),
                () -> assertEquals(numbers[3], 3),
                () -> assertEquals(numbers[4], 4)
        );
    }




}
