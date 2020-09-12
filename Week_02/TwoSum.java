package leetcode;

import java.security.cert.TrustAnchor;
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


    public int[] twoSumV2(int[] nums, int target) {
        //两数之和
        //使用map集合，遍历nums数组，若map集合中不包含(target - nums[i])，则将nums[i]作为key，下标i作为value添加进map集合，
        //若包含(target - nums[i])，则将当前下标i和map集合中(target - nums[i])对应的value值（即(target - nums[i])的下标值）
        //添加进结果数组中并返回
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] twoSum = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                twoSum[1] = i;
                twoSum[0] = map.get(target - nums[i]);
                return twoSum;
            } else {
                map.put(nums[i], i);
            }
        }
        return twoSum;
    }

}
