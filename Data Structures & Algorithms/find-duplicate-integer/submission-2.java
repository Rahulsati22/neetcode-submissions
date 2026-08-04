class Solution {
    public int findDuplicate(int[] nums) {
        //required sum
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums){
            if (set.contains(i))
                return i;
            set.add(i);
        }
        return -1;
    }
}
