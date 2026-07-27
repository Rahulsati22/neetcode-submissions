class Solution {
    public int[] productExceptSelf(int[] nums) {
        //firstly we will calculate overall product
        //at any index i what will be the product
        //product/nums[i];


        //0 in the array overall product will be 0
        //all the other indexes will be 0
        //and the element at index where 0 exists 
        //will be product of array


        //if array has two zeroes the answer will be 0


        int cntZero = 0;
        int ans[] = new int[nums.length];


        for (int i : nums)
            if (i == 0)
                cntZero++;
        
        if (cntZero >= 2)
            return ans;
        
        else if (cntZero == 1){
            int product = 1;
            for (int i : nums)
                if (i != 0)
                    product *= i;
            

            for (int i = 0; i < nums.length; i++){
                if (nums[i] == 0)
                    ans[i] = product;
            }
        }else{
            int product = 1;
            for (int i : nums)
                if (i != 0)
                    product *= i;
            

            for (int i = 0; i < nums.length; i++){
                    ans[i] = product/nums[i];
            }
        }
        return ans;
    }
}  
