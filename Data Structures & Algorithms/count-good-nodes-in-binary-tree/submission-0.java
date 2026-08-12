class Solution {
    public int findGoodNodes(TreeNode root, int max){
        if (root == null)
            return 0;
        
        int count = 0;
        if (root.val >= max)
            count += 1;
        
        int left = findGoodNodes(root.left, Math.max(max, root.val));
        int right = findGoodNodes(root.right, Math.max(max, root.val));

        return count + left + right;
    }
    public int goodNodes(TreeNode root) {
        return findGoodNodes(root, Integer.MIN_VALUE);
    }
}
