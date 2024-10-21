package b_00_hexinkuangjia.b_002_shuangzhizhen_shuzu;

/**
 * @className: Solution005TwoSum
 * @author: Docer
 * @date: 2024/10/22 0:14
 * @Version: 1.0
 * @description: 167. 两数之和 II - 输入有序数组
 * 只要数组有序，就应该想到双指针技巧。
 */
public class Solution005TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
