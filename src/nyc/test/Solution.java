package nyc.test;

public class Solution {
    public boolean match(char[] str, char[] pattern) {
		if (str == null || pattern == null) {
			return false;
		}
		int strIndex = 0;
		int patternIndex = 0;
		return matchCore(str, strIndex, pattern, patternIndex);
	}
  
	public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
		//��Ч�Լ��飺str��β��pattern��β��ƥ��ɹ�
		if (strIndex == str.length && patternIndex == pattern.length) {
			return true;
		}
		//pattern�ȵ�β��ƥ��ʧ��
		if (strIndex != str.length && patternIndex == pattern.length) {
			return false;
		}
		//ģʽ��2����*�����ַ�����1����ģʽ��1��ƥ��,��3��ƥ��ģʽ���粻ƥ�䣬ģʽ����2λ
		if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
			if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
				return matchCore(str, strIndex, pattern, patternIndex + 2)//ģʽ����2����Ϊx*ƥ��0���ַ�
						|| matchCore(str, strIndex + 1, pattern, patternIndex + 2)//��Ϊģʽƥ��1���ַ�
						|| matchCore(str, strIndex + 1, pattern, patternIndex);//*ƥ��1������ƥ��str�е���һ��
			} else {
				return matchCore(str, strIndex, pattern, patternIndex + 2);
			}
		}
		//ģʽ��2������*�����ַ�����1����ģʽ��1��ƥ�䣬�򶼺���1λ������ֱ�ӷ���false
		if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
			return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
		}
		return false;
	}

	public static void main(String[] artgs){
		Solution sol = new Solution();
		String char1 = "aaffbc";
		String char2 = "d*a*a*.*b*c*bc";
		System.out.println(sol.match(char1.toCharArray(), char2.toCharArray()));
	}
}