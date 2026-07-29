class Solution {
    public int search(int[] nums, int target) {
        //we are given a sorted array
        //and a target
        //we will implement a function to search target within nums.
        //if it exists return the index, return -1


        int start = 0, end = nums.length-1;
        while (end >= start){
            int mid = start + (end-start)/2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1; 
        }
        return -1;
    }
}
