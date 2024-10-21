package b_00_hexinkuangjia.b_002_shuangzhizhen_shuzu;

/**
 * @className: Solution004MoveZeroes
 * @author: Docer
 * @date: 2024/10/18 14:22
 * @Version: 1.0
 * @description: 283. 移动零
 */
public class Solution004MoveZeroes {
    public void moveZeroes(int[] nums) {
        int len = removeElement(nums, 0);
        for (int i = len; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    private int removeElement(int[] nums, int val) {
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
