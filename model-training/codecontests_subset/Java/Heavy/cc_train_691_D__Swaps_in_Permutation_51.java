
import java.io.*;
import java.util.*;

public class GFG {

  private static ArrayList<Integer> []G;
  private static int []a;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
//    int t = Integer.parseInt(br.readLine().trim());
//    while (t-- != 0) {
      StringTokenizer st = new StringTokenizer(br.readLine().trim());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine().trim());
      a=new int[n];
      for(int i=0;i<n;i++)
        a[i]=Integer.parseInt(st.nextToken());
      G=new ArrayList[n];
      for (int i=0;i<n;i++)
        G[i]=new ArrayList<>();
      for(int i=0;i<m;i++) {
        st = new StringTokenizer(br.readLine().trim());
        int u=Integer.parseInt(st.nextToken())-1;
        int v=Integer.parseInt(st.nextToken())-1;
        G[u].add(v);
        G[v].add(u);
      }
      ArrayList<Integer> A=new ArrayList<>();
      boolean []vis=new boolean[n];
      PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
      Queue<Integer> q=new LinkedList<>();
      for(int i=0;i<n;i++)
        if(!vis[i]) {
          q.add(i);
          while(!q.isEmpty()){
            int u=q.poll();
            if(vis[u])
              continue;
            A.add(u);
            vis[u]=true;
            for(int v:G[u]){
              if(!vis[v])
                q.add(v);
            }
          }
          Collections.sort(A);
          for(int j:A)
            pq.add(a[j]);
          for(int j:A)
            a[j]=pq.poll();
          A.clear();
        }
      for(int i:a)
        out.print(i+" ");
      out.println();
//    }
    out.close();
  }

}

