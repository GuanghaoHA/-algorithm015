package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class Rotate {

    public void rotate(int[] nums, int k) {
        //旋转数组
        //一开始自己没有理解题意，以为如果k的值大于数组的长度就直接return或者按照数组的长度减一来移动。
        //没想过如果k的值大于数组的长度，就重新再从下标0开始计算。
        if (nums == null) {
            return;
        }
        //方法1：创建一个新数组
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int j = k + i;
            while (j >= nums.length) {
                j -= nums.length;
            }
            newNums[j] = nums[i];
        }
        /*
        //官方题解，i + k取余就可以得到应该移动的位置
        for (int i = 0; i < nums.length; i++) {
            newNums[(i + k) % nums.length] = nums[i];
        }
        */

        for (int i = 0; i < nums.length; i++) {
            nums[i] = newNums[i];
        }

    }


    public void rotateV2(int[] nums, int k) {
        //旋转数组
        if (nums == null || k == 0) {
            return;
        }
        //方法2：先移动数组下标0对应的值，将下标0与它将要移动到的位置的下标对应的值做替换，
        //以例题为例，输入: [1,2,3,4,5,6,7] 和 k = 3，
        //下标0对应的值与下标3对应的值做替换，下标0对应的值就到了它要在的位置，计数器count加一；
        //移动之前的下标3对应的值到了下标0的位置，然后找到移动之前的下标3对应的值应该移动的位置，即下标6.
        //再做替换，即将下标0对应的值与下标6对应的值替换，计数器加一；
        //以此直到计数器等于数组的长度减一，说明数组中每个值都移动完成。

        int count = 0;
        int i = 0, m = 0;
        int temp, j;
        while (count == nums.length - 1) {
            j = m + k;
            while (j >= nums.length) {
                j -= nums.length;
            }
            temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            m = j;
            count++;

            //这种情况会解答错误
            //输入
            //[1,2,3,4]
            //2
            //输出
            //[1,2,3,4]
            //预期结果
            //[3,4,1,2]

        }
    }


    public void rotateV3(int[] nums, int k) {
        //题解中的环状替换方法
        //我想到了环状替换，但我实现的时候失败了。
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }


    public void rotateV4(int[] nums, int k) {
        //题解中的反转方法，这个有点神奇
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
