package nyc.regular;// Java默认模板

import java.util.Scanner;
import java.util.Collections;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;

/*
判断一个数字串是否匹配一个表达式，具体如下：
1）表达式m：一定不为空，只能由数字和“*”构成，其中的“*”表示
匹配一个或多个“它前面所有非”*“的数字的和值除以10的余数”；
“*”如果在最前面或其前面都是“*”，则只可以是任意一个数字。
2）数字串s：可能为空，只能由数字构成，不能包含其它字符。
3）是否匹配：匹配要求覆盖整个数字串s，而不是某一部分匹配。

解题要求：不能将m转写成标准正则表达式来解题，需要自己编程实现匹配算法
输入
3
1*
11111
**1
121
**1
1221
0
输出
复制
YES
YES
NO
 */
public class Main {
    public static void main(String[] args) {
        // System.arraycopy(original, 0, destination, length);
        // Arrays.copyOf(original, newLength);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Main main = new Main();
        while (n-- > 0) {
            System.out.println(n);
            String pattern = in.nextLine();
            String str = in.nextLine();
            if (main.match(str.toCharArray(), pattern.toCharArray())){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
        /*while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }*/
    }

    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }

    public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        //pattern先到尾，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex])
                    || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return matchCore(str, strIndex, pattern, patternIndex + 2)//模式后移2，视为x*匹配0个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)//视为模式匹配1个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex);//*匹配1个，再匹配str中的下一个
            } else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex])
                || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        //str先到尾，匹配失败
        return false;
    }


}