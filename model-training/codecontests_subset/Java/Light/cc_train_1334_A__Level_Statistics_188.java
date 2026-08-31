import java.util.*;
import java.io.*;
public class Q3 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int z=0;z<t;z++){
            int n = Integer.parseInt(br.readLine());
            int p[]=new int[n];
            int c[]=new int[n];
            
            for(int i=0;i<n;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                p[i]=Integer.parseInt(st.nextToken());
                c[i]=Integer.parseInt(st.nextToken());
            }
            int pos = 1;
            for(int i=0;i<n;i++){
              if(i>0 && (p[i]<p[i-1]||c[i]<c[i-1])){
                  pos=0;
                  break;
              }
              else if(i>0 &&(p[i]-p[i-1]<c[i]-c[i-1])){
                  pos=0;
                  break;
              }
              else if(i==0 && c[i]>p[i]){
                  pos=0;
                  break;
              }                  
            }
            if(pos==1)
                System.out.println("YES");
            else System.out.println("NO");
        }
        }
    }
