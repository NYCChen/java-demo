package leetcode.a01_a10;

/*
3. 无重复字符的最长子串

给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class A03NoEqualSubString {
    public static void main(String[] args) {
        A03NoEqualSubString a03 = new A03NoEqualSubString();
        System.out.println("长度："+a03.lengthOfLongestSubstring("abbabb"));
    }
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap();
        int max = 0;
        int tmp = 0;
        int startIndex = 0;
        for (int i = 0; i < s.length(); i++){
            if (!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
                tmp = i - startIndex + 1;
                max = Math.max(max, tmp);
            } else {
                startIndex = Math.max(map.get(s.charAt(i)) + 1, startIndex);
                tmp = i - startIndex+1;
                map.remove(s.charAt(i));
                map.put(s.charAt(i), i);
                max = Math.max(max, tmp);
            }
        }
        return max;
    }

    // 滑动窗口 abcbabb
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    // HashMap 优化滑动窗口 abcbabb
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    /*
    Java（假设字符集为 ASCII 128）
    以前的我们都没有对字符串 s 所使用的字符集进行假设。
    当我们知道该字符集比较小的时侯，我们可以用一个整数数组作为直接访问表来替换 Map。
    常用的表如下所示：
    int [26] 用于字母 ‘a’ - ‘z’ 或 ‘A’ - ‘Z’
    int [128] 用于ASCII码
    int [256] 用于扩展ASCII码
     */
    // 同样的滑动窗口优化  abcbabb
    public int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }


}
