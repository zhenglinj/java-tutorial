package com.algorithm.leetcode;

public class LongestValidParentheses {
    public static void main(String[] args) {
        LongestValidParentheses solution = new LongestValidParentheses();
        System.out.println(solution.longestValidParentheses(")()())()()("));
    }

    /*
    (()(((()
    01234567890
     */
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, max = 0;
        // 从左到右
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, 2 * right);
            } else if(right > left){
                left = right = 0;
            }
        }
        left = right = 0;
        // 从右到左
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return max;
    }
}
