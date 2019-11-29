package nyc.file.bytes;

import java.io.UnsupportedEncodingException;

public class ByteTest{
    public static void main(String[] args) throws UnsupportedEncodingException {
        String a = new String("109zaAZ字符串");
        byte[] b = a.getBytes("GBK");
        for(int i = 0,m=b.length;i<m;i++){
            if(b[i] >= 0 && b[i] <=127){//10进制ascill表0到127
                System.out.println(b[i]+"：我是字母数字或者符号");
            }else{
                System.out.println(b[i]+"：我是中文日文或者韩文，反正键盘上不能直接看到我");
            }
        }
    }
}