import java.util.*;
import java.io.*;
public class CF920E {
   private static Set<Integer> unvisited;

   private static List<Integer> components;

   private static boolean[] visited;

   private static Map<Integer, Set<Integer>> antiEdges;

   public static void main(String[] args) throws Exception {
   
      BufferedReader bs = new BufferedReader(new InputStreamReader(System.in));
      String[] ve = bs.readLine().split(" ");
      int vertices = Integer.parseInt(ve[0]);
      int edges = Integer.parseInt(ve[1]);
      visited = new boolean[vertices+1];
   
      antiEdges = new HashMap<>();
   
      unvisited = new TreeSet<>();
   
      components = new ArrayList<>();
   
      for(int i=1;i<vertices+1;i++) {
         antiEdges.put(i, new TreeSet<>());
         unvisited.add(i);
      }
   
      for(int i=0;i<edges;i++) {
         String[] ve1 = bs.readLine().split(" ");
         int v = Integer.parseInt(ve1[0]);
         int w = Integer.parseInt(ve1[1]);
      
         Set<Integer> antiV = antiEdges.get(v);
         antiV.add(w);
         antiEdges.put(v, antiV);
      
         Set<Integer> antiW = antiEdges.get(w);
         antiW.add(v);
         antiEdges.put(w, antiW);
      }
   
      for(int i=1;i<=vertices;i++) {
         if(!visited[i]) {
            components.add(bfs(i));
         }
      }
   
      System.out.println(components.size());
      Collections.sort(components);
      System.out.print(components.get(0));
      for(int i=1;i<components.size();i++) {
         System.out.print(" " + components.get(i));
      }
   
   }

   private static int bfs(int start) {
      int res = 0;
      Stack<Integer> s = new Stack<>();
      s.push(start);
   
      while(!s.empty()) {
         int top = s.pop();
         if(visited[top]) 
            continue;
         visited[top] = true;
         res++;
         unvisited.remove(top);
         Set<Integer> antiAdj = antiEdges.get(top);
         for(Integer i: new ArrayList<>(unvisited)) {
            if(antiAdj.contains(i)) 
               continue;
            if(!visited[i]) {
               s.push(i);
               unvisited.remove(i);
            }
         }
      
      }
      return res;
   }}