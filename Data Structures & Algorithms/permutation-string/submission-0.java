class Solution {
    public boolean isEqual(String s1, String s2){
        int arr[] = new int[26];
        for (char i : s1.toCharArray())
            arr[i-'a']++;
        
        for (char i : s2.toCharArray())
            arr[i-'a']--;
        
        for (int i : arr)
            if (i != 0)
                return false;
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        //isko hum 

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i <= s2.length()-s1.length(); i++){
            String s = s2.substring(i, i + s1.length());
            list.add(s);
        }

        for (int i = 0; i < list.size(); i++){
            String s = list.get(i);
            if (isEqual(s, s1))
                return true;
        }
        return false;
    }
}
