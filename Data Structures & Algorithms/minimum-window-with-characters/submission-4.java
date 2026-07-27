class Solution {

    //minor change here, in previous we had to find exact
    public boolean isEqual(int arrS[], int arrT[], int len){
        int cnt = 0;
        for (int i = 0; i < 300; i++){
            if (arrT[i] != 0 && arrS[i] < arrT[i])
                return false;
            else if (arrT[i] != 0)
                cnt += arrS[i];
        }
        return cnt >= len;
    }
    public String minWindow(String s, String t) {
       

        if (t.length() > s.length())
            return "";

        int arrS[] = new int[300];
        int arrT[] = new int[300];

        for (int i = 0; i < t.length(); i++){
            arrT[(int)t.charAt(i)]++;
        }

        int left = 0, len = Integer.MAX_VALUE;

        int ansLeft = 0, ansRight = 0;
        for (int r = 0; r < s.length(); r++){
            arrS[(int)s.charAt(r)]++;
            while (isEqual(arrS, arrT, t.length())){
                if (r - left + 1 < len){
                    ansLeft = left;
                    ansRight = r;
                    len = r - left + 1;
                }
                arrS[(int)s.charAt(left)]--;
                left++;
            }
        }

        if (len == Integer.MAX_VALUE)
            return "";
        return s.substring(ansLeft, ansRight+1);
    }
}
