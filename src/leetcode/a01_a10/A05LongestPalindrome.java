package leetcode.a01_a10;

/*
5. 最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：
输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：
输入: "cbbd"
输出: "bb"
 */
public class A05LongestPalindrome {
    public static void main(String[] args) {
        A05LongestPalindrome A05 = new A05LongestPalindrome();
        System.out.println(A05.longestPalindrome("ba"));
    }
    // 动态规划
    // time O(n^2) space O(n^2)
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        String res = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max= 0;
        // i 到 j 是否是回文串
        for (int j = 0; j< s.length(); j++){
            for (int i =0; i<= j; i++){
                  dp[i][j] = s.charAt(i) ==s.charAt(j) && ((j-i <=2 ) || dp[i+1][j-1]);//顺序不能变
//                dp[i][j] = s.charAt(i) ==s.charAt(j) && (dp[i+1][j-1]);//ArrayIndexOutOfBoundsException: -1
                // (j-i <=2 ) 不能省
                /*
                当s.charAt(i) ==s.charAt(j)为真时，若(j-i <=2 )则dp[i][j]一定为真。因为中间最多只有一个元素。
                但是dp[i+1][j-1]不一定有效，如dp[0][0]进行加减一的下标越界；
                此时可以用(j-i <=2 )可以避免 dp[0][0]进行加减一的下标越界。
                 */
                if (dp[i][j]) {
                    if (j - i + 1 > max) {
                        max = j -i +1;
                        res = s.substring(i, j+ 1);
                    }
                }
            }
        }
        return res;
    }

    // 中心扩散法
    // time O(n^2) space O(1)
    String res = "";
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) return s;
        for (int i = 0; i < s.length(); i++){
            helper(s, i, i);
            helper(s, i, i+1);
        }
        return res;
    }
    public void helper(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        String cur = s.substring(left+1, right);
        if (cur.length() > res.length())
            res = cur;
    }
}
