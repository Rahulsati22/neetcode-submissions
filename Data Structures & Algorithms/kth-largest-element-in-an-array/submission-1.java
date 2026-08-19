class Solution {
    public int partition_algo(int[] nums, int left, int right){
        int pivot = nums[left];
        int pivot_indx = left;
        while (right >= left){
            if (nums[left] < pivot && nums[right] > pivot){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }else if (nums[left] >= pivot){
                left++;
            }else if (nums[right] <= pivot){
                right--;
            }
        }
        int temp = nums[pivot_indx];
        nums[pivot_indx] = nums[right];
        nums[right] = temp;
        return right;
    }
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 1)
            return nums[0];
        //kth largest element in an stream
        //sbse chota hoga vo hat jaega
        int pivot_indx = 0;
        int left = 0, right = nums.length-1;
        while (true){
            pivot_indx = partition_algo(nums, left, right);
            if (pivot_indx == k-1)
                break;
            else if (pivot_indx > k-1)
                right = pivot_indx-1;
            else
                left = pivot_indx+1;
        }
        return nums[pivot_indx];
    }
}
