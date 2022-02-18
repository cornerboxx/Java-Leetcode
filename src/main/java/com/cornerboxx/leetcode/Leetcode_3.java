package com.cornerboxx.leetcode;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_3 {

    @Test
    public void main() {
        System.out.println(lengthOfLongestSubstring("ohomabcm"));
        System.out.println(lengthOfLongestSubstring("ohomm"));
        System.out.println(lengthOfLongestSubstring("abcb"));
        System.out.println(lengthOfLongestSubstring("abba"));
        System.out.println(lengthOfLongestSubstring("abbb"));
        System.out.println(lengthOfLongestSubstring("aaab"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("abcdefg"));
    }

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int idxL = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                idxL = Math.max(idxL, map.get(s.charAt(i)));
            }
            result = Math.max(result, i - idxL);
            map.put(s.charAt(i), i);
        }
        return result;
    }

    @Test
    public void main1() {
        System.out.println(lengthOfLongestSubstring1("ohomabcm"));
        System.out.println(lengthOfLongestSubstring1("ohomm"));
        System.out.println(lengthOfLongestSubstring1("abcb"));
        System.out.println(lengthOfLongestSubstring1("abba"));
        System.out.println(lengthOfLongestSubstring1("abbb"));
        System.out.println(lengthOfLongestSubstring1("aaab"));
        System.out.println(lengthOfLongestSubstring1("abcabcbb"));
        System.out.println(lengthOfLongestSubstring1("bbbbb"));
        System.out.println(lengthOfLongestSubstring1("pwwkew"));
        System.out.println(lengthOfLongestSubstring1("abcdefg"));
    }

    /**
     * 使用数组效率更高
     */
    public int lengthOfLongestSubstring1(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }

}

