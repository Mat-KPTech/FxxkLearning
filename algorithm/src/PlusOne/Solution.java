package PlusOne;

import java.util.Arrays;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 * <p>
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 * <p>
 * 输入：digits = [0]
 * 输出：[1]
 */
public class Solution {

    public static void main(String[] args) {
        int[]    nums     = new int[]{1, 2, 3};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.plusOne(nums)));
    }

    public int[] plusOne(int[] digits) {
        int last = digits[digits.length - 1];
        System.out.println(last + 1);
        digits[digits.length - 1] = last;
        return digits;
    }
}
