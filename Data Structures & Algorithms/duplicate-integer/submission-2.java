class Solution {
    public boolean hasDuplicate(int[] nums) {
        //O(N) solution
        //O(N)
        // HashSet<Integer> set = new HashSet<>();
        // for (int i : nums){
        //     if (set.contains(i))
        //         return true;
        //     set.add(i);
        // }
        // return false;


        //so we have another solution
        //O(1)
        Arrays.sort(nums);
        for (int i = 0;  i < nums.length-1; i++)
            if (nums[i] == nums[i+1])
                return true;
        return false;
    }
}