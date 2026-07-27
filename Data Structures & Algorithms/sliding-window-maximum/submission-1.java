class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //sliding window maximum
        Deque<Integer> q = new ArrayDeque<>();
        int indx = 0;
        int ans[] = new int[nums.length-k+1];
        //peekFirst() and peekLast()
        //minimum element will be at starting

        for (int i = 0; i < nums.length; i++){
            while (!q.isEmpty() && q.peekFirst() <= i-k){
                q.removeFirst();
            }

            while (!q.isEmpty() && nums[i] >= nums[q.peekLast()]){
                q.removeLast();
            }
            q.addLast(i);

            if (i >= k-1)
                ans[indx++] = nums[q.peekFirst()];
        }
        return ans;
    }
}
