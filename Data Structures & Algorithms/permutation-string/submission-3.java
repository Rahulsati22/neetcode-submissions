class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];


        for (char i = 0; i < s1.length(); i++){
            s1Count[s1.charAt(i)-'a']++;
            s2Count[s2.charAt(i)-'a']++;
        }


        int matches = 0;
        for (int i = 0; i < 26; i++){
            if (s1Count[i] == 0 || s2Count[i] == 0)continue;
            if (s1Count[i] == s2Count[i]){
                matches+=s1Count[i];
            }
        }

        if (matches == s1.length())
            return true;
        

        int l = 0;
        matches = 0;
        for (int r = s1.length(); r < s2.length(); r++){
            s2Count[s2.charAt(r)-'a']++;
            s2Count[s2.charAt(l)-'a']--;
            l++;

        


            for (int i = 0; i < 26; i++){
            if (s1Count[i] == 0 || s2Count[i] == 0)continue;
            if (s1Count[i] == s2Count[i]){
               matches+=s1Count[i];
            }
        }

        if (matches == s1.length())
            return true;
        matches = 0;
        }
        return false;
    }
}
