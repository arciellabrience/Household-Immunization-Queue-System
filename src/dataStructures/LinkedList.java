package dataStructures;

public class LinkedList extends Node implements QueueInterface {
    private Node head;
    private int capacity;
    private final int max;

    public LinkedList(int size) {
        this.head = null;
        capacity = 0;
        max = size;
    }

    @Override
    public void push(Object item) throws QueueFullException {
        Node tail = new Node();
        Node temp;
        tail.reference = null;
        tail.data = item;
        if (head == null) head = tail;
        else {
            temp = head;
            while (temp.reference != null) temp = temp.reference;
            temp.reference = tail;
        }
        capacity++;
    }

    @Override
    public Object pop() throws QueueEmptyException {
        if (!empty()) {
            Node temp = head;
            head = head.reference;
            capacity--;
            return temp.data;
        }
        else return null;
    }

    @Override
    public Object front() {
        return head.data;
    }

    @Override
    public Object back() {
        Node temp;
        temp = head;
        while (temp.reference != null) {
            temp = temp.reference;
        }
        return temp.data;
    }

    @Override
    public int size() {
        return capacity;
    }

    @Override
    public boolean empty() {
        return (capacity == 0);
    }
}
