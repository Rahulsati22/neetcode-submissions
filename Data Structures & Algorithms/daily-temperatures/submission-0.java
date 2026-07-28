class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //j-i + monotonic stack

        Stack<Integer> st = new Stack<Integer>();
        int ans[] = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++){
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                ans[st.peek()] = i - st.peek();
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }
}