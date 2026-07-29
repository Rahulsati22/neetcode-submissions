class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix[0].length;
        int n = matrix.length * matrix[0].length;

        int start = 0, end = n-1;

        //[n/5][n%5]

        while (end >= start){
            int mid = start + (end-start)/2;
            if (matrix[mid/m][mid%m] == target)
                return true;
            else if (matrix[mid/m][mid%m] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return false;
    }
}
