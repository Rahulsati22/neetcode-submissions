class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int i : nums)hm.put(i, hm.getOrDefault(i,0)+1);

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++)list.add(new ArrayList<>());

        for (int i : hm.keySet()){
            list.get(hm.get(i)).add(i);
        }

        int ans[] = new int[k];
        int indx = 0;
        for (int i = list.size()-1; i >= 0 && indx < k; i--){
            List<Integer> helper = list.get(i);
            if (helper.size() != 0){
                for (int j = 0; j < helper.size(); j++)
                    ans[indx++] = helper.get(j);
            }
        }

        return ans;
         
    }
}
