import java.io.BufferedReader;
import java.io.InputStreamReader;
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
  static void solve() throws Exception {
    char a[]=input.readLine().trim().toCharArray();
    int n=a.length;
    if(n==1)
      output.append(0+"\n");
    else if(n==2){
      if(a[0]==a[1]){
        output.append("1\n");
      }
      else
        output.append("0\n");
    }
    else{
    int   ans=0;
      if(a[0]==a[1]){
        a[1]='@';
        ans++;
      }
      for(int i=2;i<n;i++){
        if((a[i]==a[i-1] )||(( a[i]==a[i-2])) ){
          a[i]='@';
          ans++;
        }
      }
      // System.out.println(Arrays.toString(a));
      output.append(ans+"\n");
    }
  }
} 