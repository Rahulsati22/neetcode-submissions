class Solution {
    public boolean checkConditions(char ch1, char ch2){
        return (ch1 == '(' && ch2 == ')') || (ch1 == '[' && ch2 == ']') || (ch1 == '{' && ch2 == '}'); 
    }
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();

        for (char i : s.toCharArray()){
            if (!st.isEmpty() && checkConditions(st.peek(), i)){
                st.pop();
            }else
                st.push(i);
        } 

        return st.isEmpty();
    }
}
