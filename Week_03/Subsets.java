package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

    /**
     * 子集
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> resultList = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        recursion(0, nums, list, resultList);
        return resultList;
    }

    private void recursion(int i, int[] nums, List<Integer> list, List<List<Integer>> resultList) {
        if (i == nums.length) {
            //需要新创建一个list,复制子集list中的数据，然后添加到结果集合中
            List<Integer> listClone = new LinkedList<>(list);
//            List<Integer> listClone = list;
            resultList.add(listClone);
            return;
        }
        recursion(++i, nums, list, resultList);
        list.add(nums[--i]);
        recursion(++i, nums, list, resultList);
        //在将子集list集合中的数据添加进结果集合后，需要删除子集list中新添加的一个元素，即list集合中最后一个元素
        list.remove(list.size() - 1);
    }

    @Test
    public void testSubsets() {
        int[] arr = new int[]{1, 2, 3};
        List<List<Integer>> subsets = subsets(arr);
        System.out.println(subsets);
    }

}
