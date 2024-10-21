package b_00_hexinkuangjia.b_003_huadongchuangkou;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: Solution004lLengthOfLongestSubstring
 * @author: Docer
 * @date: 2024/10/21 23:35
 * @Version: 1.0
 * @description: 3. 无重复字符的最长子串
 */
public class Solution004lLengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            right++;
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            while (window.get(ch) > 1) {
                char del = s.charAt(left);
                left++;
                window.put(del, window.get(del) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
