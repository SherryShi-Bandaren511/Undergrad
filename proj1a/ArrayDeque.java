public class ArrayDeque<T> {
    // 循环编码的数组
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int capacity;
    
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 0;
        capacity = 0;

    }



    private void reSize(int newCapacity) {
        // 先触发扩容机制
        // 全填满的时候这两指向同一个位置
        T[] newItems = (T[]) new Object[newCapacity];
        int index = nextFirst;
        for (int i = 0; i < size; i++) {
            newItems[i] = items[index];
            index++;
            index = index % size;
        }
        nextFirst = 0;
        capacity = newCapacity;
        nextLast = size;
        items = newItems;

    }
    
    private boolean resizeOrNot() {
        if (size == capacity) {
            return true;
        }
        return false;
    }

    private void action() {
        // 决定到底做不做resize
        if (resizeOrNot()) {
            reSize(this.capacity * 2);
        }
    }
    
    public void addFirst(T item) {
        // 再把元素添加进去
        action();
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + capacity) % capacity;
        size++;

    }

    public void addLast(T item) {
        action();
        items[nextLast] = item;
        nextLast = (nextLast + 1 + capacity) % capacity;
        size++;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(items[i] + " ");
        }
    }

    public T removeFirst() {
        T removeItem = items[nextFirst];
        nextFirst = (nextFirst + 1 + capacity) % capacity;
        size--;
        return removeItem;

    }

    public T removeLast() {
        T removeItem = items[nextLast];
        nextLast= (nextLast - 1 + capacity) % capacity;
        size--;
        return removeItem;

    }

    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return items[index];

    }


}