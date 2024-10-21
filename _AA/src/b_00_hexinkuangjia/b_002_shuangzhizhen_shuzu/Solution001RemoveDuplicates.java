package b_00_hexinkuangjia.b_002_shuangzhizhen_shuzu;

/**
 * @className: Solution001RemoveDuplicates
 * @author: Docer
 * @date: 2024/10/18 12:18
 * @Version: 1.0
 * @description:26. 删除有序数组中的重复项
 */
public class Solution001RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
