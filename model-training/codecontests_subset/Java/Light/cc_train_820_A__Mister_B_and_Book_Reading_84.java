
import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;
        PrintWriter p = new PrintWriter(System.out);
        StringBuilder out = new StringBuilder();
        tk=new StringTokenizer(in.readLine());
        int c=parseInt(tk.nextToken()),v0=parseInt(tk.nextToken()),v1=parseInt(tk.nextToken()),a=parseInt(tk.nextToken()),l=parseInt(tk.nextToken());
        int cur=v0;
        int ans=1;
        v0+=a;
        while(cur<c){
          if(v0+l<=v1){
              cur+=v0-l;
              
          }
          else 
              cur+=Math.min(v0,v1)-l;
          v0+=a;
            ans++;
        }
        p.println(ans);
        p.flush();
        p.close();
    }
}
/*
4
6 3
111000
5 2
11010
3 3
110
3 3
10
*/
