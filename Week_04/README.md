学习笔记

2020.09.20

深度优先（DFS）代码模板：

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if(root==null){
            return allResults;
        }
        travel(root,0,allResults);
        return allResults;
    }


    private void travel(TreeNode root,int level,List<List<Integer>> results){
        if(results.size()==level){
            results.add(new ArrayList<>());
        }
        results.get(level).add(root.val);
        if(root.left!=null){
            travel(root.left,level+1,results);
        }
        if(root.right!=null){
            travel(root.right,level+1,results);
        }
    }

广度优先（BFS）代码模板：

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> allResults = new ArrayList<>();
		if (root == null) {
			return allResults;
		}
		Queue<TreeNode> nodes = new LinkedList<>();
		nodes.add(root);
		while (!nodes.isEmpty()) {
			int size = nodes.size();
			List<Integer> results = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = nodes.poll();
				results.add(node.val);
				if (node.left != null) {
					nodes.add(node.left);
				}
				if (node.right != null) {
					nodes.add(node.right);
				}
			}
			allResults.add(results);
		}
		return allResults;
	}


分别用深度优先和广度优先的方法练习了一下“二叉树的层次遍历”题目和“在每个树行中找最大值”题目，
熟悉了一下深度优先和广度优先的代码模板。


**433.最小基因变化题目没有理解清楚。**


二分查找的前提：
1. 目标函数单调性（单调递增或单调递减）
2. 存在上下界
3. 能够通过索引访问


二分查找的代码模板：

	public int binarySearch(int[] array, int target) {
		int left = 0, right = array.length - 1, mid;
		while (left <= right) {
			mid = (right - left) / 2 + left;

			if (array[mid] == target) {
				return mid;
			} else if (array[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return -1;
	}


>作业：使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

	public class SearchRotate {

		public int search(int[] nums) {
			if (nums == null) {
				return -1;
			}
			int i = 0, j = nums.length - 1;
			while (i < j) {
				int mid = (i + j) / 2;
				if (nums[mid] < nums[mid - 1]) {
					return mid;
				} else if (nums[mid] > nums[mid + 1]) {
					return mid + 1;
				} else if (nums[mid] < nums[i]) {
					j = mid - 1;
				} else if (nums[mid] > nums[j]) {
					i = mid + 1;
				}
			}
			return -1;
		}


		@Test
		public void testSerch() {
			int[] arr = new int[]{5, 6, 7, 8 ,9 ,10, 11, 0, 1, 2, 3, 4};
			System.out.println(search(arr));
		}

	}
	
