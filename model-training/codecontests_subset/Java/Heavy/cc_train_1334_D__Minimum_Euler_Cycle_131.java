import java.io.*;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        OutputWriter out = new OutputWriter(System.out);
        // Always print a trailing "\n" and close the OutputWriter as shown at the end of your output
        
        // example:
        int t=scn.nextInt();
        for(int i1=0;i1<t;i1++){
            int n=scn.nextInt();long l=scn.nextLong();long r=scn.nextLong();
            long max=(long)(n)*(n-1)+1;
            if(l==max){
                out.print(1+" ");continue;
            }
            long i=binroot(n,l);
            long b=2*n*(i-1)-(i-1)*i;
            long b1=2*n*(i)-(i+1)*i;
            while(l<=r){
                if(l==max){
                    out.print(1+" ");break;
                }
                if((l-b)%2==0){
                    out.print((i+(l-b)/2)+" ");
                }
                else{
                    out.print(i+" ");
                }
                l++;
                if(l>b1){
                    i++;b=b1;b1+=2*n-2*i;
                }
            }
            out.print("\n");
            
        }
        out.close();
    }
    public static long binroot(long n,long l1){
        long l=0;long r=n-1;
        while(r-l>1){
            long m=(l+r)/2;
            if((2*n-1-m)*m<l1){
                l=m;
            }
            else{
                r=m;
            }
        }
        return(r);
    }
    // fast input
    static class Scanner {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public Scanner(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String line = reader.readLine();
                    if (line == null)
                        return null;
                    tokenizer = new StringTokenizer(line);
                } catch (Exception e) {
                    throw(new RuntimeException());
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
    }

    // fast output
    static class OutputWriter {
        BufferedWriter writer;

        public OutputWriter(OutputStream stream) {
            writer = new BufferedWriter(new OutputStreamWriter(stream));
        }

        public void print(int i) throws IOException { writer.write(i); }
        public void print(String s) throws IOException { writer.write(s); }
        public void print(char[] c) throws IOException { writer.write(c); }
        public void close() throws IOException { writer.close(); }
    }


}


