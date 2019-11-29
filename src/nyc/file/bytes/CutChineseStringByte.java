package nyc.file.bytes;

/**
 * 编写一个截取字符串的函数，输入为一个字符串和字节数,输出为按字节截取的字符
 * 串,但要保证汉字不被截取半个，如 “我 我 ABC ” ，4 ，应该截取 “我 我 AB ” ，输入 “ 我
 * ABC 汉 汉 DEF ” ，6 ，应该输出 “我 我 ABC ” ，而不是 “我 我 ABC+“
 */
public class CutChineseStringByte {
    public static void main(String[] args) throws Exception{
        //String str = "我爱中华 abc 我爱中国 def';
        String str = "我 ABC 汉";
        int num = trimGBK(str.getBytes("GBK"),5);//汉字的字节数 : 2;编码：GBK
        System.out.println(str.substring(0,num) );
    }
    public static int trimGBK(byte[] buf,int n){
        int num = 0;
        boolean bChineseFirstHalf = false;
        for(int i=0;i<n;i++){
            if(buf[i]<0 && !bChineseFirstHalf){
                bChineseFirstHalf = true;
            }else{
                num++;
                bChineseFirstHalf = false;
            }
        }
        return num;
    }
}
/*
字节数 : 2;编码：GB2312

字节数 : 2;编码：GBK

字节数 : 2;编码：GB18030

字节数 : 1;编码：ISO-8859-1

字节数 : 3;编码：UTF-8

字节数 : 4;编码：UTF-16

字节数 : 2;编码：UTF-16BE

字节数 : 2;编码：UTF-16LE
 */
