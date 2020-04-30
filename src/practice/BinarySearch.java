package practice;

import util.Helper;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 二分查找 —— 针对有序数组
 *
 * @Author: Wang An
 * @Date: 4/25/2020 11:33 PM
 */
public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Helper.initArray(50, 10);
        Arrays.sort(array);
        System.out.println("original array: " + Arrays.toString(array));
        test:
        while (true) {
            int target = 0;
            while (true) {
                System.out.println("Please input a number to search: ");
                String input = sc.next();
                if (input.matches("[+-]?\\d+")) {
                    target = Integer.parseInt(input);
                    break;
                } else {
                    System.out.print("Invalid number,");
                }
            }
            int result = binarySearch1(array, target);
            System.out.println(result);
            while (true) {
                System.out.println("Do you want to try again? (y/n)");
                String response = sc.next().toLowerCase();
                if (response.equals("n")) {
                    break test;
                } else if (!response.equals("y")) {
                    System.out.print("Invalid input.");
                } else {
                    break;
                }
            }
        }
        sc.close();
    }

    /**
     * 二分查找
     *
     * @param array  有序整数数组
     * @param target 目标值
     * @return 如果查找成功，返回目标值所在数组下标，如果查找失败，返回-1
     */
    public static int binarySearch(int[] array, int target) {
        if (array == null || array.length < 1) {
            return -1;
        }

        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                end = mid - 1;
            } else if (array[mid] < target) {
                start = mid + 1;
            }
//            System.out.println("start: " + start + " end: " + end);
        }
        return -1;
    }

    /**
     * 递归二分查找
     *
     * @param array  有序整数数组
     * @param target 目标值
     * @return 如果查找成功，返回目标值所在数组下标，如果查找失败，返回-1
     */
    public static int binarySearch1(int[] array, int target) {
        if (array == null || array.length < 1) {
            return -1;
        }
        int start = 0;
        int end = array.length - 1;
        return helper(array, start, end, target);
    }

    public static int helper(int[] array, int start, int end, int target) {
        if (start < 0 || start >= array.length || end < 0 || end >= array.length || start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (array[mid] == target) {
            return mid;
        } else if (array[mid] < target) {
            return helper(array, mid + 1, end, target);
        } else if (array[mid] > target) {
            return helper(array, start, mid - 1, target);
        }
        return -1;
    }
}
