class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;

        //we always want to perform binary search on smaller
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);
        
        //performing binary search on the smaller array
        int low = 0, high = n1;

        while (high >= low){
            int mid1 = low + (high-low)/2;
            int mid2 = (n1 + n2 + 1)/2 - mid1;

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if (mid1 > 0)
                l1 = nums1[mid1-1];
            if (mid1 < n1)
                r1 = nums1[mid1];
            if (mid2 < n2)
                r2 = nums2[mid2];
            if (mid2 > 0)
                l2 = nums2[mid2-1];
            
            if (l1 <= r2 && l2 <= r1)
                return n % 2 == 1 ? (double)Math.max(l1, l2): (double)(Math.max(l1, l2) + Math.min(r1, r2))/2.0;
            else if (l1 > r2)
                high = mid1 - 1;
            else
                low = mid1 + 1;
        }
        return 0.00;
    }
}
