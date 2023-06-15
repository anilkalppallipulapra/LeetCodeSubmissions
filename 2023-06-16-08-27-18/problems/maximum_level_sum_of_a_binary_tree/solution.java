/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        int height = getHeight(root);
        int[] levelSums = new int[height];
        dfs(root, 0, levelSums);

        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 0;

        for (int i = 0; i < levelSums.length; i++) {
            if (levelSums[i] > maxSum) {
                maxSum = levelSums[i];
                maxLevel = i + 1;
            }
        }

        return maxLevel;
    } 
    private void dfs(TreeNode node, int level, int[] levelSums) {
        if (node == null) return;

        levelSums[level] += node.val;

        dfs(node.left, level + 1, levelSums);
        dfs(node.right, level + 1, levelSums);
    }

    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}