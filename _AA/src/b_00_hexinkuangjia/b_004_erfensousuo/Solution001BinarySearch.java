package b_00_hexinkuangjia.b_004_erfensousuo;

/**
 * @className: Solution0011BinarySearch
 * @author: Docer
 * @date: 2024/10/22 0:55
 * @Version: 1.0
 * @description: 704. 二分查找
 */
public class Solution001BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
