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
    public List<Integer> arr;
    void postorder(TreeNode root){
        if(root==null) return;
        postorder(root.left);
        postorder(root.right);
        arr.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        arr = new ArrayList<>();
        postorder(root);
        return arr;
    }
}