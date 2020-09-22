package leetcode.week_04;

import org.junit.Test;

import java.util.*;

/**
 * 寻找每个树行中的最大值
 */
public class LargestValues {

    public List<Integer> largestValues(TreeNode root) {
        //思路
        //广度优先遍历得到树每一行的值，用大根堆存储
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 默认是小根堆，实现大根堆需要重写一下比较器。
            Queue<Integer> minHeap = new PriorityQueue<>((v1, v2) -> v2 - v1);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (minHeap.isEmpty()) {
                    minHeap.offer(node.val);
                } else if (node.val > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(minHeap.peek());
        }
        return list;
    }


    public List<Integer> largestValuesV2(TreeNode root) {
        //题解中的答案，广度优先
        //我还用堆存，其实没有必要。
        //LinkedList实现队列
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> values = new ArrayList<>();
        if (root != null) {
            //入队
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            //每一层的数量
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                //出队
                TreeNode node = queue.poll();
                //记录每层的最大值
                max = Math.max(max, node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            values.add(max);
        }
        return values;
    }


    public List<Integer> largestValuesV3(TreeNode root) {
        //深度优先
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        dfs(0, root, list);
        return list;
    }

    private void dfs(int i, TreeNode node, List<Integer> list) {
        if (i >= list.size()) {
            list.add(node.val);
        } else {
            if (node.val > list.get(i)) {
                list.remove(i);
                list.add(i, node.val);
            }
        }
        if (node.left != null) {
            dfs(i + 1, node.left, list);
        }
        if (node.right != null) {
            dfs(i + 1, node.right, list);
        }
    }


    @Test
    public void testLargest() {
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(5);
        TreeNode root3 = new TreeNode(0);
        TreeNode root4 = new TreeNode(2);
        TreeNode root5 = new TreeNode(4);
        TreeNode root6 = new TreeNode(6);
        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root1.right = root4;
        root2.left = root5;
        root2.right = root6;
        List<Integer> list = largestValuesV3(root);
        System.out.println(list);
    }

}
