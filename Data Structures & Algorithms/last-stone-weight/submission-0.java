class Solution {
    public int lastStoneWeight(int[] stones) {
        //you are given an array of integers
        //stones
        //where stones[i]
        //represents the weight of the ith stone
        //we want to run a simulation on the stones as follows
        //at each step we choose the two heaviest
        //stones, with weight x and y
        //and smash them together
        //if x == y, both stones are destroyed
        //if (x < y)

        //means b bada hai to swap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for (int i : stones)
            pq.add(i);
        
        while (!pq.isEmpty()){
            int first = pq.remove();
            int second = -1;
            if (!pq.isEmpty())
                second = pq.remove();
            else
                return first;
            
            if (first != second)
                pq.add(Math.abs(first - second));
        }
        return 0;
    }
}
