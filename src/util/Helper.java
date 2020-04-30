package util;

import java.util.*;

/**
 * @Author: Wang An
 * @Date: 4/24/2020 11:23 AM
 */
public class Helper {
    /**
     * 生成一个单元数字在[-range,range]范围内且长度为length的数组。
     *
     * @param range  区间左右端点绝对值，需不小于0，区间范围为[-range,range]
     * @param length 数组长度，需不小于0
     * @return 一个单元数字在[-range,range]范围内且长度为length的数组
     */
    public static int[] initArray(int range, int length) {
        if (length < 0 || range < 0) {
            return null;
        }
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(2 * range) - range;
        }
        return array;
    }

    /**
     * 生成一个单元数字在[-range,range]范围内且长度为size的列表。
     *
     * @param range 区间左右端点绝对值，需不小于0，区间范围为[-range,range]
     * @param size  列表长度，需不小于0
     * @return 一个单元数字在[-range,range]范围内且长度为size的列表
     */
    public static ArrayList<Integer> initArrayList(int range, int size) {
        if (size < 0 || range < 0) {
            return null;
        }
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(2 * range) - range);
        }
        return list;
    }

    /**
     * 生成一个单元数字在[0,range]范围内且长度为length的数组。
     *
     * @param range  区间左右端点绝对值，需不小于0，区间范围为[0,range]
     * @param length 数组长度，需不小于0
     * @return 一个单元数字在[0, range]范围内且长度为length的数组
     */
    public static int[] initPositiveArray(int range, int length) {
        if (length < 0 || range < 0) {
            return null;
        }
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(range);
        }
        return array;
    }

    /**
     * 生成一个单元数字在[0,range]范围内且长度为size的列表。
     *
     * @param range 区间左右端点绝对值，需不小于0，区间范围为[0,range]
     * @param size  列表长度，需不小于0
     * @return 一个单元数字在[0, range]范围内且长度为size的列表
     */
    public static ArrayList<Integer> initPositiveArrayList(int range, int size) {
        if (size < 0 || range < 0) {
            return null;
        }
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(range));
        }
        return list;
    }

    /**
     * 显示二维int型整数数组
     *
     * @param array 二维int型整数数组
     */
    public static void display(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    /**
     * 交换int数组的两个数字
     *
     * @param array int数组
     * @param i     第一个交换数字的索引
     * @param j     第二个交换数字的索引
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 交换Integer列表的两个数字
     *
     * @param list Integer列表
     * @param i    第一个交换数字的索引
     * @param j    第二个交换数字的索引
     */
    public static void swap(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    /**
     * 将Integer列表中的所有元素按照索引从小到大整合成为字符串并返回
     *
     * @param list Integer列表
     * @return 列表中所有元素按照索引从小到大组成的字符串
     */
    public static String toString(ArrayList<Integer> list) {
        StringBuffer sb = new StringBuffer();
        if (list == null || list.size() == 0) {
            return sb.toString();
        }
        for (Integer a : list) {
            sb.append(a);
        }
        return sb.toString();
    }

    /**
     * 输出[x, y]或者[y, x]范围内的任意一个int型整数
     *
     * @param x 范围上限或者下限
     * @param y 范围下限或者上限
     * @return [x, y]或者[y, x]范围内的任意一个int型整数
     */
    public static int random(int x, int y) {
        int max = x > y ? x : y;
        int min = x < y ? x : y;
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    /**
     * 生成一颗二叉搜索树
     *
     * @return 二叉搜索树的根结点
     */
    public static TreeNode initBinarySearchTree() {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(7);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.right = node6;
        return root;
    }

    /**
     * 逐层显示二叉树
     *
     * @param root 二叉树的根结点
     */
    public static void displayBinaryTree(TreeNode root) {
        if (root == null) {
            System.out.println("Empty binary tree");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            System.out.print(curNode.val);
            if (curNode.left != null) {
                queue.offer(curNode.left);
            }
            if (curNode.right != null) {
                queue.offer(curNode.right);
            }
            count--;
            if (count == 0) {
                count = queue.size();
                System.out.println();
            }
        }
    }

    /**
     * 打印显示单向链表
     *
     * @param head 单向链表的头结点
     */
    public static void displayLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
