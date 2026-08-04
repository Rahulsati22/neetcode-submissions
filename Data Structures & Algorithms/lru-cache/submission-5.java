class Node{
    int key;
    int value;
    Node next;
    Node prev;
    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    int capacity;
    HashMap<Integer,Node> hm = new HashMap<>();
    Node tail = null;
    Node head = null;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!hm.containsKey(key))
            return -1;
        
        int ans = hm.get(key).value;
        Node node = hm.get(key);
        if (node == head && node == tail){
            head = null;
            tail = null;
        }else if (node == head){
            head.next.prev = null;
            head = head.next;
        }else if (node == tail){
            tail.prev.next = null;
            tail = tail.prev;
        }else{
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
        }

        hm.remove(node.key);
        if (head == null || tail == null){
            head = new Node(node.key, node.value);
            tail = head;
        }else{
            tail.next = new Node(node.key, node.value);
            tail.next.prev = tail;
            tail = tail.next;
        }

        hm.put(tail.key, tail);
        return ans;
    }
    
    public void put(int key, int value) {
        if (hm.size() == capacity && !hm.containsKey(key)){
            hm.remove(head.key);
            if (head.next != null)
                head.next.prev = null;
            head = head.next;
        }

        if (hm.containsKey(key)){
            Node node = hm.get(key);
            if (node == head && node == tail){
                head = null;
                tail = null;
            }else if (node == head){
                head.next.prev = null;
                head = head.next;
            }else if (node == tail){
                tail.prev.next = null;
                tail = tail.prev;
            }else{
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.next = null;
                node.prev = null;
            }
            hm.remove(node.key);
        }

        if (head == null || tail == null){
            head = new Node(key, value);
            tail = head;
        }else{
            tail.next = new Node(key, value);
            tail.next.prev = tail;
            tail = tail.next;
        }

        hm.put(key, tail);
    }
}
