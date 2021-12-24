package dataStructures;

public class Queue implements QueueInterface {
    private final int max;
    private int head;
    private int tail;
    private final Object[] queue;


    public Queue(int size) {
        this.queue = new Object[size];
        max = size+1;
        head = 0;
        tail = 0;
    }

    @Override
    public void push(Object item) {
        if (size() == max) throw new QueueFullException("Error: Queue is full");
        else {
            this.queue[tail] = item;
            tail = (tail + 1) % max;
        }
    }

    @Override
    public Object pop() {
        int prevHead;
        if (empty()) return null;

        prevHead = head;
        head = (head+1)%max;
        return this.queue[prevHead];
    }

    @Override
    public Object front() {
        if (empty()) return null;
        else return this.queue[head];
    }

    @Override
    public Object back() {
        if (empty()) return null;
        else return this.queue[(tail-1+max)%max];
    }

    @Override
    public int size() {
        return ((tail-head+max)%max);
    }

    @Override
    public boolean empty() {
        return (tail == head);
    }
}