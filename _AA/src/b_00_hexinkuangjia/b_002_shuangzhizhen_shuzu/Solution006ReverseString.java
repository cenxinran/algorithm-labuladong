package b_00_hexinkuangjia.b_002_shuangzhizhen_shuzu;

/**
 * @className: Solution006ReverseString
 * @author: Docer
 * @date: 2024/10/22 0:22
 * @Version: 1.0
 * @description: 344. 反转字符串
 */
public class Solution006ReverseString {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
