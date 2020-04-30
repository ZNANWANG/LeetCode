package interview;

import java.util.*;

/**
 * 疯狂游戏笔试题目 —— 面值组合
 * 50%
 *
 * 题目描述：
 * 现手中有各种面值的纸币若干张，请计算给定价值的商品有多少种付费方式。
 *
 * 输入描述：
 * 拥有的纸币面值用“,"分隔的数字来表示，每个数字表示拥有的一张纸币的面值。纸币面值和商品价格用”;“分隔，分号前为纸币的各种面值，后面的表示商品
 * 价格。
 *
 * 输出描述：
 * 将各种面值组合按照面值从小到大的方式依次展示（1,2;），元素个数少的组合先显示(5;1,2;3,4)，相同元素个数的组合按照面值大小从小到大依次显示
 * (1,2;3,4)。
 *
 * 输入示例1：
 * 1,1;2
 *
 * 输出示例1；
 * 1,1
 *
 * 输入示例2：
 * 1,2,3,4,5;5
 *
 * 输出示例2：
 * 5;1,2;3,4
 *
 * @Author: Wang An
 * @Date: 4/29/2020 7:32 PM
 */
public class CrazyGame3 {
    static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String[] strs = sc.nextLine().split(";");
            if(strs.length == 2) {
                String[] strs1 = strs[0].split(",");
                ArrayList<Integer> money = new ArrayList<>();
                for (int i = 0; i < strs1.length; i++) {
                    money.add(Integer.parseInt(strs1[i]));
                }
                int price = Integer.parseInt(strs[1]);
                getCombination(money, price);
                String ret = getResult();
                System.out.println(ret);
            } else {
                System.out.println();
            }

            result.clear();
        }
        sc.close();
    }

    public static String getResult(){
        Set<Integer> counts = new TreeSet<>();
        for (int i = 0; i < result.size(); i++) {
            counts.add(result.get(i).size());
        }

        StringBuffer sb = new StringBuffer();
        for (Integer count : counts) {
            for (int i = 0; i < result.size(); i++) {
                if (result.get(i).size() == count) {
                    for (int j = 0; j < count; j++) {
                        sb.append(result.get(i).get(j));
                        if (j != count - 1) {
                            sb.append(",");
                        }
                    }
                    sb.append(";");
                }
            }
        }
        String ret = sb.toString();
        if (ret.length() > 0) {
            ret = ret.substring(0, ret.length() - 1);
        }
        return ret;
    }

    public static void getCombination(ArrayList<Integer> money, int price){
        if(money.size() == 0 || price <= 0){
            return;
        }
        for(int i = 0; i < money.size(); i++){
            int temp = money.get(i);
            money.remove(i);
            ArrayList<Integer> list = new ArrayList<>();
            list.add(temp);
            if(getCombination(money, price - temp, list) == 1){
                result.add(list);
            }

//            System.out.println(list);
            money.add(i, temp);
        }
    }

    public static int getCombination(ArrayList<Integer> money, int price, ArrayList<Integer> list){
        if(money.size() == 0 && price > 0){
            return -1;
        }
        if(price == 0){
            return 1;
        }

        for(int i = 0; i < money.size();i++){
            int temp = money.get(i);
            money.remove(i);
            if(getCombination(money, price - temp, list) == 1){
                list.add(temp);
                return 1;
            }
            money.add(i, temp);
        }
        return -1;
    }
}
