package telran.util.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.abort;
import static telran.util.Arrays.*;

import java.util.Random;

public class ArraysTest {
private static final int N_ELEMENTS = 1000;
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

@Test
void sortTest() {
    int[] testNumbers = java.util.Arrays.copyOf(numbers, numbers.length);
    int [] expected = {-4, 3, 7, 10, 12, 13, 14};
    sort(testNumbers);
    assertArrayEquals(expected, testNumbers);
}

@Test
void sortTestRandomArray(){
    int[] array = getRandomArray(N_ELEMENTS);
    int limit = array.length - 1;
    sort(array);
    for(int i = 0; i < limit; i++){
        assertTrue(array[i] <= array[i + 1]);
    }
}
private int[] getRandomArray(int nElements) {
    int[] res = new int[nElements];
    Random random = new Random();
    for(int i = 0; i < nElements; i++) {
        res[i] = random.nextInt();
    }
    return res;
}

@Test
void binarySearchTest() {
    int[] ar = {1, 3, 5, 6, 87, 98};
    assertEquals(2, binarySearch(ar, 5));
    assertEquals(0, binarySearch(ar, 1));
    assertEquals(5, binarySearch(ar, 98));
    assertEquals(-1, binarySearch(ar, 50));
}

@Test
void insertSortedTest() {
    int[] ar = {1, 3, 5, 6, 87, 98};
    int [] expected = {1, 3, 5, 6, 10, 87, 98};
    assertArrayEquals(expected, insert(ar, 4, 10));
    int [] expected1 = {0, 1, 3, 5, 6, 87, 98};
    assertArrayEquals(expected1, insert(ar, 0, 0));
    int [] expected2 = {1, 3, 5, 6, 87, 98, 101};
    assertArrayEquals(expected2, insert(ar, 6, 101));
}

@Test
void isOneSwapTest() {
    int[] ar = {1, 2, 5, 4, 3, 6}; // one swap
    assertTrue(isOneSwap(ar));
    int[] ar1 = {1, 2, 5, 4, 3, 6, 22, 45, 12}; //more one swap
    assertFalse(isOneSwap(ar1));
    int[] ar2 = {-4, 13, 7, 10, 12, 8, 14}; //more one swap
    assertFalse(isOneSwap(ar2));
    int[] ar3 = {1, 2, 4, 3, 5, 6}; // one swap neibours
    assertFalse(isOneSwap(ar3));
    int[] ar4 = {6, 2, 3, 4, 5, 1}; // one swap last elements
    assertTrue(isOneSwap(ar4)); 
    int[] ar5 = {1, 2, 3, 6, 3, 5, 3}; // 
    assertTrue(isOneSwap(ar5)); 
    int[] ar6 = {1, 2, 5, 3, 3, 3, 6}; // 
    assertTrue(isOneSwap(ar6));
    int[] ar7 = {1, 1, 1, 2, 5, 3, 3, 3, 6}; // 
    assertTrue(isOneSwap(ar7));
}
}
