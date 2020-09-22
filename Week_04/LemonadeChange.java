package leetcode.week_04;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 柠檬水找零
 */
public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        //思路
        //遍历bills数组中的元素，
        //如果元素是5，则计数i加一，
        //如果元素是10，则计数i减一，判断此时i是否小于零，如果小于零，返回false，如果i不小于零，则计数j加一，
        //如果元素是20，则计数j减一并计数i减一，判断如果i或j小于零，则尝试计数i减三，判断i是否小于零，
        //若两种尝试计数都小于零，则返回false
        int i = 0, j = 0;
        for (int bill : bills) {
            if (bill == 5) {
                i++;
            } else if (bill == 10) {
                if (i < 1) {
                    return false;
                } else {
                    i--;
                    j++;
                }
            } else if (bill == 20) {
                if (j >= 1 && i >= 1) {
                    j--;
                    i--;
                } else if (i >= 3) {
                    i -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }


    @Test
    public void testLemonade() {
        int[] arr = new int[]{5, 5, 10, 20};
        System.out.println(lemonadeChange(arr));
    }

}
