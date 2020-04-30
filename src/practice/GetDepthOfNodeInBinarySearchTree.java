package practice;

import util.Helper;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 在给定二叉搜索树中查找指定值对应结点的深度，和根结点到目标结点的路径
 *
 * @Author: Wang An
 * @Date: 4/26/2020 2:50 PM
 */
public class GetDepthOfNodeInBinarySearchTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = Helper.initBinarySearchTree();
//        root = null;
        Helper.displayBinaryTree(root);
        System.out.println("Please input a number: ");
        int target = sc.nextInt();
        List<TreeNode> path = getPath(root, target);
        System.out.print("path: ");
        for (TreeNode node : path) {
            System.out.print(node.val + " ");
        }
        System.out.println();
    }

    /**
     * 返回根结点到结点值等于目标值的结点的路径
     *
     * @param root   二叉搜索树的根结点
     * @param target 目标值
     * @return 根结点到结点值等于目标值的结点的路径
     */
    public static List<TreeNode> getPath(TreeNode root, int target) {
        List<TreeNode> path = new ArrayList<>();
        int depth = getDepth(root, target, path);
        System.out.println("depth: " + depth);
        return path;
    }

    /**
     * 计算结点值等于目标值的结点在二叉搜索树中的深度
     *
     * @param root   二叉搜索树中的根结点
     * @param target 目标值
     * @param path   根节点到目标结点的路径
     * @return 结点值等于目标值的结点在二叉搜索树中的深度
     */
    public static int getDepth(TreeNode root, int target, List<TreeNode> path) {
        if (root == null) {
            return -1;
        }
        if (target == root.val) {
            path.add(0, root);
            return 0;
        } else if (target > root.val) {
            int depth = getDepth(root.right, target, path);
            if (depth == -1) {
                return -1;
            } else {
                path.add(0, root);
                return 1 + depth;
            }
        } else {
            int depth = getDepth(root.left, target, path);
            if (depth == -1) {
                return -1;
            } else {
                path.add(0, root);
                return 1 + depth;
            }
        }
    }
}
