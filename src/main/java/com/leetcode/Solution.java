package com.leetcode;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode t1 = new TreeNode(
                new TreeNode(null, null, 1),
                new TreeNode(null, null, 2),
                3
        );
        TreeNode t2 = new TreeNode(
                new TreeNode(null, null, 1),
                new TreeNode(null, null, 3), //null, //new TreeNode(null, null, 3),
                3
        );
        System.out.println(s.compareTree(t1, t2));
    }

    public static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int value;

        TreeNode(TreeNode l, TreeNode r, int v) {
            left = l;
            right = r;
            value = v;
        }
    }

    public boolean compareTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null && t2 != null) {
            return false;
        } else if (t1 != null && t2 == null) {
            return false;
        } else {
            if (t1.value != t2.value) {
                return false;
            } else {
                return compareTree(t1.left, t2.left) && compareTree(t1.right, t2.right);
            }
        }
    }

    public static class Point {
        public int x;
        public int y;
    }

    public static int getDistance(Point a, Point b) {
        return b.x + b.y - a.x - a.y;
    }

    public static class LinkNode {
        public int value;
        public LinkNode next;
    }

    public Point[] getKPoints(Point[] points, int k) {
        Point[] result = new Point[k];

        int c = 0;
        for (int idx = 0; idx < points.length - 1; idx++) {
            c += getDistance(points[idx], points[idx + 1]);
        }

        int len = c / k, leftedLen = 0;
        int tIdx = 0;
        for (int idx = 0; idx < points.length; idx++) {
            int nextIdx = idx == points.length - 1 ? 0 : idx + 1;
            int distance = getDistance(points[idx], points[nextIdx]);
            if (distance < leftedLen) {
                leftedLen = len - distance;
            } else {
                if (points[idx].x == points[nextIdx].x) {
                    result[tIdx].x = points[idx].x;
                    result[tIdx].y = points[idx].y + leftedLen;
                } else if (points[idx].y == points[nextIdx].y) {
                    result[tIdx].y = points[idx].y;
                    result[tIdx].x = points[idx].x + leftedLen;
                }
                tIdx++;
                leftedLen = 0;
            }
        }

        return result;
    }

    public LinkNode linkNodeNumberAdd(LinkNode a, LinkNode b) {
        LinkNode result = new LinkNode();
        int maxLen = 0;
        while (a.next != null || b.next != null) {
            maxLen++;
        }
        return result;
    }

    public boolean Find(int target, int[][] array) {
        int rl = 0, rr = 0;
        for (int rf = 0, re = array.length - 1; rf < re; ) {
            rl = (rf + re) / 2;
            if (rl == rf) {
                break;
            }
            if (array[rl][0] < target) {
                rf = rl;
            } else if (array[rl][0] > target) {
                re = rl;
            } else {
                break;
            }
        }

        if (array[rl][0] == target) {
            return true;
        }

        return false;
    }
}
