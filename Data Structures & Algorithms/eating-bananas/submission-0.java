class Solution {
    public boolean isPossible(int piles[], int hour, int banana){
        int cnt = 0;

        for (int i = 0; i < piles.length; i++){
            int currHour = (int)Math.abs((double)piles[i]/(banana*1.0));
            if (piles[i] % banana != 0) currHour += 1;
            cnt += currHour;
        }

        System.out.println(banana + " " + cnt);
        return cnt <= hour;
    }
    public int minEatingSpeed(int[] piles, int h) {
        //koko eating bananas 
        //we have to find the minimum number of bananas koko eat
         
        int start = 1;
        int end = -1;
        int ans = -1;
        for (int i : piles)end = Math.max(end, i);

        while (end >= start){
            int mid = start + (end-start)/2;
            if (isPossible(piles, h, mid)){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
}
