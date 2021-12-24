package dataStructures;

public interface QueueInterface<T> {
    public void push(T item) throws QueueFullException;

    public T pop() throws QueueEmptyException;

    public T front();

    public T back();

    public int size();

    public boolean empty();
}