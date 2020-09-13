package leetcode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {

    @Test
    public void testExchange() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        System.out.println(invertTree(root));
    }

    /**
     * 翻转二叉树
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //思路
        //交换左右子树
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        if (root.left != null) {
            root.left = invertTree(root.left);
        }
        if (root.right != null) {
            root.right = invertTree(root.right);
        }
        return root;
    }


    public TreeNode invertTreeV2(TreeNode root) {
        if (root == null) {
            return null;
        }
        //题解递归方法
        TreeNode left = invertTreeV2(root.left);
        TreeNode right = invertTreeV2(root.right);
        root.right = left;
        root.left = right;
        return root;

        //题解的方法写得很简洁
    }


    public TreeNode invertTreeV3(TreeNode root) {
        if (root == null) {
            return null;
        }
        //题解迭代方法
        //创建一个队列，先进先出
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.right;
            node.right = node.left;
            node.left = temp;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;

        //LinkedList中offer方法其实就是调用了add方法。
        //我的逻辑和题解的迭代的方法逻辑比较像。
        //不管是递归还是迭代方法，因为要遍历二叉树的所有节点，所以时间复杂度是O(n)
         //The space complexity is also O(n)
    }

}
