package queues;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Objects of type Queue manage items in a singly linked list (a playlist in our case)
 * where we can enqueue items to the end and dequeue items from the front of the queue.
 *
 * @author Ali Zargari
 * @version 1.0
 */

public class Queue<T> extends LinkedList<T> implements Iterable<T>{

    // Holds the name of the Queue
    private String name;

    // Holds the first element in the queue
    private Node head;

    // Holds the last element in the Queue
    private Node tail;

    //constructor, only modifies name.
    public Queue(String n){

        name = n;
    }

    /***
     * Returns the number of items in the queue.
     *
     * @return The size of the queue.
     */
    public int size() {

        return super.size();
    }

    /***
     * Returns the name of the queue.
     *
     * @return The name of the queue.
     */
    public String getName() {

        return name;
    }

    /***
     * Returns True if the queue is empty.
     * Else, returns false.
     *
     * @return True if size is 0. False if not.
     */
    public boolean isEmpty() {
        return (size() == 0);
    }

    /***
     * Returns the last item in the queue, if it exists. Does not remove.
     *
     * @return The last item in the queue, if it exists. False otherwise.
     */
    public T peek() {
        if (isEmpty()) {
            System.out.println("\nQueue is empty.\n");
            return null;
        }
        return head.data;
    }

    /***
     * Queues the item that is passed in the parameter, and confirms if
     * operation is successful.
     *
     * @return True if the item parameter is added successfully. False otherwise.
     * @param item the item to be enqueued.
     */
    public void enqueue(T item) {
        Node temp = new Node(item);

        if (size() == 0) {
            head = temp;
            tail = temp;
        }

        tail.next = temp;
        tail = temp;
        addLast(tail.data);
    }

    /***
     * dequeues an item from the front, if the queue is not empty.
     *
     * @return The dequeued item. If the queue is empty, throws a NoSuchElementException.
     */
    public T dequeue() throws NoSuchElementException{
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node temp = head;
        head = head.next;

        return (T) removeFirst();
    }

    /***
     * Returns an appropriate iterator.
     *
     * @return An iterator that can be used to iterate through Queue.
     */
    @Override
    public QueueIterator iterator() {
        return new QueueIterator();
    }

    /***
     * Formats this object to be properly show its information in string format
     *
     * @return A string that represents this object
     */
    public String toString(){

        String str = "[ ";
        QueueIterator qt = iterator();

        if(size() == 1){
            return "[" + qt.next() + "]";
        }

        if(size() == 0){
            return "[ ]";
        }

        while(qt.hasNext()){
            str += qt.next();
            if(qt.hasNext()){
                str +=  ", \n";

            } else {
                str += " ]";
            }
        }

        return str;
    }

    /**
     * Node is used to store the data being processed by Queue.
     * Holds a pointer to the next Node, and an object of generic type T.
     *
     */
    private class Node {
        Node next;  // Contains next item.
        T data;  // Data of type T being held in Node

        /**
         * Constructor for Node
         *
         * @param data is the data to be held by this object.
         */
        Node(T data){
            this.next = null;
            this.data = data;
        }

    }

    /**
     * An object of inner class QueueIterator helps iterate through a Queue of generic type T.
     * Is an Iterator, will have next and hasNext functions.
     *
     * */
    private class QueueIterator implements Iterator<T>{

        /**
         * The current Node
         */
        private Node current;

        /**
         * Constructor used to initialize current
         */
        public QueueIterator(){
            current = head ;
        }

        /**
         * Returns true if there is a next item in the Queue. It returns false if
         * we are at the end of our queue.
         *
         * */
        @Override
        public boolean hasNext() {
            return (current != null);
        }


        /**
         * Returns the "next" item in the QueueIterator. "next" here is referring to the data that
         * our "cursor" just went over. It will start from the first item, and go all the way to last.
         */
        @Override
        public T next() {
            T temp = current.data;
            current = current.next;
            return temp;
        }
    }
}
