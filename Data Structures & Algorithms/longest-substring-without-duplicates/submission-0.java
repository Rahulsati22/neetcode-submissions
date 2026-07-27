class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, ans = 0;
        //pwwkew
        for (int right = 0; right < s.length(); right++){
            //pw
            char ch = s.charAt(right);
            while (set.contains(ch)){
                char helper = s.charAt(left);
                set.remove(helper);
                left++;
            }

            ans = Math.max(right-left+1, ans); //ans = 2
            set.add(ch);
        }

        return ans;
    }
}
