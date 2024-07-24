package telran.util.test;

import telran.util.CharacterRule;
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

@Test
void sortAnyTypeTest() {
    String[] strings = {"lmn", "cfta", "w", "aa"};
    String[] expectedASCII = {"aa", "cfta", "lmn", "w"};
    String[] expectedLength = {"w", "aa", "lmn", "cfta"};
    sort(strings, (a, b) -> a.compareTo(b));
    assertArrayEquals(expectedASCII, strings);
    sort(strings, (a,b) -> Integer.compare(a.length(), b.length()));
    assertArrayEquals(expectedLength, strings);
}

@Test
void binarySearchAnyTypesTest(){
    String[] strings = {"aa", "cfta", "lmn", "w"};
    Integer[] numbers = {10, 20, 30, 40, 50};
    assertEquals(0, binarySearch(strings, "aa", (a, b) -> a.compareTo(b)));
    assertEquals(-2, binarySearch(strings, "ad", (a, b) -> a.compareTo(b)));
    assertEquals(4, binarySearch(numbers, 50, Integer::compare));
    assertEquals(0, binarySearch(numbers, 10, Integer::compare));
    assertEquals(-2, binarySearch(numbers, 12, Integer::compare));
    assertEquals(2, binarySearch(numbers, 30, Integer::compare));
    assertEquals(-6, binarySearch(numbers, 55, Integer::compare));
    assertEquals(-1, binarySearch(numbers, -5, Integer::compare));
}
@Test
void binarySearchNoComparator() {
    String[] strings = {"aa", "cfta", "lmn", "w"};
    Person prs1 = new Person(10,"Vasya");
    Person prs2 = new Person(20,"Itay");
    Person prs3 = new Person(30,"Sara");
    Person [] persons = {
        prs1, prs2, prs3
    };
    assertEquals(1, java.util.Arrays.binarySearch(strings, "cfta"));
    assertEquals(0, java.util.Arrays.binarySearch(persons, prs1));
    assertEquals(-1, binarySearch(persons, new Person(5, "Serg")));
}
@Test
void evenOddSorting() {
    Integer[] array = {7, -8, 10, -100, 13, -10, 99};
    Integer[] expected = {-100, -10, -8, 10, 99, 13, 7};//even numbers in ascending order first, odd in descending order after that
    sort(array, (a, b) -> {
        int result = 0;
        if(a % 2 == 0 && b % 2 != 0){
            result = -1;
        }else if(a % 2 == 0 && b % 2 == 0) {
            result = a - b;
        }else if(a % 2 != 0 && b % 2 != 0) {
            result = b - a;
        }else if(a % 2 != 0 && b % 2 == 0) {
            result = 1;
        }
        return result;
    });
    assertArrayEquals(expected, array);
}
@Test
void findTest() {
    Integer[] array = {7, -8, 10, -100, 13, -10, 99};
    Integer[] expected = {7, 13, 99};
    assertArrayEquals(expected, find(array, n -> n % 2 != 0));
}

@Test
void removeIfTest() {
    Integer[] array = {7, -8, 10, -100, 13, -10, 99};
    Integer[] expected = {-8, 10, -100, -10,};
    assertArrayEquals(expected, removeIf(array, n -> n % 2 != 0));
}

@Test
void matchesRuleTest() {
    //TODO
    //Must be rules: at least  one capital letter, at least one lower case letter, at least one digit, at least one dot(.)
    //Must not be rules: space is disallowed
    //eaxmples: matches - {'a', 'n', '*', 'G', '.', '.', '1'}
    //mismatches - {'a', 'n', '*', 'G', '.', '.', '1', ' '} -> "space disallowed"
    // {'a', 'n', '*', '.', '.', '1'} -> "no capital"
    // {'a', 'n', '*', 'G', '.', '.'} -> ""
    char[] chars = {'a', 'n', '*', 'G', '.', '.', '1'};
    char[] chars1 = {'*', 'G', '.', '.', '1', ' '};
    char[] chars2 = {'a', 'n', '*', '.', '.', '1'};
    char[] chars3 = {'a', 'n', '*', 'G', '.', '.'};
    char[] chars4 = {'a', 'n', '*', 'G'};
    char[] chars5 = {'a', 'n', '*', 'G', ' '};
    CharacterRule isDigits = new CharacterRule(true, n -> Character.isDigit(n), "Should be at least one digit");
    CharacterRule isCapitalLetter = new CharacterRule(true, n -> Character.isTitleCase(n), "Should be at least one capital letter");
    CharacterRule isLowerCaseLetter = new CharacterRule(true, n -> Character.isLowerCase(n), "Should be at least one lower case letter");
    CharacterRule isDot = new CharacterRule(true, n -> n == '.', "Should be at least one dot");
    CharacterRule space = new CharacterRule(false, n -> Character.isWhitespace(n), "Space disallowed");
    CharacterRule[] mustBeRules = {isDigits, isCapitalLetter, isLowerCaseLetter, isDot};
    CharacterRule[] mustNotBeRules = {space};
    assertEquals("", matchesRules(chars, mustBeRules, mustNotBeRules));
    assertEquals("Should be at least one digit", matchesRules(chars3, mustBeRules, mustNotBeRules));
    assertEquals("Should be at least one capital letter", matchesRules(chars2, mustBeRules, mustNotBeRules));
    assertEquals("Should be at least one lower case letter", matchesRules(chars1, mustBeRules, mustNotBeRules));
    assertEquals("Should be at least one dot", matchesRules(chars4, mustBeRules, mustNotBeRules));
    assertEquals("Space disallowed", matchesRules(chars5, mustBeRules, mustNotBeRules));
    
    

} 
}

