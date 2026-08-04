class LRUCache {
    int capacity;

    //firstnode will contains the keys in order they were used
    ArrayList<Integer> list = new ArrayList<>();

    //map will help us to store key value pairs
    HashMap<Integer,Integer> hm = new HashMap<>();

    //help us to initialize the capacity variable
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    //this key was recently used 
    public int get(int key) {
        int val = hm.getOrDefault(key, -1);
        if (val == -1)return -1;
        for (int i = 0; i < list.size(); i++){
            if (list.get(i) == key){
                for (int j = i; j < list.size()-1; j++){
                    list.set(j, list.get(j+1));
                }
                break;
            }
        }

        if (list.size() > 0)
            list.remove(list.size()-1);
        list.add(key);
        return val;
    }
    
    public void put(int key, int value) {
        if (hm.size() == capacity && !hm.containsKey(key)){
            if (list.size() > 0)
                hm.remove(list.get(0));
            //remove the least recently used
            for (int j = 0; j < list.size()-1; j++){
                list.set(j, list.get(j+1));
            }

            
            if (list.size() > 0){
                list.remove(list.size()-1);
            }
        }

        boolean val = false;
        for (int i = 0; i < list.size(); i++){
            if (list.get(i) == key){
                for (int j = i; j < list.size()-1; j++){
                    list.set(j, list.get(j+1));
                }
                val = true;
                break;
            }
        }

        if (val && list.size() > 0)
            list.remove(list.size()-1);
        list.add(key);

        hm.put(key, value);
    }
}
