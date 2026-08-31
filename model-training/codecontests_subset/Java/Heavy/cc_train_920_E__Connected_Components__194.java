import java.util.*;
import java.io.*;
import java.math.*;
public class Connected{
    static int n,m,ans=0;
    static ArrayList<Integer> vals=new ArrayList<>();
    static HashMap<Integer,HashSet<Integer>> hs=new HashMap<>();
    static TreeSet<Integer> ts=new TreeSet<>();
    public static int dfs(int v){
      int ans=1;
      ArrayList<Integer> temp=new ArrayList<>();
      for(Integer x:ts)
        if(!hs.get(v).contains(x))
          temp.add(x);

        for(Integer x:temp)
          ts.remove(x);

        for(Integer x:temp)
          ans+=dfs(x);
        return ans;
    }

    public static void main(String[] args) {
        MyScanner sc=new MyScanner();
        n=sc.nextInt();
        m=sc.nextInt();
        for(int i=1;i<=n;i++){
          hs.put(i,new HashSet<Integer>());
          ts.add(i);
        }
        for(int i=0;i<m;i++){
          int v1=sc.nextInt();
          int v2=sc.nextInt();
          hs.get(v1).add(v2);
          hs.get(v2).add(v1);
        }
        int cons=0;
        while(!ts.isEmpty()){
          cons++;
          vals.add(dfs(ts.pollFirst()));
        }
        System.out.println(cons);
        vals.sort(null);
        for(Integer x:vals)
          System.out.print(x+" ");
    }


    private static class MyScanner {
      BufferedReader br;
      StringTokenizer st;

      public MyScanner() {
         br = new BufferedReader(new InputStreamReader(System.in));
      }

      String next() {
          while (st == null || !st.hasMoreElements()) {
              try {
                  st = new StringTokenizer(br.readLine());
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
          return st.nextToken();
      }

      int nextInt() {
          return Integer.parseInt(next());
      }

      long nextLong() {
          return Long.parseLong(next());
      }

      double nextDouble() {
          return Double.parseDouble(next());
      }

      String nextLine(){
          String str = "";
	  try {
	     str = br.readLine();
	  } catch (IOException e) {
	     e.printStackTrace();
	  }
	  return str;
      }
   }
}