import java.util.Scanner;

/**
 * The <tt>Path</tt> class represents breadth-first search and depth-first
 * search algorithms for given graph
 * <p>
 * For example:
 * 
 * <pre>
 * Path p = new Path(g, 0, true);
 * System.out.println(p);
 * </pre>
 * 
 * </p>
 * 
 * @author Evgeniya Bautina
 * @version 1.0 7 Jan 2016
 */
public class Path
{
   private int[] edgeTo;
   private int[] distTo;
   private static final int INFINITY = Integer.MAX_VALUE;
   private boolean[] marked;

   /**
    * Creates paths using BFS and DFS
    * 
    * @param g
    *           the graph
    * @param start
    *           the start vertex of the path
    * @param pathType
    *           if true calls breadth-first search, if false calls depth-first
    *           search
    */
   public Path(Graph g, int start, boolean pathType)
   {
      int v = g.getV();
      marked = new boolean[v];
      distTo = new int[v];
      edgeTo = new int[v];
      for (int i = 0; i < v; i++)
      {
         distTo[i] = INFINITY;
      }
      if (pathType)
      {
         pathBFS(g, start);
      }
      if (!pathType)
      {
         System.out.println();
         System.out.println("Depth-First Search");
         pathDFS(g, start);
      }
   }

   /**
    * Breadth-First Search implementation
    * 
    * @param g
    *           the graph
    * @param the
    *           start vertex of the path
    */
   public void pathBFS(Graph g, int start)
   {
      System.out.println();
      System.out.println("Breadth-First Search");
      int v = g.getV();
      Queue<Integer> q = new Queue<Integer>(v);
      q.enqueue(start);
      distTo[start] = 0;
      marked[start] = true;
      while (!q.isEmpty())
      {
         int currentVertex = q.dequeue();
         for (int w : g.adj(currentVertex))
         {
            if (!marked[w])
            {
               q.enqueue(w);
               marked[w] = true;
               distTo[w] = 1 + distTo[currentVertex];
               edgeTo[w] = currentVertex;
               System.out.println("Vertex: " + w + " dist from " + start + ": "
                     + distTo[w]);
            }
         }
      }
   }

   /**
    * Depth-First Search implementation
    * 
    * @param g
    *           the graph
    * @param start
    *           vertex of the path
    */
   public void pathDFS(Graph g, int start)
   {
      distTo[start] = 0;
      marked[start] = true;
      for (int w : g.adj(start))
      {
         if (!marked[w])
         {
            pathDFS(g, w);
            edgeTo[w] = start;
            System.out.println("Vertex: " + w);
         }
      }
   }

   /**
    * Client function prints reads and prints the graph and BFS, DFS paths from
    * given vertex
    * 
    * @param args
    *           command line arguments
    */
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      System.out.println("Please enter number of vertices in the graph: ");
      int v = sc.nextInt();
      Graph g = new Graph(v);
      System.out.println("Please enter number of edges in the graph: ");
      int e = sc.nextInt();
      for (int i = 0; i < e; i++)
      {
         int w1 = sc.nextInt();
         int w2 = sc.nextInt();
         g.addEdge(w1, w2);
      }
      System.out.println(g);
      System.out.println("Please enter the start vertex of the path: ");
      int start = sc.nextInt();
      // BFS
      Path pbfs = new Path(g, start, true);
      Path pdfs = new Path(g, start, false);
   }
}
