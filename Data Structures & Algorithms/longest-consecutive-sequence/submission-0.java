class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> helper = new HashSet<>();
        int cnt = 0, ans = 0;

        for (int i : nums){
            set.add(i);
        }

        for (int i : nums){
            if (!set.contains(i-1))
                helper.add(i);
        }


        for (int i : helper){
            int num = i;
            while (set.contains(num)){
                cnt++;
                num++;
            }

            ans = Math.max(ans, cnt);
            cnt = 0;
        }

        return ans;
    }
}