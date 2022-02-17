package com.cornerboxx.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_1 {

    /**
     *
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     *
     * 你可以按任意顺序返回答案。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);

//            //加入这一段可以减少在leetcode执行时间...
//            if (map.containsKey(target - nums[nums.length - i -1])) {
//                return new int[]{nums.length - i -1, map.get(target - nums[nums.length - i -1])};
//            }
//            map.put(nums[nums.length - i -1], nums.length - i -1);
        }
        return null;
    }


}
