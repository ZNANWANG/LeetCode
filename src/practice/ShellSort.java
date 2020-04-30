package practice;

import util.Helper;

import java.util.Arrays;

/**
 * @Author: Wang An
 * @Date: 4/25/2020 9:07 AM
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] array = Helper.initArray(50, 10);
        System.out.println("original array: " + Arrays.toString(array));
        shellSort1(array);
        System.out.println("sorted array: " + Arrays.toString(array));
    }

    public static void shellSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int gap = array.length / 2;
        while (gap > 0) {
            for (int i = gap; i < array.length; i++) {
                int temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && temp < array[preIndex]) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
    }

    public static void shellSort1(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int gap = array.length / 2;
        while (gap > 0) {
            for (int i = gap; i < array.length; i++) {
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > array[preIndex + gap]) {
                    Helper.swap(array, preIndex, preIndex + gap);
                    preIndex -= gap;
                }
            }
            gap /= 2;
        }
    }
}
