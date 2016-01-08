import java.util.Scanner;


public class Path
{
   private int s; // started vertex
   private int[] edgeTo; //
   private int[] distTo;
   private static final int INFINITY = Integer.MAX_VALUE;
   private boolean[] marked;
   
   
   public Path(Graph g, int start, boolean pathType){
      int v = g.getV();
      marked = new boolean[v];
      distTo = new int[v];
      edgeTo = new int[v];
      for (int i = 0; i < v; i++) {
         distTo[v] = INFINITY;
      }
      if (pathType) {
         pathBFS(g,start);
      }
      if (!pathType) {
         pathDFS(g, start);
      }
   }
   
   public void pathBFS(Graph g, int start) {
      System.out.println();
      System.out.println("Breadth-First Search");
      int v = g.getV();
      Queue<Integer> q = new Queue<Integer>(v);
      q.enqueue(start);
      distTo[start] = 0;
      marked[start] = true;
      while(!q.isEmpty()) {
         int currentVertex = q.dequeue();
         for (int w: g.adj(currentVertex)) {
            if (!marked[w]) {
               q.enqueue(w);
               marked[w] = true;
               distTo[w] = 1 + distTo[v];
               edgeTo[w] = v;
               System.out.println("Vertex: " + w + " dist from " + start + ": " + distTo[w]);
            }
         }
         
      }
      
   }
   
   public void pathDFS(Graph g, int start) {
      System.out.println();
      System.out.println("Depth-First Search");
      int v = g.getV();
      distTo[start] = 0;
      marked[start] = true;
      for (int w: g.adj(start)) {
         if(!marked[w]) {
            pathDFS(g, w);
            edgeTo[w] = start;
            System.out.println("Vertex: " + w + " dist from " + start + ": " + distTo[w]);
         }
      }
      
   }
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Please enter number of vertices in the graph: ");
      int n = sc.nextInt();
      Graph g = new Graph(n);
   }
}
