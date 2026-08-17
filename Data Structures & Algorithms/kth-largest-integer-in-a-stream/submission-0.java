class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        //k se bada size nhi hone denge priority queue ka
        for (int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
            if (pq.size() > k)
                pq.remove();
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if (pq.size() > k)
            pq.remove();
        
        return pq.peek();
    }
}
