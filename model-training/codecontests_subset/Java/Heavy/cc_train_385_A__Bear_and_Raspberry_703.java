import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;


public class r226_a {
    static StringTokenizer st;
    static BufferedReader br;
    static PrintWriter pw;
public static void main(String[] args)throws IOException {
    br=new BufferedReader(new InputStreamReader(System.in));
    pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out))); 
    int n=nextInt(),p=nextInt(),a[]=new int[n+1];
    for (int i = 1; i <=n; i++) {
        a[i]=nextInt();
    }
    int max=0;
    for (int i = 1; i <=n-1; i++) {
        if(a[i]>a[i+1]&&max<a[i]-a[i+1])
            max=a[i]-a[i+1];
    }
    pw.print(max-p>0?max-p:0);
    pw.close();
    }
private static int nextInt()throws IOException{
    return Integer.parseInt(next());
}
private static long nextLong()throws IOException{
    return Long.parseLong(next());
}
private static double nextDouble()throws IOException{
    return Double.parseDouble(next());
}
private static String next()throws IOException {
    while (st==null||!st.hasMoreTokens())
     st=new StringTokenizer(br.readLine());
    return st.nextToken();
}
}
