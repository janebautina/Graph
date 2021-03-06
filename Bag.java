import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  The <tt>Bag</tt> class represents a bag (or multiset) of 
 *  generic items. It supports insertion and iterating over the 
 *  items in arbitrary order.
 *  <p>
 *  This implementation uses a singly-linked list with a static nested class Node.
 *  See {@link LinkedBag} for the version from the
 *  textbook that uses a non-static nested class.
 *  The <em>add</em>, <em>isEmpty</em>, and <em>size</em> operations
 *  take constant time. Iteration takes time proportional to the number of items.
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/13stacks">Section 1.3</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 *
 *  @param <Item> the generic type of an item in this bag
 */
public class Bag<Item> implements Iterable<Item>
{
   private Node<Item> first;
   private static int N; // number of vertices in the bag
   
   private static class Node<Item> {
      private Item data;
      private Node<Item> next;
      
   };
   
   /**
    * Initializes an empty bag
    */
   public Bag() {
      first = null;
      N = 0;
   }
   
   /**
    * Returns true if this bag is empty.
    *
    * @return <tt>true</tt> if this bag is empty;
    *         <tt>false</tt> otherwise
    */
   public boolean isEmpty() {
      return first == null;
   }
   
   /**
    * Returns the number of items in this bag.
    *
    * @return the number of items in this bag
    */
   public int size () {
      return N;
   }
   
   /**
    * Adds the item to this bag.
    *
    * @param  w the item to add to this bag
    */
   public void addItem(Item w) {
      Node<Item> oldFirst = first;
      first = new Node<Item>();
      first.data = w;
      first.next = oldFirst;
      N++;
   }
   
   /**
    * Returns an iterator that iterates over the items in this bag in arbitrary
    * order.
    * 
    * @return an iterator that iterates over the items in this bag in arbitrary
    *  order.
    */
   @Override
   public Iterator<Item> iterator()
   {
      return new ListIterator<Item>(first);
   }
   
   private class ListIterator<Item> implements Iterator<Item> {
      private Node<Item> current;
      
      public ListIterator(Node<Item> first) {
         current = first;
      }
      
      @Override
      public boolean hasNext()
      {
         return current != null;
         
      }

      @Override
      public Item next()
      {
         if (!hasNext()) throw new NoSuchElementException(); 
         Item item = current.data;
         current = current.next;
         return item;
      }

      // an iterator, doesn't implement remove() since it's optional
      @Override
      public void remove()
      {
         throw new  UnsupportedOperationException();
         
      }
      
   }
   
};
