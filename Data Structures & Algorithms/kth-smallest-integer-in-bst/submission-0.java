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
    //we will make a global counter and a global answer
    int ans = -1, counter = 0;

    public void inorderTraversal(TreeNode root){
        if (root == null){
            return;
        }

        inorderTraversal(root.left);
        counter--;
        if (counter == 0){
            ans = root.val;
        }
        inorderTraversal(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        counter = k;
        //we can just do inorder traversal and return the kth elements
        inorderTraversal(root);
        return ans;
    }
}
