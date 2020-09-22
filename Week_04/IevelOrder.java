package leetcode.week_04;

import java.util.*;

/**
 * 二叉树的层次遍历
 */
public class IevelOrder {

    public List<List<Integer>> levelOrderV2(TreeNode root) {
        //广度优先
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            //记录队列的长度
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            resultList.add(list);
        }
        return resultList;

        //这是广度优先的代码模板
    }

    public List<List<Integer>> levelOrderV3(TreeNode root) {
        //深度优先
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        resultList.add(new ArrayList<>());
        dfs(root, 0, resultList);
        return resultList;
    }

    private void dfs(TreeNode node, int i, List<List<Integer>> resultList) {
        List<Integer> list = resultList.get(i);
        list.add(node.val);
        if (node.left != null || node.right != null) {
            i++;
            //需要判断i是否等于结果集合的长度，不判断直接在结果集合中添加一个空集合的话，最后返回的结果集合中会多一个空集合
            if (i == resultList.size()) {
                resultList.add(new ArrayList<>());
            }
        }
        if (node.left != null) {
            dfs(node.left, i, resultList);
        }
        if (node.right != null) {
            dfs(node.right, i, resultList);
        }
    }


    public List<List<Integer>> levelOrderV4(TreeNode root) {
        //国际站高票答案，深度优先
        List<List<Integer>> res = new ArrayList<>();
        levelHelper(res, root, 0);
        return res;
    }

    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
    }

}
