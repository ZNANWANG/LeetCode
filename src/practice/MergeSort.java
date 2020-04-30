package practice;

import util.Helper;

import java.util.Arrays;

/**
 * 归并排序 —— 稳定但不在位
 *
 * @Author: Wang An
 * @Date: 4/24/2020 4:22 PM
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = Helper.initArray(50, 10);
        System.out.println("original array: " + Arrays.toString(array));
        mergeSort1(array);
        System.out.println("sorted array: " + Arrays.toString(array));
    }

    /**
     * 对int数组进行归并排序
     *
     * @param array 待排序int数组
     */
    public static void mergeSort(int[] array) {
        int start = 0;
        int end = array.length - 1;
        mergeSort(array, start, end);
    }

    public static void mergeSort(int[] array, int start, int end) {
        if (array == null || array.length < 2 || start == end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);
        merge(array, start, mid, end);
    }

    public static void merge(int[] array, int start, int mid, int end) {
        int[] merged = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (k < merged.length) {
            if (i > mid) {
                merged[k++] = array[j++];
            } else if (j > end) {
                merged[k++] = array[i++];
            } else if (array[i] < array[j]) {
                merged[k++] = array[i++];
            } else {
                merged[k++] = array[j++];
            }
            System.out.println(Arrays.toString(array));
        }
        for (int index = 0; index < merged.length; index++) {
            array[start + index] = merged[index];
        }
    }

    /**
     * 对int数组进行归并排序，这种写法空间复杂度高，不推荐。
     *
     * @param array 待排序int数组
     */
    public static void mergeSort1(int[] array) {
        int[] temp = mergeSortHelper(array);
        for (int i = 0; i < array.length; i++) {
            array[i] = temp[i];
        }
    }

    public static int[] mergeSortHelper(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        int start = 0;
        int end = array.length;
        int mid = (start + end) / 2;
        int[] left = Arrays.copyOfRange(array, start, mid);
//        System.out.println("left: " + Arrays.toString(left));
        int[] right = Arrays.copyOfRange(array, mid, end);
//        System.out.println("right: " + Arrays.toString(right));
        return merge(mergeSortHelper(left), mergeSortHelper(right));
    }

    public static int[] merge(int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] merged = new int[left.length + right.length];
        while (k < merged.length) {
            if (i >= left.length) {
                merged[k++] = right[j++];
            } else if (j >= right.length) {
                merged[k++] = left[i++];
            } else if (left[i] < right[j]) {
                merged[k++] = left[i++];
            } else {
                merged[k++] = right[j++];
            }
        }
//        System.out.println(Arrays.toString(merged));
        return merged;
    }
}
