package interview;

import java.util.Scanner;

/**
 * 疯狂游戏笔试题目 —— 判断空间中三点是否能构成三角形
 * 50%
 *
 * @Author: Wang An
 * @Date: 4/29/2020 7:00 PM
 */
public class CrazyGame1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] strs = sc.nextLine().split("\\s+");
            double x1 = Double.parseDouble(strs[0].substring(1, strs[0].length() - 1));
            double y1 = Double.parseDouble(strs[1].substring(0, strs[1].length() - 1));
            double z1 = Double.parseDouble(strs[2].substring(0, strs[2].length() - 1));
            double x2 = Double.parseDouble(strs[3].substring(1, strs[3].length() - 1));
            double y2 = Double.parseDouble(strs[4].substring(0, strs[4].length() - 1));
            double z2 = Double.parseDouble(strs[5].substring(0, strs[5].length() - 1));
            double x3 = Double.parseDouble(strs[6].substring(1, strs[6].length() - 1));
            double y3 = Double.parseDouble(strs[7].substring(0, strs[7].length() - 1));
            double z3 = Double.parseDouble(strs[8].substring(0, strs[8].length() - 1));
//            System.out.println("x1 = " + x1);
//            System.out.println("y1 = " + y1);
//            System.out.println("z1 = " + z1);
//            System.out.println("x2 = " + x2);
//            System.out.println("y2 = " + y2);
//            System.out.println("z2 = " + z2);
//            System.out.println("x3 = " + x3);
//            System.out.println("y3 = " + y3);
//            System.out.println("z3 = " + z3);

            double ab = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2) + Math.pow((z1 - z2), 2));
            double ac = Math.sqrt(Math.pow((x1 - x3), 2) + Math.pow((y1 - y3), 2) + Math.pow((z1 - z3), 2));
            double bc = Math.sqrt(Math.pow((x2 - x3), 2) + Math.pow((y2 - y3), 2) + Math.pow((z2 - z3), 2));

            if(ab + ac > bc && ab + bc > ac && bc + ac > ab && ab > 0 && bc > 0 && ac > 0){
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
        sc.close();
    }
}
