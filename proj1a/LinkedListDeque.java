public class LinkedListDeque<T> {
    private Node<T> headSentinel;
    private Node<T> endSentinel;
    private int size;
    
    private static class Node<T>{
        private Node<T> prev;
        private T item;
        private Node<T> next;


        public Node(T i) {
            prev = null;
            item = i;
            next = null;
        }
        
        public Node(Node<T> p, T i) {
            prev = p;
            item = i;
            next = null;
        }
        public Node(T i, Node<T> n) {
            prev = null;
            item = i;
            next = n;
        }
    }
    public LinkedListDeque() {
        size = 0;
        headSentinel = null;
        endSentinel = null;
    }
    

    public LinkedListDeque(T item) {
        headSentinel = new Node<>(item);
        endSentinel = headSentinel;
        size = 1;
    }

    public void addFirst(T item){
        
        headSentinel = new Node<>(item, headSentinel);
        if (size > 0) {
            headSentinel.next.prev = headSentinel;
        } else {
            endSentinel = headSentinel;
        }
        size++;
    }
    public void addLast(T item){
        
        endSentinel = new Node<>(endSentinel,item);
        if (size > 0) {
            endSentinel.prev.next = endSentinel;
        } else {
            headSentinel = endSentinel;
        }
        size++;
    }

    public T removeFirst() {
        if (headSentinel!= null){
            Node<T> saved = headSentinel;
            if (size != 1){
                headSentinel = headSentinel.next;
                headSentinel.prev = null;
            } else {
                headSentinel = null;
                endSentinel = null;
            }
            T item = saved.item;
            saved.next = null;
            saved = null;
            size--;
            return item;

        } else {
            return null;
        }
         
    }

    public T removeLast() {
        if (endSentinel != null) {
            Node<T> saved = endSentinel;
            if (size != 1) {
                endSentinel = endSentinel.prev;
                endSentinel.next = null;

            } else {
                endSentinel = null;
                headSentinel = null;
            }
            T item = saved.item;
            saved.prev = null;
            saved = null;
            size--;
            return item;

        } else {
            return null;
        }

    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        int i = 0;
        Node<T> point = headSentinel;
        while (i != index) {
            i++;
            point = point.next;
        }
        return point.item;
    }

    public int size() {
        return size;
    }

    
    
    public boolean isEmpty() {
        return size == 0;
    }

    public T getRecursive(int index) {
        if (index < 0 || index >= size){
            return null;
        }
        return getHelper(headSentinel, index);
    }

    public T getHelper(Node<T> head,int index) {
        if (index == 0) {
            return head.item;
        }

        return (T) getHelper(head.next, index--);
    }

    public void printDeque() {
        Node<T> point = headSentinel;
        while (point != null) {
            System.out.print(point.item);
            System.out.print(" ");
            point = point.next;
        }
        System.out.println();
    }



    
}
