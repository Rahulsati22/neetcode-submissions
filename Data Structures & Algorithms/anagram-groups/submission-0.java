class Solution {
    //this is the first step
    class Pair{
        String original;
        String sorted;
        Pair(String original, String sorted){
            this.original = original;
            this.sorted = sorted;
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        //first step -> we will create a pair

        Pair[] arr = new Pair[strs.length];

        for (int i = 0; i < strs.length; i++){
            String s = strs[i];
            char c[] = s.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);
            arr[i] = new Pair(s, sorted);
        }


        //sort on the basis of sorted array
        Arrays.sort(arr, (a,b)->a.sorted.compareTo(b.sorted));

        List<List<String>> ans = new ArrayList<>();

        int i = 0, j = 0;
        while (i < arr.length){
            List<String> helper = new ArrayList<>();
            while (j < arr.length && arr[i].sorted.equals(arr[j].sorted)){
                helper.add(arr[j].original);
                j++;
            }
            ans.add(new ArrayList<>(helper));
            i = j;
        }
        return ans;
    }
}