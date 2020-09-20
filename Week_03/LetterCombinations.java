package leetcode;

import org.junit.Test;

import java.util.*;

public class LetterCombinations {

    /**
     * 电话号码的字母组合
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> resultList = new LinkedList<>();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        recursion(0, digits, "", map, resultList);
        return resultList;
    }

    private void recursion(int i, String digits, String s, Map<Character, String> map, List<String> resultList) {
        if (i == digits.length()) {
            resultList.add(s);
            return;
        }
        char c = digits.charAt(i);
        for (char letter : map.get(c).toCharArray()) {
            recursion(++i, digits, s + letter, map, resultList);
            //需要将i减一，恢复到每次调用递归之前的i值
            i--;
        }
    }

    @Test
    public void testLetter() {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

}
