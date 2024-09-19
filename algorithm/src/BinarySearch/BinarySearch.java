package BinarySearch;

/**
 * 二分查找
 * <p>
 * 基于分治策略的的高效搜索方法。
 * <p>
 * 每轮都缩小一般的搜索范围，直到搜索到结果或者区间的结果为空的时候停止。
 */
public class BinarySearch {

    // 只能用于有序的数组的排序
    public static void main(String[] args) {
        int[] nums   = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int   target = 11;
        System.out.println(binarySearch(nums, target));
    }

    /**
     * nums
     */
    public static int binarySearch(int[] nums, int target) {
        // 第一位的索引值
        var i = 0;
        // 最后一位的索引值
        var j = nums.length - 1;
        while (i <= j) {
            // 先拿一个中间点，并且需要取整，因为有时候可能回出现小数点
            int m = i + (j - i) / 2;
            // 如果中间值的小于目标值，则往中间值的左边靠
            if (nums[m] < target) {
                i = m + 1;
            } else if (nums[m] > target) { // 如果中间值大于目标值，则往中间值的右边靠
                j = m - 1;
            } else {
                return m;
            }
        }
        // 如果找不到元素返回 -1
        return -1;
    }


}
