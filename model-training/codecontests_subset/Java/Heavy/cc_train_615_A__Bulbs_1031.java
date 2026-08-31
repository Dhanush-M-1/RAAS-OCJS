import java.util.*; 
import java.math.*;
import java.io.*;
import java.text.DecimalFormat;
import java.math.BigInteger;
public class Main{
    static int d=20,ans;
    static long mod=1000000007;
    static  ArrayList<ArrayList<Integer>> arr;
    static int[] a;
    static int[][] data;

    public static void main(String[] args)  throws IOException {
        s.init(System.in);   
        
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n,m;
        n=s.ni();
        m=s.ni();
        int[] vis=new int[m+1];
        int sum=0;
        for(int i=0;i<n;i++){
            int x=s.ni();
            for(int j=0;j<x;j++){
                int a=s.ni();
                if(vis[a]==0){
                    vis[a]++;
                    ans++;
                }

            }
        }
        if(ans==m)
            out.println("YES");
        else
            out.println("NO");


           
        out.close();
    }




    public static class s {
        static BufferedReader reader;
        static StringTokenizer tokenizer;
 
        /** call this method to initialize reader for InputStream */
        static void init(InputStream input) {
            reader = new BufferedReader(
                        new InputStreamReader(input) );
            tokenizer = new StringTokenizer("");
        }   
 
        /** get next word */
        static String ns() throws IOException {
            while ( ! tokenizer.hasMoreTokens() ) {
                //TODO add check for eof if necessary
                tokenizer = new StringTokenizer(
                    reader.readLine() );
            }
            return tokenizer.nextToken();
        }
 
        static int ni() throws IOException {
            return Integer.parseInt( ns() );
        }
    
        static double nd() throws IOException {
            return Double.parseDouble( ns() );
        }
        static long nl() throws IOException {
            return Long.parseLong( ns() );
        }
        
    }
}   