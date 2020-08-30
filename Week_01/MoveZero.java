package leetcode;

public class MoveZero {

    private void moveZeroes(int[] nums) {
        //移动零
        int temp, j;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                continue;
            }
            j = i + 1;
            while (j < nums.length - 1 && nums[j] == 0) {
                j++;
            }
            if (j < nums.length) {
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            } else {
                return;
            }

        }
    }

    private void moveZeroesV2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }

        }
    }

    private void moveZeroesV3(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }

        }
    }

    private void moveZeroesV4(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                j++;
            }

        }
    }
}
