class LFUCache {
    class Node {
        int key, value, freq;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    private int capacity;
    private int minFreq;
    private Map<Integer, Node> keyMap;
    private Map<Integer, LinkedHashSet<Node>> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    private void updateFreq(Node node) {
        int freq = node.freq;
        freqMap.get(freq).remove(node);
        if (freqMap.get(freq).isEmpty()) {
            freqMap.remove(freq);
            if (minFreq == freq) minFreq++;
        }
        node.freq++;
        freqMap.computeIfAbsent(node.freq, k -> new LinkedHashSet<>()).add(node);
    }

    public int get(int key) {
        if (!keyMap.containsKey(key)) return -1;
        Node node = keyMap.get(key);
        updateFreq(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;

        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.value = value;
            updateFreq(node);
            return;
        }

        if (keyMap.size() >= capacity) {
            Node evict = freqMap.get(minFreq).iterator().next();
            freqMap.get(minFreq).remove(evict);
            if (freqMap.get(minFreq).isEmpty()) freqMap.remove(minFreq);
            keyMap.remove(evict.key);
        }

        Node node = new Node(key, value);
        keyMap.put(key, node);
        freqMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(node);
        minFreq = 1;
    }
}
/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */