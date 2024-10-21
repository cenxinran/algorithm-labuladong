package b_00_hexinkuangjia.b_003_huadongchuangkou;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @className: Soluution003FindAnagrams
 * @author: Docer
 * @date: 2024/10/21 23:20
 * @Version: 1.0
 * @description: 438. 找到字符串中所有字母异位词
 */
public class Solution003FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char ch : p.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        List<Integer> res = new ArrayList<>();

        while (right < s.length()) {
            char ch = s.charAt(right);
            right++;
            if (need.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (window.get(ch).intValue() == need.get(ch).intValue()) {
                    valid++;
                }
            }
            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    res.add(left);
                }
                char del = s.charAt(left);
                left++;
                if (need.containsKey(del)) {
                    if (window.get(del).intValue() == need.get(del).intValue()) {
                        valid--;
                    }
                    window.put(del, window.get(del) - 1);
                }
            }
        }
        return res;
    }
}
