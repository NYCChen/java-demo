package nyc.forstack;

import java.util.Stack;

/*
将句子中的单词反转，标点符号不动。
如：Test public, a void?
返回: tseT cilbup, a diov?
 */
public class WordReverse {
    public static void main(String[] args) {
        WordReverse wordReverse = new WordReverse();
        char[] char1 = "Test public, a void?".toCharArray();
        char[] chars = wordReverse.reversea(char1);
        String str = String.valueOf(chars);
        System.out.println("main输出："+str);

        // char转string实验
        char[] char2 = {'a','v','s'};
        System.out.println(char2); // 输出 avs
        System.out.println(char2.toString()); // 输出的是[C@14ae5a5
        System.out.println(String.valueOf(char2)); // 输出 avs

    }

    public char[] reversea(char[] ch) {
        Stack<Character> characterStack = new Stack<>();
        int n = ch.length;
        int i = 0;
        int j = 0;
        while (i < n) {
            if ((ch[i] >= 'a' && ch[i] <= 'z') || (ch[i] >= 'A' && ch[i] <= 'Z')) {
                characterStack.push(ch[i]);
            }
            else {
                while (!characterStack.empty()){
                    ch[j] = characterStack.pop();
                    j++;
                }
                j++;
            }
            i++;
        }

        return ch;
    }

}
