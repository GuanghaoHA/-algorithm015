package leetcode.week_07;

/**
 * 547. 朋友圈
 */
public class FindCircleNum {

    public int findCircleNum(int[][] M) {
        UnionFind unionFind = new UnionFind(M.length);
        for (int i = 0; i < M.length - 1; i++) {
            for (int j = 1; j < M.length; j++) {
                if (M[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.getCount();
    }

    /**
     * 并查集
     */
    class UnionFind {

        private int count;
        private int[] parent;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                //压缩路径
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int pp = find(p);
            int qp = find(q);
            if (pp != qp) {
                parent[qp] = pp;
                count--;
            }
        }

        public int getCount() {
            return count;
        }

    }

}
