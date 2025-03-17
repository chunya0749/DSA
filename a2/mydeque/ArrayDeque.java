package mydeque;

public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int front;
    private int back;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        front = 0;
        back = 0;

    }
    public ArrayDeque(ArrayDeque<T> other) {
        items = (T[]) new Object[other.items.length];
        size = other.size;
        front = other.front;
        back = other.back;
        //copyarray
        for (int i = 0; i < other.size; i++) {
            items[i] = other.get(i);
        }
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            grow();
        }
        front = (front - 1+ items.length) % items.length;
        items[front] = item;
        size++;
    }

    public void addLast(T item) {
        if (size == items.length) {
            grow();

        }
        items[back] = item;
        back = (back + 1) % items.length;
        size++;

    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T item = items[front];
        items[front] = null;
        front = (front + 1) % items.length; // move to the real first item
        size--;
        return item;
    }

    public T removeLast() {
        if(isEmpty()){
            return null;
        }
        back = (back - 1 + items.length) % items.length;
        T item = items[back];
        items[back] = null;
        size--;
        return item;
    }

    public T get(int index) {
        if(index<0 || index >= size){
            return null;
        }
        int realIndex = (front + index) % items.length;
        return items[realIndex];

        }


    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = get(i);
        }
        items = newArray;
        front = 0;
        back = size;
    }

    public void grow(){
        resize(items.length*2);
    }

    public void printDeque() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(get(i));
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();  // Create a new ArrayDeque object
        deque.addFirst(1);  // Add 1 to the front
        deque.addFirst(2);  // Add 2 to the front
        deque.addFirst(3);  // Add 3 to the front
        deque.addLast(4);   // Add 4 to the back
        deque.addLast(5);   // Add 5 to the back
        System.out.println(deque.size());
        System.out.println(deque.isEmpty());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
        deque.printDeque();
    }
}

