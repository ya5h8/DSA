import java.util.HashMap;

class LRUCache {

    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int c;
    HashMap<Integer, Node> map;
    Node head, tail;

    public LRUCache(int capacity) {
        this.c = capacity;

        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    private void add(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // Move to front = Most Recently Used
        remove(node);
        add(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {

            Node node = map.get(key);

            remove(node);

            node.value = value;

            add(node);

            return;
        }

        Node node = new Node(key, value);

        map.put(key, node);

        add(node);

        if (map.size() > c) {

            Node lru = tail.prev;

            remove(lru);

            map.remove(lru.key);
        }
    }
}