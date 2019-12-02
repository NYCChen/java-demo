package leetcode.a01_a10;

/*
6. Z 字形变换
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
请你实现这个将字符串进行指定行数变换的函数：
string convert(string s, int numRows);
示例 1:
输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
示例 2:
输入: s = "LEETCODEISHIRING", numRows = 4
输出: "
LDREOEIIECIHNTSG"
LDREOEIIECIHNTSG
解释:
L     D     R
E   O E   I I
E C   I H   N
T     S     G
 */
public class A06Convert {
    public static void main(String[] args) {
        A06Convert a06Convert = new A06Convert();
        String convert = a06Convert.convert("LEETCODEISHIRING", 3);
        String convert1 = a06Convert.convert("LEETCODEISHIRING", 4);
        String convert2 = a06Convert.convert("PAYPALISHIRING", 4);
        System.out.println(convert);
        System.out.println(convert1);
        System.out.println(convert2);
    }
    public String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        StringBuilder str = new StringBuilder();
        int cycleLen = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++){
            for (int j = 0; j + i < n; j += cycleLen) {
                str.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
               //if (i!=0 && i != numRows-1 && i+j+(numRows-i)*2 < n)
                    str.append(s.charAt(j + cycleLen - i));
            }
        }
        for (int i = 0; i < numRows; i++){
            for (int j = 0; j+i<n; j += cycleLen){
                str.append(s.charAt(i+j));

            }
        }
        return String.valueOf(str);

        /*
        char[] res = new char[n];
        res[0] = chars[0];
        int j = 0;// res的下标
        for (int i = 1; i <= numRows; i++){//Z的行号

            int t = i-1;


            if (i == 1 || i == numRows){
                res[j] = chars[i-1];
                j++;
                while(t+(numRows-1)*2 < n){
                    t = t+(numRows-1)*2;
                    res[j] = chars[t];
                    j++;
                }
            } else {
                res[j] = chars[i-1];
                j++;
                while(t+(numRows-i)*2 < n){
                    t = t+(numRows-i)*2;
                    res[j] = chars[t];
                    j++;
                    if (t + (i-1)*2 < n){
                        t = t + (i-1)*2;
                        res[j] = chars[t];
                        j++;
                    }
                }
            }
        }

        return String.valueOf(res);
        */
    }
}

//res[j] = chars[i-1];