
/**
 * A class representing a queue data structure implemented
 * using an array.
 * For example:
 * <pre>
 *    Queue q = new Queue(10);
 *    StdOut.println(q);
 * </pre>
 *
 * @author  Evgeniya Bautina
 * @version 1.0 11 Oct 2015
 */   
public class Queue<Key> {
    private int capacity;   
    private Key[] q;    
    private int elemNum; //number of elements in the queue   
    private int head; // pointer to the first element in the queue
    private int tail; //pointer to the last element in the queue
    
   /**
    * Creates an empty queue.   
    *
    * @param  size  array size
    */
    public Queue(int size) {
        capacity = size;
        q = (Key[]) new Object[capacity];
    }
    
   /**
    * Checks a queue for emptiness. 
    *
    * @return      true if queue is empty
    */
    public boolean isEmpty() { 
       return elemNum == 0; 
    }
    
   /**
    * Adds an element to the queue. If an array is full,
    * calls resize function to double the array size.
    *
    * @param  elem  element to be added to the queue
    */   
    public void enqueue(Key elem) { //add an element to the queue
        if (elemNum == capacity) {
           resize();
        }
        if (tail == capacity) {
            tail = 0;
            q[tail++] = elem;
            elemNum++;
        }
        else {
            q[tail] = elem;
            tail++;
            elemNum++;
        }  
    }
    
   /**
    * Deletes an element from the queue. 
    *
    * @return      element deleted from the queue
    * @see         Queue
    */
    public Key dequeue() { 
        if (isEmpty())
            return null;
        elemNum--;
        return q[head++];
    }
    
   /**
    * Doubles an array size then the array is full.  
    *
    */
    private void resize() { // double array size
        int oldCapacity = capacity;
        capacity *= 2;
        Key [] newArray = (Key[]) new Object[capacity];
        if (tail > head) {
            int j = 0;
            for (int i = head; i <= tail - 1; i++) {
               newArray[j] = q[i];
               j++;   
            }
        }
        else {
            int j = 0;
            for (int i = head; i < oldCapacity; i++) {
                newArray[j] = q[i];
                j++;
            }
            for (int i = 0; i < tail; i++) {
                newArray[j] = q[i];
                j++;
            }
            
        }
        q = newArray;
        head = 0;
        tail = elemNum;
    }
    
   /**
    * Returns a number of elements in the queue. 
    *
    * @return      number of elements in the queue
    */
    public int size() { // size of the queue
        return elemNum;
    }
    
   /**
    * Intended only for debugging.
    */
    public String toString() {
        String st = "";
        for (int i = 0; i < capacity; i++) {
           st = st + q[i].toString() + " -> ";
        }
        return st;    
    }    
}
