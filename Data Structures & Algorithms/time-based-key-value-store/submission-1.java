class Pair{
    String value;
    int timestamp;
    Pair (String value, int timestamp){
        this.value = value;
        this.timestamp = timestamp;
    }
}
class TimeMap {
    HashMap<String, ArrayList<Pair>> hm = new HashMap<>();
    public TimeMap() {
    }
    public void set(String key, String value, int timestamp) {
        if (!hm.containsKey(key)){
            hm.put(key, new ArrayList<>());
        }
        hm.get(key).add(new Pair(value, timestamp));
    }
    public String get(String key, int timestamp) {
        if (!hm.containsKey(key)){
            return "";
        }
        String ans = "";
        ArrayList<Pair> list = hm.get(key);
        int start = 0, end = list.size()-1;
        while (end >= start){
            int middle = start + (end-start)/2;
            if (list.get(middle).timestamp <= timestamp){
                ans = list.get(middle).value;
                start = middle + 1;
            }else{
                end = middle - 1;
            }
        }
        return ans;
    }
}
