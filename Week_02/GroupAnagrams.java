package leetcode;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        //49. 字母异位词分组
        if (strs == null || strs.length == 0) {
            return null;
        }
        //思路：
        //有效异位词的题目，可以使用两种方法，一种是排序后判断两个字符串是否相同，若相同则为异位词。
        //另一种方法是创建map集合计数每个符串的字符出现的次数，若两个字符串中的字符出现的次数完全一致则为异位词。（因为题目中规定只有小写字母，因此也可以创建一个26位长度的数组代替map集合）

        //异位词分组这个题目也可以使用排序的方法
        //遍历数组，将数组中的字符串排序并添加到map集合，key是排序后的字符串，value是排序前的字符串
        //时间复杂度 O(n * klogk)，其中k是strs中字符串的最大长度
         //空间复杂度 O(n * k)，需要使用n个长度为k的char数组
        List<List<String>> resultList = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = String.valueOf(array);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
//        map.values().forEach(resultList::add);
        resultList.addAll(map.values());
        return resultList;
    }


    public List<List<String>> groupAnagramsV2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        //使用计数
        //这种方法时间复杂度是 O(n * k)
        //空间复杂度是 O(n * k)
        //但在leetcode中用时反而比第一种方法要长很多。第一种方法用时7ms，而这种方法用时23ms.
        //可能是这种方法for循环下嵌套两个并列的for循环，而第一种方法是for循环下嵌套一个for循环，所以这种方法用时长一些。
        int[] array = new int[26];
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            Arrays.fill(array, 0);
            char[] chars = s.toCharArray();
            for (char c : chars) {
                array[c - 'a'] ++;
            }
            StringBuilder builder = new StringBuilder();
            for (int i : array) {
                builder.append("#");
                builder.append(i);
            }
            String key = builder.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }


    public List<List<String>> groupAnagramsV3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        //使用计数
        //这种方法时间复杂度是 O(n * k)
        //空间复杂度是 O(n * k)
        //国际站的这种解法也是使用计数的方法，但是用char数组代替了官方解法的int数组，用时7ms，这种方法更好一些。
        char[] array = new char[26];
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            Arrays.fill(array, 'a');
            char[] chars = s.toCharArray();
            for (char c : chars) {
                array[c - 'a']++;
            }
            String key = String.valueOf(array);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }


    @Test
    public void testArray() {
        List<String> list = Arrays.asList("aab", "baa", "tea");
        int[] array = new int[26];
        Map<String, List<String>> map = new HashMap<>();
        for (String s : list) {
            Arrays.fill(array, 0);
            char[] chars = s.toCharArray();
            for (char c : chars) {
                array[c - 'a'] ++;
            }
            System.out.println(Arrays.toString(array));
            String key = String.valueOf(array);
            System.out.println(key);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        System.out.println(map);
        /*
        [2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        [I@5e265ba4
        [2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        [I@5e265ba4
        [1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0]
        [I@5e265ba4
        {[I@5e265ba4=[aab, baa, tea]}
         */
    }

    @Test
    public void testArrayV2() {
        List<String> list = Arrays.asList("bdddddddddd", "bbbbbbbbbbc");
        int[] array = new int[26];
        Map<String, List<String>> map = new HashMap<>();
        for (String s : list) {
            Arrays.fill(array, 0);
            char[] chars = s.toCharArray();
            for (char c : chars) {
                array[c - 'a']++;
            }
            System.out.println(Arrays.toString(array));
            StringBuilder builder = new StringBuilder();
            for (int i : array) {
//                builder.append("#");
                builder.append(i);
            }
            String key = builder.toString();
            System.out.println(key);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        System.out.println(map);

        /*
        还奇怪为什么题解中要在StringBuilder中先添加"#"，然后再添加计数，因为如果不把计数间隔开的话，下面这种情况会解答错误：
        [0, 1, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        010100000000000000000000000
        [0, 10, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        010100000000000000000000000
        {010100000000000000000000000=[bdddddddddd, bbbbbbbbbbc]}
         */
    }

    @Test
    public void testArrayV3() {
        List<String> list = Arrays.asList("bdddddddddd", "bbbbbbbbbbc");
        char[] array = new char[26];
        Map<String, List<String>> map = new HashMap<>();
        for (String s : list) {
            Arrays.fill(array, 'a');
            char[] chars = s.toCharArray();
            for (char c : chars) {
                array[c - 'a']++;
            }
            System.out.println(Arrays.toString(array));
            String key = String.valueOf(array);
            System.out.println(key);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        System.out.println(map);

        /*
        [a, b, a, k, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a]
        abakaaaaaaaaaaaaaaaaaaaaaa
        [a, k, b, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a]
        akbaaaaaaaaaaaaaaaaaaaaaaa
        {akbaaaaaaaaaaaaaaaaaaaaaaa=[bbbbbbbbbbc], abakaaaaaaaaaaaaaaaaaaaaaa=[bdddddddddd]}
         */
    }
}
