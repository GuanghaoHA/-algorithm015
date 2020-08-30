package leetcode;

import java.util.*;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        //两数之和
        int[] twoSum = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    twoSum[0] = i;
                    twoSum[1] = j;
                    return twoSum;
                }
            }
        }

        return twoSum;
    }
}
