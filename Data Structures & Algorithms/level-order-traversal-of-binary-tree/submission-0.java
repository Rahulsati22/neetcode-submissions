class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //in this question we have to do level order traversal
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
       
        if (root == null)return ans;
        q.add(root);

        while (!q.isEmpty()){
            int size = q.size();
            
            List<Integer> helper = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode node = q.remove();
                helper.add(node.val);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }

            ans.add(new ArrayList<>(helper));
        }

        return ans;
    }
}
