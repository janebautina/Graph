
public class Graph
{
   private final int V; // number of vertices in the graph
   private Bag<Integer>[] adj; // adjacency list

   public Graph(int n)
   {
      if (n < 0)
         throw new IllegalArgumentException(
               "Number of vertices must be nonnegative");
      this.V = n;
      adj = (Bag<Integer>[]) new Bag[V];
      for (int i = 0; i < n; i++)
      {
         adj[i] = new Bag<Integer>();
      }
   }

   public void addEdge(int v, int w)
   {
      adj[v].addItem(w);
      adj[w].addItem(v);
   }

   public Iterable<Integer> adj(int v)
   {
      return (Iterable<Integer>) adj[v];
   }
   
   public int getV() {
      return V;
   }
   
}
