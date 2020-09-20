package leetcode;

import org.junit.Test;

import java.util.*;

public class SolveNQueens {

    /**
     * n皇
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<List<String>> resultList = new ArrayList<>();
        //竖线
        List<Integer> columns = new ArrayList<>();
        //斜线
        List<Integer> x1 = new ArrayList<>();
        List<Integer> x2 = new ArrayList<>();
        recursion(0, 0, n, columns, x1, x2, resultList);
        return resultList;
    }

    private void recursion(int row, int col, int n, List<Integer> columns, List<Integer> x1,
                           List<Integer> x2, List<List<String>> resultList) {
        if (row == n) {
            if (row == columns.size() && row == x1.size() && row == x2.size()) {
                //找到解决方案
                handle(n, columns, x1, x2, resultList);
                //找到解决方案，添加到结果集后，需要将最后竖线和斜线集合中最后一个添加的元素删除，以继续回溯到最后一行，继续寻找位置
                columns.remove(columns.size() - 1);
                x1.remove(x1.size() - 1);
                x2.remove(x2.size() - 1);
            }
            return;
        }

        while (col < n) {
            if (columns.contains(col) || x1.contains(row - col) || x2.contains(row + col)) {
                //会被攻击到
                col++;
            } else {
                //不会被攻击到
                columns.add(col);
                x1.add(row - col);
                x2.add(row + col);
                recursion(++row, 0, n, columns, x1, x2, resultList);
                row--;
                col++;
            }
        }
        if (col == n && row > 0) {
            //无处可放，所有可选择的位置都会被攻击到
            //需添加row大于零的判断条件，否则回溯到第一行，没有找到位置时，这里会报异常，因为这时columns.size()等于零
            columns.remove(columns.size() - 1);
            x1.remove(x1.size() - 1);
            x2.remove(x2.size() - 1);
//            recursion(--row, remove + 1, n, columns, x1, x2, resultList);
            return;
        }
    }

    private void handle(int n, List<Integer> columns, List<Integer> x1, List<Integer> x2,
                        List<List<String>> resultList) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == columns.get(i) && ((i - j) == x1.get(i)) && ((i + j) == x2.get(i))) {
                    stringBuilder.append("Q");
                } else {
                    stringBuilder.append(".");
                }
            }
            list.add(stringBuilder.toString());
        }
        resultList.add(list);
    }


    @Test
    public void testHandle() {
        List<List<String>> resultList = new ArrayList<>();
        //竖线
        List<Integer> columns = Arrays.asList(1, 3, 0, 2);
        //斜线
        List<Integer> x1 = Arrays.asList(-1, -2, 2, 1);
        List<Integer> x2 = Arrays.asList(1, 4, 2, 5);
        handle(4, columns, x1, x2, resultList);
        System.out.println(resultList);
    }

    @Test
    public void testNQueens() {
        List<List<String>> lists = solveNQueens(4);
        System.out.println(lists);

        //调试了好久才磕磕绊绊的写出来
    }

}
