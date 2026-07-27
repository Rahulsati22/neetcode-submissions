class Solution {
    public int countChars(HashMap<Character, Integer> hm){
        int max = 0, sum = 0;
        for (int i : hm.values()){
            sum += i;
            max = Math.max(max, i);
        }

        return sum - max;
    }
    public int characterReplacement(String s, int k) {
        //store out answer in a answer variable
        //we can make another function that will run in O(26)
        //and it will calculate the extra elements
        HashMap<Character,Integer> hm = new HashMap<>();
        int left = 0, ans = 0;
        for (int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
            while (countChars(hm) > k){
                char helper = s.charAt(left);
                hm.put(helper, hm.get(helper)-1);
                if (hm.get(helper) == 0)
                    hm.remove(helper);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
