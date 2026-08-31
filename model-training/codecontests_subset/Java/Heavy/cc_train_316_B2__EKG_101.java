/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.*;
/**
 *
 * @author Rohan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static node[] arr=new node[1010];
    static int[] count=new int[1010];
    static boolean[] can=new boolean[1010];
    static int n,bnum,c;
    public static void main(String[] args) {
        // TODO code application logic here
        input();
    }
    
    public static void input(){
        for(int i=1;i<1010;i++) arr[i]=new node(i,1);
        InputReaderAbbyy3_B1 in=new InputReaderAbbyy3_B1(System.in);
        PrintWriter out=new PrintWriter(System.out);
        n=in.readInt();
        bnum=in.readInt();
        for(int i=1;i<=n;i++){
            int a=in.readInt();
            if(a!=0) union(a,i);
        }
        //for(int i=1;i<=6;i++) out.println(arr[i].parent+" "+arr[i].elements);
        int b_idx=findidx(bnum),bparent=find(bnum); c=0;
        for(int i=1;i<=n;i++){
            if(arr[i].parent==i && i!=bparent){
                count[c++]=arr[i].elements;
            }
        }
        ///out.println(b_idx+" "+bparent);
        
        Arrays.fill(can,false); can[b_idx]=true;
        for(int i=0;i<c;i++){
            //out.println(count[i]);
            for(int j=n-count[i];j>0;j--)
                if(can[j]) can[j+count[i]]=true;
        }
        
        for(int i=1;i<=n;i++) if(can[i]) out.println(i);
        out.flush();
        out.close();
    }
    
    public static int findidx(int x){
        if(arr[x].parent==x) return 1;
        return 1+findidx(arr[x].parent);
    }
    
    public static int find(int x){
        if(arr[x].parent==x) return x;
        return find(arr[x].parent);
    }
    
    public static void union(int x,int y){
        arr[y].parent=x;
        arr[x].elements+=arr[y].elements;
        int temp=x,tempp=arr[x].parent;
        while(tempp!=temp){
            arr[tempp].elements=arr[temp].elements+1;
            temp=tempp;
            tempp=arr[tempp].parent;
        }
    }
}

class node{
    int parent;
    int elements;
    node(int p,int e){
        parent=p;
        elements=e;
    }
}

class InputReaderAbbyy3_B1 {

        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReaderAbbyy3_B1(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
                
                public long readLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            long sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
