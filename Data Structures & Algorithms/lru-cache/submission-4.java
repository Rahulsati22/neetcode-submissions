//creating our custom node class
class Node{
    int key;
    int value;
    //for operations like node.prev.next = null;
    Node prev;
    Node next;

    Node (int key, int value){
        this.key = key;
        this.value = value;
    }
}
//out custome node is ready


class LRUCache {
    HashMap<Integer,Node> hm;
    int capacity;
    Node tail = null;
    Node head = null;

    public LRUCache(int capacity) {
        hm = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!hm.containsKey(key))
            return -1;
        
        int ans = hm.get(key).value;
        
        //now we have the index of the node
        Node node = hm.get(key);
        if (node == head && node == tail){
            head = null;
            tail = null;
        }
        else if (node == head){
            if (head.next != null){
                head.next.prev = null;
            }
            head = head.next;
        }else if (node == tail){
            if (tail.prev != null)
                tail.prev.next = null;
            tail = tail.prev;
        }else{
            if (node.prev != null)
                node.prev.next = node.next;
            if (node.next != null)
                node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
        }

        if (tail == null){
            tail = new Node(key, ans);
            head = tail;
        }else{
            tail.next = new Node(key, ans);
            tail.next.prev = tail;
            tail = tail.next;
        }
        hm.remove(key);
        hm.put(key, tail);
        return ans;
    }
    
    public void put(int key, int value) {
        if (hm.size() == capacity && !hm.containsKey(key)){
            hm.remove(head.key);
            head = head.next;
        }
         
        if (hm.containsKey(key)){
            Node node = hm.get(key);
            if (node == head && node == tail){
                head = null;
                tail = null;
            }
            else if (node == head){
                if (head.next != null){
                    head.next.prev = null;
                }
                head = head.next;
            }else if (node == tail){
                if (tail.prev != null)
                    tail.prev.next = null;
                tail = tail.prev;
            }else{
                if (node.prev != null)
                    node.prev.next = node.next;
                if (node.next != null)
                    node.next.prev = node.prev;
                node.next = null;
                node.prev = null;
            }
            hm.remove(key);
        }
    
        if (head == null){
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
