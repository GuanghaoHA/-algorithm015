package leetcode;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        //使用 O(1) 额外空间的条件下完成
        //快慢指针，慢指针i从下标0开始，快指针j从下标1开始，
        //使用快指针j遍历数组，如果快慢指针对应的值相等，则继续遍历，
        //如果快慢指针对应的值不相等，则将快指针对应的值赋到慢指针下标加1的位置。
        //遍历结束，慢指针i加1就是数组中不重复的值的数量。
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}
