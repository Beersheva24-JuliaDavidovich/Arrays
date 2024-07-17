package telran.util;

import java.util.Comparator;

public class Arrays {
    public static int search(int[] ar, int key) {
        int index = 0;
        while (index < ar.length && key != ar[index]) {
            index++;
        }
        return index == ar.length ? -1 : index;
    }

    public static int[] add(int[] ar, int number) {
        int[] res = java.util.Arrays.copyOf(ar, ar.length + 1);
        res[ar.length] = number;
        return res;

    }

    /**
     * 
     * @param ar
     * @param index
     * @param number
     * @return reference to a new array containing @param number at @param index
     */
    public static int[] insert(int[] ar, int index, int number) {
        int[] res = new int[ar.length + 1];
        System.arraycopy(ar, 0, res, 0, index);
        res[index] = number;
        System.arraycopy(ar, index, res, index + 1, ar.length - index);
        return res;// 10, 7, 12, 41, -4, 13, 3, 14
        // TODO
        // creates new array with all elements from the given "ar" and
        // the given "number" at the given index
        // to apply System.arraycopy method
    }

    /**
     * 
     * @param numbers
     * @param index
     * @return new array with no removed from @param numbers number at @param index
     */
    public static int[] remove(int[] numbers, int index) {
        int[] res = new int[numbers.length - 1];
        System.arraycopy(numbers, 0, res, 0, index);
        System.arraycopy(numbers, index + 1, res, index, numbers.length - index - 1);
        return res;
        // TODO
        // creates new array with no element in "numbers" at "index"
        // to apply System.arraycopy method
    }

    // Bubble sort
    private static boolean pushMaxAtEnd(int[] ar, int length) {
        boolean res = true;
        for (int i = 0; i < length; i++) {
            if (ar[i] > ar[i + 1]) {
                res = false;
                swap(ar, i, i + 1);
            }
        }
        return res;
    }

    private static void swap(int[] ar, int i, int j) {
        int tmp = ar[i];
        ar[i] = ar[j];
        ar[j] = tmp;
    }

    public static void sort(int[] ar) {
        int length = ar.length;
        boolean flSorted = false;
        while (!flSorted) {
            length--;
            flSorted = pushMaxAtEnd(ar, length);
        }
    }

    public static int binarySearch(int[] ar, int key) {
        int l = 0;
        int r = ar.length - 1;
        int mid = (l + r) / 2;
        while (l <= r && ar[mid] != key) {
            if (key < ar[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
            mid = (l + r) / 2;
        }
        return l > r ? - (l + 1) : mid;
    }

    public static int[] insertSorted(int[] arSorted, int number) {
        int index = binarySearch(arSorted, number);
        if(index < 0) {
            index = - index - 1;
        }
        return insert(arSorted, index, number);
    }

    // public static boolean isOneSwap(int[] array) {
    //     int count = 0;
    //     boolean res = false;
    //     int index1 = -1;
    //     int index2 = -1;
    //     for (int i = 0; i < array.length - 1; i++) {
    //         if (array[i] > array[i + 1]) {
    //             if (index1 == -1) {
    //                 index1 = i;
    //             }
    //             index2 = i + 1;
    //             count++;
    //         }
    //     }
    //     if (count <= 2 && count != 0) {
    //         for (int i = 0; i < array.length - 1; i++) {
    //             if (array[i] == array[i + 1]) {
    //                 index2 = i + 1;
    //             }
    //         }
    //         if (index1 != index2 - 1) {
    //             if ((index1 != 0 && array[index1 - 1] <= array[index2] && array[index2] <= array[index1 + 1]
    //                     || index1 == 0 && array[index2] <= array[index1 + 1])
    //                     && (index2 != array.length - 1 && array[index2 - 1] <= array[index1]
    //                             && array[index1] <= array[index2 + 1]
    //                             || index2 == array.length - 1
    //                                     && array[index1] >= array[index2 - 1])) {
    //                 res = true;
    //             }
    //         }
    //     }
    //     return res;
    // }

    public static boolean isOneSwap(int[] array) {
        boolean res = false;
        int index1 = -1;
        int index2 = 0;
        index1 = getFirstIndex(array);
        if (index1 > -1) {
            index2 = getSecondIndex(array, index1);
            res = isOneSwapCheck(array, index1, index2);
        }
        return res;
    }

    private static boolean isOneSwapCheck(int[] array, int index1, int index2) {
        swap(array, index1, index2);
        boolean res = isArraySorted(array);
        swap(array, index1, index2);// array restored after swap
        return res;
    }

    private static boolean isArraySorted(int[] array) {
        int index = 1;
        while (index < array.length && array[index] >= array[index -1]) {
            index++;
        }
        return index == array.length;
    }

    private static int getSecondIndex(int[] array, int index1) {
        int index = array.length - 1;
        int lowBorder = index1 + 1;
        while (index > lowBorder && array[index] >= array[index1]) {
            index--;
        }
        return index;
    }

    private static int getFirstIndex(int[] array) {
        int index = 0;
        int limit = array.length - 1;
        while (index < limit && array[index] <= array[index + 1]) {
            index++;
        }
        return index == limit ? -1 : index;
    }


    public static <T> void sort(T[] array, Comparator<T> comparator) {
        int length = array.length;
        boolean flSort = false;
        do {
            length--;
            flSort = true;
            for (int i = 0; i < length; i++) {
                if (comparator.compare(array[i], array[i + 1]) > 0) {
                    swap(array, i, i + 1);
                    flSort = false;
                }
            }
        } while (!flSort);
    }

    private static <T> void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static <T> int binarySearch(T[] array, T key, Comparator<T> comp) {
        Integer l = 0;
        Integer r = array.length - 1;
        Integer mid = (l + r) / 2;
        while (l <= r && (comp.compare(array[mid], key) != 0)) {
            if (comp.compare(key, array[mid]) < 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
            mid = (l + r) / 2;
        }
        return l > r ? - (l + 1) : mid;
    }
}