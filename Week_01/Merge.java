package leetcode;

import org.junit.Test;

public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //合并两个有序数组
        //指针i遍历数组1，指针j遍历数组2
        //如果指针i对应的值大于指针j对用的值，则将数组1中从指针i往后移动一位，将数组2中指针j对应的值添加进数组1中指针i的位置，i、j同时加一
        //当i < m + m && j < n时结束循环
        if (n == 0) {
            return;
        }
        int i = 0, j = 0;
        while (i < m + n && j < n) {
            if (i >= m + j) {
                nums1[i] = nums2[j];
                i++;
                j++;
                continue;
            }
            if (nums1[i] > nums2[j]) {
                for (int k = m + j - 1; k >= i; k--) {
                    nums1[k + 1] = nums1[k];
                }
                nums1[i] = nums2[j];
                j++;
            }
            i++;
        }

    }

}
