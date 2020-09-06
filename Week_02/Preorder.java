package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Preorder {

    public List<Integer> preorder(Node root) {
        //N叉树的前序遍历
        //前序遍历即根-左-右
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        recursion(root.children, list);
        return list;
    }

    private void recursion(List<Node> children, List<Integer> list) {
        if (children != null) {
            for (Node child : children) {
                if (child != null) {
                    list.add(child.val);
                    recursion(child.children, list);
                }
            }
        }
    }


    public List<Integer> preorderV2(Node root) {
        List<Integer> list = new ArrayList<>();
        recursion(root, list);
        return list;
    }

    public void recursion(Node root, List<Integer> list) {
        if(root == null) {
            return;
        }
        list.add(root.val);
        if(root.children == null) {
            return;
        }
        for(Node node : root.children) {
            recursion(node, list);
        }
    }

}
