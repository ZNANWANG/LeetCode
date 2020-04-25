package practice;

import java.util.Arrays;

/**
 * 快速排序 —— 不稳定但在位
 *
 * @Author: Wang An
 * @Date: 4/24/2020 9:13 PM
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = Helper.initArray(50, 10);
        array = new int[]{2, 2, 2, 2, 2, 1, 3, 4, 5};
        array = new int[]{1, 3, 4, 5, 2, 2, 2, 2, 2};
        array = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        array = new int[]{2, 1, 3, 2, 2, 2, 5, 4, 2};
//        array = new int[]{49, 38, 65, 97, 76, 13, 27, 49};
        array = new int[]{-1, -3, -9, -4, 0, 6, 2, 8, 6, 4};
        System.out.println("original array: " + Arrays.toString(array));
        quickSort(array);
        System.out.println("sorted array: " + Arrays.toString(array));
    }

    /**
     * 对int数组进行快速排序
     *
     * @param array 待排序int数组
     */
    public static void quickSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int start = 0;
        int end = array.length - 1;
        quickSort(array, start, end);
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start == end) {
            return;
        }
        int index = partition1(array, start, end);
        if (index > start) {
            quickSort(array, start, index - 1);
        }
        if (index < end) {
            quickSort(array, index + 1, end);
        }
    }

    /**
     * 对int数组进行分割，随机挑选[start, end]范围内的任意一个数字作为pivot的索引，pivot和末尾数字交换后进行分割。
     *
     * @param array 待排序int数组
     * @param start 开始处的索引
     * @param end   结束处的索引
     * @return 最终pivot被放置处的索引
     */
    public static int partition(int[] array, int start, int end) {
        int pivotIndex = Helper.random(start, end);
        System.out.println("pivot index: " + pivotIndex);
        int pivot = array[pivotIndex];
        Helper.swap(array, end, pivotIndex);
        int small = start;
        for (int i = start; i < end; i++) {
            if (array[i] < pivot) { // array[i] <= pivot 也可以
                if (small < i) {
                    Helper.swap(array, i, small);
                }
                small++;
            }
        }
        Helper.swap(array, small, end);
        System.out.println(Arrays.toString(array));
        System.out.println("small: " + small);
        return small;
    }

    public static int partition1(int[] array, int start, int end) {
        int pivotIndex = Helper.random(start, end);
        int pivot = array[pivotIndex];
        Helper.swap(array, start, pivotIndex);
        int small = start;
        for (int i = start + 1; i <= end; i++) {
            if (array[i] < pivot) {
                small++;
                if (small < i) {
                    Helper.swap(array, small, i);
                }
            }
        }
        Helper.swap(array, start, small);
        System.out.println(Arrays.toString(array));
        return small;
    }

    public static int partition2(int[] array, int start, int end) {
        int pivotIndex = Helper.random(start, end);
        int pivot = array[pivotIndex];
        Helper.swap(array, start, pivotIndex);
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && array[j] >= pivot) {
                j--;
            }
            while (i < j && array[i] <= pivot) {
                i++;
            }
            Helper.swap(array, i, j);
        }
        Helper.swap(array, i, start);
        System.out.println(Arrays.toString(array));
        return i;
    }

    /**
     * 对int数组进行快速排序
     *
     * @param array 待排序int数组
     */
    public static void quickSort1(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int start = 0;
        int end = array.length - 1;
        quickSort1(array, start, end);
    }

    public static void quickSort1(int[] array, int start, int end) {
        if (start < 0 || start >= array.length || end < 0 || end >= array.length || start > end) {
            return;
        }

        int pivot = array[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && array[j] >= pivot) {
                j--;
            }
            while (i < j && array[i] <= pivot) {
                i++;
            }
            Helper.swap(array, i, j);
        }
        Helper.swap(array, start, i);
        quickSort1(array, start, j - 1);
        quickSort1(array, j + 1, end);
    }

    /**
     * 对int数组进行快速排序
     *
     * @param array 待排序int数组
     */
    public static void quickSort2(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int start = 0;
        int end = array.length - 1;
        quickSort2(array, start, end);
    }

    public static void quickSort2(int[] array, int start, int end) {
        System.out.println("start: " + start);
        System.out.println("end: " + end);
        if (start < 0 || start >= array.length || end < 0 || end >= array.length || start > end) {
            return;
        }
        int pivot = array[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && array[j] > pivot) {
                j--;
            }
            array[i] = array[j];
            while (i < j && array[i] < pivot) {
                i++;
            }
            array[j--] = array[i];
        }
        array[i] = pivot;
        System.out.println(Arrays.toString(array));
        //注意不能写成 quickSort2(array, start, j - 1)，quickSort2(array, j + 1, end)，会无限循环。
        quickSort2(array, start, i - 1);
        quickSort2(array, i + 1, end);
    }
}
