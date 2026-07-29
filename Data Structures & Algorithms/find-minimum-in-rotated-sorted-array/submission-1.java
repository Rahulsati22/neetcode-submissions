class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        //find minimum in rotated sorted array

        //we can see that we have two sorted arrays in an single array
        if (nums[0] < nums[nums.length-1]){
            return nums[0];
        }
        if (nums[nums.length-1] < nums[nums.length-2]){
            return nums[nums.length-1];
        }

        int start = 0, end = nums.length-1;
        while (end >= start){
            int mid = start + (end-start)/2;
            if (mid > 0 && mid < nums.length-1 && nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1]){
                return nums[mid];
            }else if (nums[mid] > nums[end]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
}
