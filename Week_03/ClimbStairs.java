package leetcode;

public class ClimbStairs {

    /**
     * 爬楼梯
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        //1.递归
        //使用二叉树的方式画一下递归的结果，节点个数是2^n，深度是n
        //时间复杂度 O(2^n)
        //空间复杂度 O(n)
        if (n <= 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }


    public int climbStairsV2(int n) {
        //通过递归的方式，但把中间结果存一下
        //时间复杂度 O(n)
        //空间复杂度 O(n)
        int[] memory = new int[n + 1];
        return climbMemory(n, memory);
    }

    private int climbMemory(int n, int[] memory) {
        if (memory[n] > 0) {
            return memory[n];
        }
        if (n == 0) {
            memory[n] = 1;
        } else if (n <= 2) {
            memory[n] = n;
        } else {
            memory[n] = climbMemory(n - 1, memory) + climbMemory(n - 2, memory);
        }
        return memory[n];
    }


    public int climbStairsV3(int n) {
        //2.动态规划
        //时间复杂度 O(n)
        //空间复杂度 O(1)
        if (n == 0) {
            return 1;
        }
        if (n <= 2) {
            return n;
        }
        int f1 = 1, f2 = 2, f3 = 3;
        for (int i = 3; i < n; i++) {
            f1 = f2;
            f2 = f3;
            f3 = f1 + f2;
        }
        return  f3;
    }


    public int climbStairsV4(int n) {
        //题解答案
        //动态规划
        int f1 = 0, f2 = 0, f3 = 1;
        for (int i = 0; i < n; i++) {
            f1 = f2;
            f2 = f3;
            f3 = f1 + f2;
        }
        return  f3;
    }
    //这种写法写得很简单，但不是很好想
    //题解中还有使用矩阵和使用通项公式的方法，看不太懂

}
