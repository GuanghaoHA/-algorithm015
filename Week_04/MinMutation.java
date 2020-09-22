package leetcode.week_04;

import org.junit.Test;

import javax.security.auth.login.Configuration;
import java.util.*;

public class MinMutation {

    public int minMutation(String start, String end, String[] bank) {
        //思路
        //我只能想到一种方法
        //start向end变化一次成为middle，将middle添加进一个集合中
        //待所有的变化都添加进集合中后，遍历集合，判断集合中的元素是否都包含在bank中
        //若包含，则计数加一
        //若不包含，则返回-1
        //自己没实现出来，下面是题解里的答案
        if (start == null || end == null || bank == null) {
            return -1;
        }
        HashSet<String> set = new HashSet<>(Arrays.asList(bank));
        char[] four = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        set.remove(start);
        int step = 0;
        while (queue.size() > 0) {
            step++;
            for (int count = queue.size(); count > 0; --count) {
                char[] temStringChars = queue.poll().toCharArray();
                for (int i = 0, len = temStringChars.length; i < len; ++i) {
                    char oldChar = temStringChars[i];
                    for (int j = 0; j < 4; ++j) {
                        temStringChars[i] = four[j];
                        String newGenetic = new String(temStringChars);
                        if (end.equals(newGenetic)) {
                            return step;
                        } else if (set.contains(newGenetic)) {
                            set.remove(newGenetic);
                            queue.offer(newGenetic);
                        }
                    }
                    temStringChars[i] = oldChar;
                }
            }
        }

        return -1;
    }


    @Test
    public void testMinMutation() {
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] bank = new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        System.out.println(minMutation(start, end, bank));
    }

}
