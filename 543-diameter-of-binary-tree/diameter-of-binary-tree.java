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
    int di = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);     // diameterOfBinaryTree ko helper bana diya
        return di;        // height nahi, diameter return karna hai
    }
    int height(TreeNode root) {
        if(root == null) return 0;
        int l = height(root.left);
        int r = height(root.right);
        di = Math.max(di, l + r);   // max -> Math.max
        return 1 + Math.max(l, r);  // max -> Math.max
    }
}