class MyCircularQueue {
    private int[] queue;
    private int head;
    private int count;
    private int capacity;

    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.capacity = k;
        this.head = 0;
        this.count = 0;
    }


    
    public boolean enQueue(int value) {
        if (this.isFull()) return false;
        int rear = (this.head + this.count) % this.capacity;
        this.queue[rear] = value;
        this.count++;
        return true;
        
    }
    
    public boolean deQueue() {
        if (this.isEmpty()) return false;
        this.head = (this.head + 1) % this.capacity;
        this.count--;
        return true;
    }
    
    public int Front() {
        if (this.isEmpty()) return -1;
        return this.queue[this.head];

    }
    
    public int Rear() {
        if (this.isEmpty()) return -1;
        int rear = (this.head + this.count - 1) % this.capacity;
        return this.queue[rear];

    }
    
    public boolean isEmpty() {
        return this.count == 0;
        
    }
    
    public boolean isFull() {
        return this.count == this.capacity;

        
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */