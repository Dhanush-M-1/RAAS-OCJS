
import java.util.*;
import java.io.*;
 
public class Mamo {
    static long mod=998244353;
    static Reader in=new Reader();
    static List<Integer >G[];
    static boolean B=true;
    static StringBuilder Sl=new StringBuilder();
    static int DP[][];
    public static void main(String [] args) {
    	//Dir by MohammedElkady
    int t=1;
    	while(t-->0) {
    		int n=in.nextInt(),k=in.nextInt();
    		node[]node=new node[n];
    		for(int i=0;i<n;i++) {
    			int tt=in.nextInt(),a=in.nextInt(),b=in.nextInt();
    			node[i]=new node(tt,a,b);
    		}
    		long ans=0L;
    		Arrays.parallelSort(node);
    		ArrayList<Integer>bob=new ArrayList(),eles=new ArrayList(),all=new ArrayList();
    		for(int i=0;i<n;i++) {
    			if(node[i].a==1&&node[i].b==1) {all.add(node[i].f);}
    			else if(node[i].a==1&&eles.size()<k) {eles.add(node[i].f);}
    			else if(node[i].b==1&&bob.size()<k) {bob.add(node[i].f);}
    			
    		}
    		if(bob.size()+(2*all.size())+eles.size()<k) {out.append("-1"+"\n");}
    		else {
    			int i=0,u=0,v=0;
    			while(k>0&&i<all.size()&&u<eles.size()&&bob.size()>v) {
    				k--;
    				if(all.get(i)>eles.get(u)+bob.get(v)) {
    					ans+=(eles.get(u)+bob.get(v));
    					u++;v++;
    				}
    				else {ans+=(all.get(i));i++;}	
    			}
    			while(all.size()>i&&k>0) {ans+=(all.get(i));i++;k--;}
    			while(k>0&&eles.size()>u&&bob.size()>v) {k--;
    			ans+=(eles.get(u)+bob.get(v));
				u++;v++;
    			}
    			if(k>0)
    				out.append(-1+"\n");
    			else 
    			out.append(ans+"\n");
    		}
    	}
    out.close();}
//    static int[]fromlist(ArrayList<Integer>l){
//    	int a[]=new int[l.size()];
//    	for(int i=0;i<l.size();i++)a[i]=l.get(i);
//    }
    
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static long gcd(long g,long x){if(x<1)return g;else return gcd(x,g%x);}
    static class Reader 
    { 
        private InputStream mIs;private byte[] buf = new byte[1024];private int curChar,numChars;public Reader() { this(System.in); }public Reader(InputStream is) { mIs = is;} 
        public int read() {if (numChars == -1) throw new InputMismatchException();if (curChar >= numChars) {curChar = 0;try { numChars = mIs.read(buf);} catch (IOException e) { throw new InputMismatchException();}if (numChars <= 0) return -1; }return buf[curChar++];} 
        public String nextLine(){int c = read();while (isSpaceChar(c)) c = read();StringBuilder res = new StringBuilder();do {res.appendCodePoint(c);c = read();}while (!isEndOfLine(c));return res.toString() ;} 
        public String s(){int c = read();while (isSpaceChar(c)) c = read();StringBuilder res = new StringBuilder();do {res.appendCodePoint(c);c = read();}while (!isSpaceChar(c));return res.toString();} 
        public long l(){int c = read();while (isSpaceChar(c)) c = read();int sgn = 1;if (c == '-') { sgn = -1 ; c = read() ; }long res = 0; do{ if (c < '0' || c > '9') throw new InputMismatchException();res *= 10 ; res += c - '0' ; c = read();}while(!isSpaceChar(c));return res * sgn;} 
        public int nextInt(){int c = read() ;while (isSpaceChar(c)) c = read();int sgn = 1;if (c == '-') { sgn = -1 ; c = read() ; }int res = 0;do{if (c < '0' || c > '9') throw new InputMismatchException();res *= 10 ; res += c - '0' ; c = read() ;}while(!isSpaceChar(c));return res * sgn;} 
        public double d() throws IOException {return Double.parseDouble(s()) ;}
        public boolean isSpaceChar(int c) { return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1; } 
        public boolean isEndOfLine(int c) { return c == '\n' || c == '\r' || c == -1; } 
        public int[] arr(int n){int[] ret = new int[n];for (int i = 0; i < n; i++) {ret[i] = nextInt();}return ret;}
    }
}
class node implements Comparable<node>{
int f, a,b;
node(int tt,int ll,int vv){
f=tt;a=ll;b=vv;
}
    @Override
    public int compareTo(node o) {
    return f-o.f;    
    }
}
class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
}
 
class Sorting{
 
 public static node[] bucketSort(node[] array, int bucketCount) {
 
 if (bucketCount <= 0) throw new IllegalArgumentException("Invalid bucket count");
 
 if (array.length <= 1) return array; //trivially sorted
 
 
 
 int high = array[0].f;
 
 int low = array[0].f;
 
 for (int i = 1; i < array.length; i++) { //find the range of input elements
 
 if (array[i].f > high) high = array[i].f;
 
 if (array[i].f < low) low = array[i].f;
 
 }
 
 double interval = ((double)(high - low + 1))/bucketCount; //range of one bucket
 
 
 ArrayList<Integer> buckets[] = new ArrayList[bucketCount];
 
 for (int i = 0; i < bucketCount; i++) { //initialize buckets
 
 buckets[i] = new ArrayList();
 
 }
 
 
 
 for (int i = 0; i < array.length; i++) { //partition the input array
 
 buckets[(int)((array[i].f - low)/interval)].add(array[i].f);
 
 }
 
 
 int pointer = 0;
 
 for (int i = 0; i < buckets.length; i++) {
 
 Collections.sort(buckets[i]); //mergeSort
 
 for (int j = 0; j < buckets[i].size(); j++) { //merge the buckets
 
 array[pointer].f = buckets[i].get(j);
 
 pointer++;
 
 }
 
}
 
return array;
 
}
}