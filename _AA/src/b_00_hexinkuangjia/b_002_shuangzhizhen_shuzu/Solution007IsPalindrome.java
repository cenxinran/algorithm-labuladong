package b_00_hexinkuangjia.b_002_shuangzhizhen_shuzu;

/**
 * @className: Solution007IsPalindrome
 * @author: Docer
 * @date: 2024/10/22 0:27
 * @Version: 1.0
 * @description: 简单的判断是否是回文串
 */
public class Solution007IsPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
