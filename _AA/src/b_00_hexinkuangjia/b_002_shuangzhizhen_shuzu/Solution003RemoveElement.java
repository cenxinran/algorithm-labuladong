package b_00_hexinkuangjia.b_002_shuangzhizhen_shuzu;

/**
 * @className: Solution003EemoveElement
 * @author: Docer
 * @date: 2024/10/18 14:13
 * @Version: 1.0
 * @description: 27. 移除元素
 */
public class Solution003RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
