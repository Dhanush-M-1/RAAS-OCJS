import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class CF_GOODBYE2014_C {
    
    static Reader sc = new Reader();
    static PrintWriter out = new PrintWriter(System.out); 
    
    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] w = sc.na(n);
        int[] ord = sc.na(m);
        
        boolean[] put = new boolean[n];
        
        int ind = 0;
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        for (int i = 0; i < m; i++) {
            if(!put[ord[i]-1]) {
                res.add(ord[i]);
                put[ord[i]-1] = true;
            }
        }
        
        int cost = 0;
        for (int i = 0; i < m; i++) {
            int currCost = 0;
            for (int act : res) {
                if(act != ord[i]) {
                    currCost += w[act-1];
                } else {
                    cost += currCost;
                    res.remove((Integer)ord[i]);
                    res.add(0, ord[i]);
                    break;
                }
            }           
        }
                
        out.println(cost);
        out.close();
    }
    
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;private byte[] buffer;private int bufferPointer, bytesRead;
        public Reader(){buffer=new byte[BUFFER_SIZE];bufferPointer=bytesRead=0;
        }private void fillBuffer() throws IOException{bytesRead=System.in.read(buffer,bufferPointer=0,BUFFER_SIZE);if(bytesRead==-1)buffer[0]=-1;
        }private byte read() throws IOException{if(bufferPointer==bytesRead)fillBuffer();return buffer[bufferPointer++];
        }public String next() throws IOException{StringBuilder sb = new StringBuilder();byte c;while((c=read())<=' '){if(c==-1) return null;};do{sb.append((char)c);}while((c=read())>' ');if (sb.length()==0) return null;return sb.toString();
        }public String nextLine() throws IOException{StringBuilder sb = new StringBuilder();byte c;boolean read = false;while((c=read())!=-1){if(c=='\n') {read = true;break;}if(c>=' ')sb.append((char)c);}if (!read) return null;return sb.toString();
        }public int nextInt() throws IOException{int ret=0;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c=read();do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(neg)return -ret;return ret;
        }public long nextLong() throws IOException{long ret=0;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c=read();do{ret=ret*10L+c-'0';}while((c=read())>='0'&&c<='9');if(neg)return -ret;return ret;
        }public double nextDouble() throws IOException{double ret=0,div=1;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c = read();do {ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(c=='.')while((c=read())>='0'&&c<='9')ret+=(c-'0')/(div*=10);if(neg)return -ret;return ret;
        }public int[] na(int n) throws IOException{int[] a = new int[n];for(int i = 0;i < n;i++)a[i] = nextInt();return a;
        }public int[][] nm(int n, int m) throws IOException{int[][] map = new int[n][m];for(int i = 0;i < n;i++)map[i] = na(m);return map;
        }public void close() throws IOException{if(System.in==null) return;System.in.close();}
    }
    
    static void print(int[] A) {for(int i=0;i<A.length;i++){if(i!=0) out.print(' ');out.print(A[i]);}out.println();}
    static <T> void print(Iterable<T> A) {int i = 0;for(T act : A){if(i!=0)out.print(' ');out.print(act);i++;}out.println();}
    static void printPlus1(Iterable<Number> A) {int i = 0;for(Number act : A){if(i!=0)out.print(' ');out.print(act.longValue() + 1L);i++;}out.println();}
    static void debug(Object... o) { System.err.println(Arrays.deepToString(o)); }
    
    /*
    long s = System.currentTimeMillis();
    debug(System.currentTimeMillis()-s+"ms");
     */
}
