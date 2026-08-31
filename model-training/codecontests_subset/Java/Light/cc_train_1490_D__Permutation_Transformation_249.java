import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;
public class Main{
 static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
 static StringBuilder output=new StringBuilder();
  public static void main(String args[]) throws Exception{
      int t=Integer.parseInt(input.readLine().trim());
      while(t>0){
        solve();
        t--;
      }
      System.out.print(output);
  }
  static void  rec(int l,int h,int count,int a[],int ans[]){
    if(l>h) return;
    int maxindex=l;
    for(int i=l;i<=h;i++){
      if(a[i]>a[maxindex])
        maxindex=i;
    }
    ans[maxindex]=count;
    if(maxindex-1>=l)
      rec(l, maxindex-1, count+1, a, ans);
    if(maxindex+1<=h)
    rec(maxindex+1, h, count+1, a, ans);


  }
  static void solve() throws Exception {
      int n=Integer.parseInt(input.readLine().trim());
      int a[]=Stream.of(input.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
      int ans[]=new int[n];
      rec(0, n-1, 0, a, ans);
      for(int each:ans)
        output.append(each+" ");
      output.append("\n");
     
    }

}