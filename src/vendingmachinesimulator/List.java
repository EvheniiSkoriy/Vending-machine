package vendingmachinesimulator;

/**
 * @author we can create list type T
 * @param <T>
 */
public class List<T> {

    private Node<T> first;
    private int size = 0;

    /**
     * add element
     *
     * @param element - its a element that you want add
     */
    public void add(T element) {

        Node<T> l = first;
        Node<T> newElem = new Node(element, null, null);
        if (l == null) {
            first = newElem;
        } else {
            while (l.hasNext()) {
                l = l.next();
            }
            l.mNextNode = newElem;
            newElem.mPrevNode = l;
        }
        size++;
    }

    /* 
     *@param element - 
     *  T - type of element
    *
     */

    /**
     * add element on choosen index
     *
     * @param index position where you want add element
     * @param element its a element that you want add
     */
    public void add(int index, T element) throws IndexOutOfBoundsException {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(element);
        } else if (index == 0) {
            addFirst(element);
        } else {
            Node<T> start = first;
            for (int i = 0; i < index; i++) {
                start = start.next();
            }
            Node<T> newElem = new Node(element, start, start.mPrevNode);
            start.mPrevNode.mNextNode = newElem;
            start.mPrevNode = newElem;
            size++;
        }

    }

    /**
     * add element on first position
     */
    private void addFirst(T e) {
        Node<T> f = first;
        Node<T> newElem = new Node(e, f, null);
        first = newElem;
        f.mPrevNode = newElem;
        size++;
    }



    /**
     * get the element from list
     * @param index position of element
     * @return element or object type T
     * @throws IndexOutOfBoundsException
     */
    public T get(int index) throws IndexOutOfBoundsException {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> start = first;
        for (int i = 0; i < index; i++) {
            start = start.next();
        }
        return start.getItem();
    }


    /**
     *remove element
     * @param index position of element
     * @return element or object type T
     */
    public T remove(int index) throws IndexOutOfBoundsException {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return removeFirst();
        } else {
            Node<T> start = first;
            for (int i = 0; i < index; i++) {
                start = start.next();
            }
            if (!start.hasNext()) {
                start.mPrevNode.mNextNode = null;
            } else {
                start.mPrevNode.mNextNode = start.mNextNode;
                start.mNextNode.mPrevNode = start.mPrevNode;
            }
            size--;
            return start.getItem();

        }
    }

    private T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node<T> f = first;
        if (size == 1) {
            first = null;
            size--;
            return f.getItem();
        } else {
            first.mNextNode.mPrevNode = null;
            first = first.mNextNode;
        }
        size--;
        return f.getItem();
    }


    /**
     *  set the element in list on choosent position
     * @param index  position of element 
     * @param element
     * @return its a element that you want set on choosen position 
     */
    public T set(int index, T element) throws IndexOutOfBoundsException {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> start = first;
        for (int i = 0; i < index; i++) {
            start = start.mNextNode;
        }
        T returnedElement = start.getItem();
        start.setItem(element);
        return returnedElement;
    }
// 

    /**
     *size our list
     * @return size
     */
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String returned = "";
        Node<T> start = first;
        if (start != null) {
            returned += "  " + start.getItem() + "  ";
            while (start.hasNext()) {
                start = start.mNextNode;
                returned += start.getItem() + "  ";
            }
            returned = returned.substring(0, returned.length() - 2);
        }

        return returned;
    }

    static class Node<T> {

        private T mElement;
        Node mNextNode;
        Node mPrevNode;

        public Node(T item, Node next, Node previous) {
            this.mElement = item;
            this.mNextNode = next;
            this.mPrevNode = previous;
        }

        public boolean hasNext() {
            return mNextNode != null;
        }

        public boolean hasPrevious() {
            return mPrevNode != null;
        }

        public Node next() {
            return mNextNode;
        }

        public T getItem() {
            return mElement;
        }

        public void setItem(T item) {
            this.mElement = item;
        }

    }
}
