package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    /**
     * 括号生成
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return null;
        }
        List<String> list = new ArrayList<>();
        generate(0, 0, n, "", list);
        return list;
    }

    /**
     * @param left 左括号数量
     * @param right 右括号数量
     * @param n
     * @param s 拼接括号序列
     * @param list 返回的结果结合
     */
    private void generate(int left, int right, int n, String s, List<String> list) {
        //如果左括号数量和右括号数量等于n，则添加括号序列到结果集合中
        if (left == n && right == n) {
            list.add(s);
        }
        //如果左括号数量小于n，则可以拼接左括号
        if (left < n) {
            generate(left + 1, right, n, s + "(", list);
        }
        //如果右括号数量小于左括号数量，则可以拼接右括号
        if (right < left) {
            generate(left, right + 1, n, s + ")", list);
        }
    }


    //这道题目自己理解的不太好
    //这个题目官方题解中动态规划的那个方法没理解到
    //精选题解中有用深度优先和广度优先的方法，等回过头来再看

}
