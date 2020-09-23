package leetcode.week_04;

import java.util.Arrays;

/**
 * 分发饼干
 */
public class FindContentChildren {

    public int findContentChildren(int[] g, int[] s) {
        //思路
        //对两个数组排序
        //双重循环，遍历饼干是否满足孩子的胃口，若满足将当前饼干的值置为零，计数加一，若不满足，返回计数的值
        if (g == null || s == null) {
            return 0;
        }
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < s.length; j++) {
                if (s[j] >= g[i]) {
                    count++;
                    s[j] = 0;
                    break;
                }
            }
            if (i == count) {
                return count;
            }
        }
        return count;
    }


    public int findContentChildrenV2(int[] grid, int[] size) {
        if (grid == null || size == null) return 0;
        Arrays.sort(grid);
        Arrays.sort(size);
        int gi = 0, si = 0;
        while (gi < grid.length && si < size.length) {
            if (grid[gi] <= size[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }
    //题解中的答案，写得简单很多

}
