package nyc.thinkinjava;

import java.io.*;

/**
 * 网易云音乐缓存文件解码
 */
public class Change {
	public static void main(String[] args) {
		DataInputStream dis = null;
		DataOutputStream dos = null;
		try {
			File inFile = new File("1.uc");
			File outFile = new File("1.mp3");
 
			dis = new DataInputStream(new FileInputStream(inFile));
			dos = new DataOutputStream(new FileOutputStream(outFile));
			byte[] b = new byte[1024];
			int len;
			while ((len = dis.read(b)) != -1) {
				for (int i = 0; i < len; i++) {
					b[i] ^= 0xa3;
				}
				dos.write(b, 0, len);
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (dis != null) {
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}