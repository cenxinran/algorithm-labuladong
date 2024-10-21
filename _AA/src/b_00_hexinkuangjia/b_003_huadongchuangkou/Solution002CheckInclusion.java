package b_00_hexinkuangjia.b_003_huadongchuangkou;

import java.util.HashMap;

/**
 * @className: Solution002CheckInclusion
 * @author: Docer
 * @date: 2024/10/21 23:01
 * @Version: 1.0
 * @description: 567. 字符串的排列
 */
public class Solution002CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;

        while (right < s2.length()) {
            char ch = s2.charAt(right);
            right++;
            if (need.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (window.get(ch).intValue() == need.get(ch).intValue()) {
                    valid++;
                }
            }

            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char del = s2.charAt(left);
                left++;
                if (need.containsKey(del)) {
                    if (window.get(del).intValue() == need.get(del).intValue()) {
                        valid--;
                    }
                    window.put(del, window.get(del) - 1);
                }
            }
        }
        return false;
    }

}
