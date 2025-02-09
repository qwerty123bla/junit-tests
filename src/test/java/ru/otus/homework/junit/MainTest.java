package ru.otus.homework.junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @ParameterizedTest
    @MethodSource("testDataArrAfterLastOne")
    public void testArrAfterLastOneEquals(int[] a, int [] result) throws Exception {
        Assertions.assertArrayEquals(result, Main.arrAfterLastOne(a));
    }

    public static Stream<Arguments> testDataArrAfterLastOne() {
        List<Arguments> out = new ArrayList<>();

        out.add(Arguments.arguments(new int [] {2, 2, 3, 1, 2, 0}, new int[] {2, 0}));
        out.add(Arguments.arguments(new int [] {1, 2, 3}, new int[] {2, 3}));
        out.add(Arguments.arguments(new int [] {3, 2, 1}, new int[] {}));
        return out.stream();
    }

    @Test
    public void testArrAfterLastOneException() {

        Assertions.assertThrows(RuntimeException.class, () -> {
            Main.arrAfterLastOne(new int[]{2, 2, 2, 2});
        }, "Исключение RuntimeException");
    }

    //------------------------------------------------------------------------------------------------------------------

    @ParameterizedTest
    @MethodSource("testDataTrue")
    public void testOnlyOneAndTwoEqualsTrue(int[] a) {
        Assertions.assertTrue(Main.onlyOneAndTwo(a));
    }

    @MethodSource
    public static Stream<Arguments> testDataTrue() {
        return Stream.of(
                Arguments.of(new int[] {1, 2}),
                Arguments.of(new int[]{1, 1, 2})
        );
    }

    //------------------------------------------------------------------------------------------------------------------

    @ParameterizedTest
    @MethodSource("testDataFalse")
    public void testOnlyOneAndTwoEqualsFalse(int[] a) {
        Assertions.assertFalse(Main.onlyOneAndTwo(a));
    }

    @MethodSource
    public static Stream<Arguments> testDataFalse() {
        return Stream.of(
                Arguments.of(new int[] {1, 3}),
                Arguments.of(new int[]{1, 1})
        );
    }
}