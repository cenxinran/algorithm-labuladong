package b_00_hexinkuangjia.b_003_huadongchuangkou;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: Solution001MinWindow
 * @author: Docer
 * @date: 2024/10/21 10:48
 * @Version: 1.0
 * @description: 76. 最小覆盖子串
 */
public class Solution001MinWindow {
    public String minWindow(String s, String t) {
        // 1. 创建 window 哈希表，所需字符出现次数哈希表并初始化
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        // 2. 窗口左右索引初始化，判断有效元素个数容器的初始化
        int left = 0, right = 0;
        int valid = 0;
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        // 3. 右指针往右滑动
        while (right < s.length()) {
            char ch = s.charAt(right);
            right++;
            // 4. 窗口内数据更新
            // 4.1 如果包含 ch ，那就需要将其 put 到 window 里面，并更新 valid
            if (need.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (window.get(ch).equals(need.get(ch))) {
                    valid++;
                }
            }
            // 4.2 如果不包含 ch ，那就什么也不做
            // 5 .判断是否需要收缩窗口
            // 5.1 收缩窗口
            while (valid == need.size()) {
                if (right - left < minLength) {
                    start = left;
                    minLength = right - left;
                }
                char del = s.charAt(left);
                left++;
                // 5.2 窗口内数据更新
                if (need.containsKey(del)) {
                    if (window.get(del).equals(need.get(del))) {
                        valid--;
                    }
                    window.put(del, window.getOrDefault(del, 0) - 1);
                }
            }

        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
