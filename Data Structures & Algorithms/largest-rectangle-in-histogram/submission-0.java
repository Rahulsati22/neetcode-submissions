class Solution {
    public int[] prevSmaller(int[] heights){
        int prevSmaller[] = new int[heights.length];
        Arrays.fill(prevSmaller, -1);
        Stack<Integer> st = new Stack<>();
        for (int i = heights.length-1; i >= 0; i--){
            while (!st.isEmpty() && heights[i] < heights[st.peek()]){
                prevSmaller[st.pop()] = i;
            }
            st.push(i);
        }
        return prevSmaller;
    }

    public int[] nextSmaller(int[] heights){
        int nextSmaller[] = new int[heights.length];
        Arrays.fill(nextSmaller, heights.length);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < heights.length; i++){
            while (!st.isEmpty() && heights[i] < heights[st.peek()]){
                nextSmaller[st.pop()] = i;
            }
            st.push(i);
        }
        return nextSmaller;
    }
    public int largestRectangleArea(int[] heights) {
        int prevSmall[] = prevSmaller(heights);
        int nextSmall[] = nextSmaller(heights);

        int ans = 0;
        for (int i = 0; i < heights.length; i++){
            ans = Math.max(ans, heights[i] * (nextSmall[i] - prevSmall[i] - 1));
        }
        return ans;
    }
}
