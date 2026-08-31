import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class C {

    void solve() throws IOException {
        int n=nextInt();
        int m=nextInt();
        int[] w=new int[n];
        for(int i=0;i<n;i++)w[i]=nextInt();
        int[] a=new int[m];
        for(int i=0;i<m;i++)a[i]=nextInt()-1;
        int[] books=new int[n];
        int size=0;
        int ans=0;
        for(int i=0;i<m;i++){
            int j=size-1;
            for(;j>=0;j--){
                if(books[j]==a[i])break;
                ans+=w[books[j]];
            }
            if(j!=-1){
                for(;j<size-1;j++)
                    books[j]=books[j+1];
                books[size-1]=a[i];
            }
            else
                books[size++]=a[i];
        }
        out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        new C().run();
    }

    void run() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
//      reader = new BufferedReader(new FileReader("input.txt"));
        tokenizer = null;
        out = new PrintWriter(new OutputStreamWriter(System.out));
//      out = new PrintWriter(new FileWriter("output.txt"));
        solve();
        reader.close();
        out.flush();

    }

    BufferedReader reader;
    StringTokenizer tokenizer;
    PrintWriter out;

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }
}
