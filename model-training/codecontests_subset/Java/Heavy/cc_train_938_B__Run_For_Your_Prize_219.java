import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
public class B {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // Scanner scan = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0; i<n; i++)
          a[i] =  Integer.parseInt(st.nextToken());

        int max = -1;
        for(int i=0; i<n; i++) {
          int time = Math.min(Math.abs(a[i] - 1), Math.abs(a[i] - 1000000));
          if(time > max) max = time;
        }
        out.println(max);
        // int n =  Integer.parseInt(st.nextToken());


        out.close(); System.exit(0);
    }


}
