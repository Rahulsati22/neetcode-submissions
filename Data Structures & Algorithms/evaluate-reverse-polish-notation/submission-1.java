class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<String>();
        for (String s : tokens){
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int first = Integer.parseInt(st.pop());
                int second = Integer.parseInt(st.pop());
                
                if (s.equals("+"))
                    st.push(second + first + "");
                else if (s.equals("-"))
                    st.push(second - first + "");
                else if (s.equals("*"))
                    st.push(second * first + "");
                else
                    st.push(second/first + "");
            }else{
                st.push(s);
            }
        }
        return Integer.parseInt(st.peek());
    }
}