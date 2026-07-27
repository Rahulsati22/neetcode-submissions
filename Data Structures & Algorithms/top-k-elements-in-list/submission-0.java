class Solution {
    class Pair{
        int num;
        int freq;
        Pair (int num, int freq){
            this.num = num;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int i : nums)
            hm.put(i, hm.getOrDefault(i,0)+1);
        
        Pair[] arr = new Pair[hm.size()];
        int indx = 0;
        
        for (int i : hm.keySet())
            arr[indx++] = new Pair(i, hm.get(i));
        
        Arrays.sort(arr, (a,b)->b.freq-a.freq);
        int []ans = new int[k];
        for (int i = 0; i < k; i++)
            ans[i] = arr[i].num;
        
        return ans;
            
    }
}
