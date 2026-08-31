
import java.io.*;
import java.util.*;
import java.lang.*;
 
 
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int T = in.nextInt();
        for(int test=0;test<T;test++){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++){
                a[i]=in.nextInt();
            }
            if(a[0]+a[1]<=a[n-1]){
                out.println(1+" "+2+" "+n);
            } else {
                out.println(-1);
            }
            
        }

        out.close();
   }

     

   //-----------PrintWriter for faster output---------------------------------
   public static PrintWriter out;
}