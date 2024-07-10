package telran.util.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static telran.util.Arrays.*;

public class ArraysTest {
int[] numbers = {10, 7, 12, -4, 13, 3, 14};
@Test 
void searchTest(){
    assertEquals(0, search(numbers, 10));
    assertEquals(6, search(numbers, 14));
    assertEquals(3, search(numbers, -4));
    assertEquals(-1, search(numbers, 100));
}

@Test
void addTest(){
    int newNumber = 100;
    int [] expected = {10, 7, 12, -4, 13, 3, 14, 100};
    assertArrayEquals(expected, add(numbers, newNumber));
}

@Test
void insertTest(){
    int [] ar = {10, 7, 12, -4, 13, 3, 14};
    int [] expected = {10, 7, 12, 41, -4, 13, 3, 14};
    assertArrayEquals(expected, insert(ar, 3, 41));
    int [] expected1 = {1, 10, 7, 12, -4, 13, 3, 14};
    assertArrayEquals(expected1, insert(ar, 0, 1));
    int [] expected2 = {10, 7, 12, -4, 13, 3, 14, 1};
    assertArrayEquals(expected2, insert(ar, 7, 1));
}

@Test
void removeTest(){
    int [] ar = {10, 7, 12, -4, 13, 3, 14};
    int [] expected = {10, 7, -4, 13, 3, 14};
    assertArrayEquals(expected, remove(ar, 2));
    int [] expected1 = {7, 12, -4, 13, 3, 14};
    assertArrayEquals(expected1, remove(ar, 0));
    int [] expected2 = {10, 7, 12, -4, 13, 3};
    assertArrayEquals(expected2, remove(ar, 6));
}
}
