class Solution {
    public int findKthLargest(int[] nums, int k) {
        //kth largest element in an stream
        //sbse chota hoga vo hat jaega

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums){
            pq.add(i);
            if (pq.size() > k)
                pq.remove();
        }

        return pq.peek();
    }
}
