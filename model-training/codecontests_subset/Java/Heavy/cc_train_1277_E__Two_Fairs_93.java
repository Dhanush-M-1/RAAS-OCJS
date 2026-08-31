
    import java.util.*;
    import java.lang.*;
    import java.lang.reflect.Array;
    import java.io.*;
    import java.math.*;
    import java.text.DecimalFormat;
    public class Prac{     
        static class InputReader { 
            private final InputStream stream;
            private final byte[] buf = new byte[8192];
            private int curChar, snumChars;
            public InputReader(InputStream st) {
                this.stream = st;
            } 
            public int read() {
                if (snumChars == -1)
                    throw new InputMismatchException();
                if (curChar >= snumChars) {
                    curChar = 0;
                    try {
                        snumChars = stream.read(buf);
                    } 
                    catch (IOException e) {
                        throw new InputMismatchException();
                    }
                    if (snumChars <= 0)
                        return -1;
                }
                return buf[curChar++];
            }
            public int ni() {
                int c = read();
                while (isSpaceChar(c)) {
                    c = read();
                }
                int sgn = 1;
                if (c == '-') {
                    sgn = -1;
                    c = read();
                }
                int res = 0;
                do {
                    res *= 10;
                    res += c - '0';
                    c = read();
                } while (!isSpaceChar(c));
                return res * sgn;
            } 
            public long nl() {
                int c = read();
                while (isSpaceChar(c)) {
                c = read();
                }
                int sgn = 1;
                if (c == '-') {
                    sgn = -1;
                    c = read();
                }
                long res = 0;
                do {
                    res *= 10;
                    res += c - '0';
                    c = read();
                } while (!isSpaceChar(c));
                return res * sgn;
            } 
            public int[] nia(int n) {
                int a[] = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = ni();
                }
                return a;
            } 
            public String rs() {
                int c = read();
                while (isSpaceChar(c)) {
                    c = read();
                }
                StringBuilder res = new StringBuilder();
                do {
                    res.appendCodePoint(c);
                        c = read();
                } while (!isSpaceChar(c));
                return res.toString();
            }
            public String nextLine() {
                int c = read();
                while (isSpaceChar(c))
                    c = read();
                StringBuilder res = new StringBuilder();
                do {
                    res.appendCodePoint(c);
                    c = read();
                } while (!isEndOfLine(c));
                return res.toString();
            } 
            public boolean isSpaceChar(int c) {
                return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
            }

            private boolean isEndOfLine(int c) {
                return c == '\n' || c == '\r' || c == -1;
            } 
        }
        static PrintWriter w = new PrintWriter(System.out);
        static long mod=998244353L,mod1=1000000007;

        static HashSet<Integer> arr[];
        static boolean v[],ce=false;
        static int n,m,a,b,cou=0;
        static void dfsA(int i,int p){
//            if(i==b){
//                ce=true;
//                return true;
//
//            }
            //if(v[i])return false;
            v[i]=true;
            cou++;
            //boolean f=false;
            //HashSet<Integer> temp=new HashSet<>();
            for(int j:arr[i]){
                if(!v[j]&&j!=b){
                    dfsA(j,i);
                    //temp.add(j);
                    //f=true;
                    //return true;
                }
            }
//            for(int j:temp){
//                arr[i].remove(j);
//                arr[j].remove(i);
//            }
            //return false;
        }
        static void dfsB(int i,int p){
            //if(v[i])return;
            v[i]=true;
            cou++;
            for(int j:arr[i]){
                if(!v[j]&&j!=a)dfsB(j,i);
            }
        }
        public static void main (String[] args)throws IOException{
            InputReader sc=new InputReader(System.in);
    //        int t=sc.ni();
    //        while(t-->0){
    //            char arr[]=sc.nextLine().toCharArray();
    //            
    //            for(int i=2;i<arr.length;i++){
    //                int j=i-2,k=i-1,l=i;
    //                while(arr[j]=='o'&&arr[k]=='n'&&arr[l]=='e')
    //            }
    //        }
            int t=sc.ni();
            while(t-->0){
                ce=false;
                n=sc.ni();m=sc.ni();a=sc.ni();b=sc.ni();
                arr=new HashSet[n+1];
                v=new boolean[n+1];
                for(int i=0;i<=n;i++)arr[i]=new HashSet<>();
                for(int i=0;i<m;i++){
                    int u=sc.ni(),v=sc.ni();
                    arr[u].add(v);
                    arr[v].add(u);
                }
                //cou=0;
                //dfsA(a,a);
                Arrays.fill(v,false);
                cou=0;
                dfsA(a,a);
                Arrays.fill(v,false);
                long ans=1;
                ans*=(n-cou-1);
                cou=0;
                dfsB(b,b);
                w.println(ans*(n-cou-1));
            }
            w.close();
        }
    }