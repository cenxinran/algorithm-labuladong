package b_00_hexinkuangjia.b_002_shuangzhizhen_shuzu;

/**
 * @className: Solution005BinarySearch
 * @author: Docer
 * @date: 2024/10/22 0:09
 * @Version: 1.0
 * @description: 最简单的 binary search
 */
public class Solution005BinarySearch {
    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;

            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > mid) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
