package practice;

import util.Helper;

import java.util.ArrayList;

/**
 * 全排列算法
 *
 * @Author: Wang An
 * @Date: 4/30/2020 11:57 PM
 */
public class Permutation {
    public static void main(String[] args) {
        ArrayList<Integer> list = Helper.initPositiveArrayList(10, 4);
        list.clear();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("original list: " + list);

        StringBuffer sb = new StringBuffer();
        ArrayList<String> permutations = new ArrayList<>();
        permute(list, sb, permutations);
        System.out.println("permutations: " + permutations);

        permutations.clear();
        permute(list, 0, permutations);
        System.out.println("permutations: " + permutations);

        permutations.clear();
        permute1(list, 0, permutations);
        System.out.println("permutations: " + permutations);
    }

    /**
     * 全排列 —— 空间复杂度较高
     *
     * @param list         Integer列表
     * @param sb           字符串拼接器
     * @param permutations 组合列表
     */
    public static void permute(ArrayList<Integer> list, StringBuffer sb, ArrayList<String> permutations) {
        if (list == null || list.size() == 0) {
            if (!permutations.contains(sb.toString())) {
                permutations.add(sb.toString());
            }
            return;
        }
        String str = sb.toString();
        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i);
            sb = new StringBuffer(str);
            sb.append(temp);
            list.remove(i);
            permute(list, sb, permutations);
            list.add(i, temp);
        }
    }

    /**
     * 全排列
     *
     * @param list         Integer列表
     * @param index        列表当前开始索引
     * @param permutations 组合列表
     */
    public static void permute(ArrayList<Integer> list, int index, ArrayList<String> permutations) {
        if (list == null || index >= list.size() - 1) {
            String str = Helper.toString(list);
            if (!permutations.contains(str)) {
                permutations.add(str);
            }
        }

        for (int i = index; i < list.size(); i++) {
            Helper.swap(list, index, i);
            permute(list, index + 1, permutations);
            Helper.swap(list, index, i);
        }
    }

    /**
     * 全排列
     *
     * @param list         Integer列表
     * @param index        列表当前开始索引
     * @param permutations 组合列表
     */
    public static void permute1(ArrayList<Integer> list, int index, ArrayList<String> permutations) {
        if (list == null || index >= list.size() - 1) {
            permutations.add(Helper.toString(list));
            return;
        }

        ArrayList<Integer> exist = new ArrayList<>();
        for (int i = index; i < list.size(); i++) {
            if (!exist.contains(list.get(i))) {
                exist.add(list.get(i));
                Helper.swap(list, index, i);
                permute1(list, index + 1, permutations);
                Helper.swap(list, index, i);
            }
        }
    }

    /**
     * 全排列
     *
     * @param list         Integer列表
     * @param index        列表当前开始索引
     * @param permutations 组合列表
     */
    public static void permute2(ArrayList<Integer> list, int index, ArrayList<String> permutations) {
        // 此处为和permute1不同之处，因为缺乏return，需要修改条件：index >= list.size()，即使列表中所有元素全部排完，其中奥妙需自己体会。
        if (list == null || index >= list.size()) {
            permutations.add(Helper.toString(list));
        }

        ArrayList<Integer> exist = new ArrayList<>();
        for (int i = index; i < list.size(); i++) {
            if (!exist.contains(list.get(i))) {
                exist.add(list.get(i));
                Helper.swap(list, index, i);
                permute1(list, index + 1, permutations);
                Helper.swap(list, index, i);
            }
        }
    }
}
