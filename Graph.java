/**
 * The <tt>Graph</tt> class represents a graph or a set of objects where some
 * pairs of objects are connected. For example:
 * <p>
 * <pre>
 * Graph g = new Graph(10);
 * System.out.println(g);
 * </pre>
 * </p>
 * @author  Evgeniya Bautina
 * @version 1.0 7 Jan 2016
 */
public class Graph
{
   private final int V; // number of vertices in the graph
   private final int E; // number of edges in the graph
   private Bag<Integer>[] adj; // adjacency list

   /**
    * Initializes a graph with v vertices
    * 
    * @param v
    *           number of vertices in the graph
    */
   public Graph(int v)
   {
      if (v < 0)
         throw new IllegalArgumentException(
               "Number of vertices must be nonnegative");
      this.V = v;
      this.E = 0;
      if (E < 0)
         throw new IllegalArgumentException("Number of edges should be > 0");
      if (V < 0)
         throw new IllegalArgumentException("Number of vertices should be > 0");
      adj = (Bag<Integer>[]) new Bag[V];
      for (int i = 0; i < V; i++)
      {
         adj[i] = new Bag<Integer>();
      }
   }

   /**
    * Adds an edge to the graph
    * 
    * @param v
    *           left vertex in the edge
    * @param w
    *           right vertex in the edge
    */
   public void addEdge(int v, int w)
   {
      adj[v].addItem(w);
      adj[w].addItem(v);
   }

   public Iterable<Integer> adj(int v)
   {
      return adj[v];
   }

   /**
    * Getter for number of vertices in the graph
    * 
    * @return number of vertices in the graph
    * */
   public int getV()
   {
      return V;
   }

   /**
    * Returns a string representation of the graph.
    */
   public String toString()
   {
      StringBuilder st = new StringBuilder();
      st.append("Vertices: " + V + "\n");
      for (int v = 0; v < V; v++)
      {
         st.append(v + ": ");
         for (int w : adj[v])
         {
            st.append(w + " ");
         }
         st.append("\n");
      }
      return st.toString();
   }

}
