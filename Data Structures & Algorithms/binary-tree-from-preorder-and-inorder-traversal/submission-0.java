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
    int indx = -1;
    public TreeNode buildTree(int[] preorder, int[] inorder, int start, int end){
        if (start > end){
            return null;
        }

        TreeNode root = new TreeNode(preorder[indx]);
        int indx2 = -1;
        for (int i = start; i < inorder.length; i++){
            if (inorder[i] == preorder[indx]){
                indx2 = i;
                break;
            }
        }
        indx++;

        root.left = buildTree(preorder, inorder, start, indx2 - 1);
        root.right = buildTree(preorder, inorder, indx2 + 1, end);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //create a binary tree from preorder and inorder traversal
        //like when we get a node
        indx = 0;
        return buildTree(preorder, inorder, 0, preorder.length-1);
    }
}
