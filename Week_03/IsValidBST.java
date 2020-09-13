package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class IsValidBST {

    /**
     * 验证二叉搜索树
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        //题解的递归方法
        //验证是否是二叉搜索树，需要有一个上下界（开区间）来判断当前节点是否符合二叉搜索树的性质
        return recursion(root, null, null);
    }

    private boolean recursion(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            //空树是二叉搜索树
            return true;
        }
        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }
        recursion(node.left, lower, val);
        recursion(node.right, val, upper);
        return true;
    }


    public boolean isValidBSTV2(TreeNode root) {
        if (root == null) {
            return true;
        }
        //题解的使用中序遍历方法，因为中序遍历后所有的节点值是有序的
        //创建一个栈保存中序遍历的结果
        Deque<TreeNode> deque = new LinkedList<>();
        return infixOrder(root, deque);
    }

    private boolean infixOrder(TreeNode node, Deque<TreeNode> deque) {
        if (node == null) {
            return true;
        }
        boolean flag = infixOrder(node.left, deque);
        if (!flag || (!deque.isEmpty() && node.val <= deque.peekLast().val)) {
            return false;
        }
        deque.addLast(node);
        return infixOrder(node.right, deque);

        //调了一段时间才通过，递归的模板还是不太熟练，加上判断条件后逻辑就有些乱了。
        //题解中使用中序遍历的方法是迭代栈，不太好理解
    }


    //有一个答案是这样写的，用一个变量替代了栈
    long pre = Long.MIN_VALUE;
    public boolean isValidBSTV3(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }

}
