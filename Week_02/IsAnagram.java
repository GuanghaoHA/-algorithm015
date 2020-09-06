package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        //有效的字母异位词
        //异位词的意思是两个字符串中相同的字母出现次数一样，顺序可以不一样。
        //思路
        //可以用map集合记录遍历字符串s中字母出现的次数，每出现一次加一，然后遍历字符串t，每有一个相同的字母出现就减一，
        //最后遍历map集合，看是否每个key的值都为零，为零则返回true，否则返回false
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
//        AtomicBoolean result = new AtomicBoolean(true);
        Map<Character, Integer> map = new HashMap<>();
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        for (char c : charsS) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (char c : charsT) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }
//        map.forEach((k , v) -> {
//            if (v != 0) {
//                result.set(false);
//            }
//        });
//        return result.get();

        for (Integer value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;

        //题解中是用的长度26的int[]数组来记录，因为题目只包含小写字母。
    }

}
