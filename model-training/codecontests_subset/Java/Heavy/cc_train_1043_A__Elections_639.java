import java.io.*;
import java.lang.*;
import java.util.*;
public class Main {
        public int gcd(int a,int b) {
            if(a>b) {
                return gcd(b,a);
            }
            if(a==0) {
                return b;
            }
        else {
            return gcd(b%a,a);
        }
            
        }
    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        Reader.init(System.in);
        Main mm=new Main();
        int n=Reader.nextInt();
        int[] arr=new int[n];
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<n;i++) {
            int temp=Reader.nextInt();
            if(max<temp) {
                max=temp;
            }
            sum+=temp;
        }
        while(true) {
            if(n*max-sum>sum) {
                break;
            }
            max++;
        }
        System.out.println(max);
    }
}
class node {
    int l;
    int r;
    node(int l,int r){
        this.l=l;
        this.r=r;
    }
}
class help implements Comparator<node>{
        public int compare(node n1,node n2) {
            return n1.l-n2.l;
        }
}
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
 
    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }
 
    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }
 
    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
    static long nextlong() throws IOException{
        return Long.parseLong(next());
    }
    
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}