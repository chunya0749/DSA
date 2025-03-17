package mydeque;

public class LinkedListDeque<T> {
    public class Node {
        T data;
        Node prev;
        Node next;

        public Node(T data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node sen;
    private int size;

    public LinkedListDeque() {
        sen = new Node(null, null, null);
        sen.next = sen;
        sen.prev = sen;
        size = 0;
    }

    public void addFirst(T data) {
        Node newNode = new Node(data, sen, sen.next);
        sen.next.prev = newNode;
        sen.next = newNode;

        size++;
    }

    public void addLast(T item) {
        Node newNode = new Node(item, sen.prev, sen);
        sen.prev.next = newNode;
        sen.prev = newNode;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public String printDeque() {
        String result = "[";
        Node current = sen.next;
        if(current == null){
            return null;
        }
        while (current != sen) {
            result += current.data;
            if (current.next != sen) {
                result += " ,";
            }
            current = current.next;
        }
        return result + "]";
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node current = sen.next;
        int count = 0;
        while (count != index) {
            current = current.next;
            count++;
        }
        return current.data;
    }
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node first = sen.next;
        sen.next = first.next;
        if(first.next != null){
            first.next.prev = first;
        }
        size--;
        return first.data;
    }
    public T removeLast() {
        if (size == 0) {
            return null;
        }

        Node current = sen.prev;
        current.prev.next = sen;
        sen.prev = current.prev;
        size--;
        return (T)current.data;
    }
    public LinkedListDeque(LinkedListDeque<T> other) {
        sen = new Node(null, null, null);
        sen.prev = sen;
        sen.next = sen;
        size = 0;

        for (int i = 0; i < other.size(); i++) {
            addLast(other.get(i));
        }
    }

    public static void main(String[] args) {
        LinkedListDeque L = new LinkedListDeque();
        L.addFirst(1);
        L.addFirst(2);
        L.addFirst(3);
        L.addLast(4);
        L.removeLast();
        L.removeFirst();
        System.out.println(L.size());
        System.out.println(L.printDeque());
        System.out.println(L.get(1));
        LinkedListDeque L2 = new LinkedListDeque();
        L2.addFirst(5);
        L2.addFirst(6);
        System.out.println(L2.size());
    }
}









