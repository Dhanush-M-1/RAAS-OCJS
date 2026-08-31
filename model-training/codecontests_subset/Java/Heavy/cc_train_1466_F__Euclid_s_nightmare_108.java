/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
     
    // System.out.println("Yes");
    // System.out.println("No");
    //int a[]=new int[n];
    //for(int i=0;i<n;i++)
    //a[i]=sc.nextInt();
//     long a[]=new long[(int)n];
// 		 for(int i=0;i<n;i++)
// 		 a[i]=sc.nextLong();
    //int n=sc.nextInt();
    //long n=sc.nextLong();
    // static int deg[]=new int[200007];
    // static long a[]=new long[200007];
    // static ArrayList<Long> hs=new ArrayList<>();
  //  static Set<Long> hs=new HashSet<>();
 static  int ans[]=new int[500007];
static int f[]=new int[500007];;
static int v[]=new int[500007];
static int tot=0;
static long  p=1;
static int mod =1000000007;
static class Reader 
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
  
        public Reader() 
        { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public String readLine() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
        } 
  
        public int nextInt() throws IOException 
        { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do
            { 
                ret = ret * 10 + c - '0'; 
            }  while ((c = read()) >= '0' && c <= '9'); 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public long nextLong() throws IOException 
        { 
            long ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public double nextDouble() throws IOException 
        { 
            double ret = 0, div = 1; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
  
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
  
            if (c == '.') 
            { 
                while ((c = read()) >= '0' && c <= '9') 
                { 
                    ret += (c - '0') / (div *= 10); 
                } 
            } 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 
  
        private byte read() throws IOException 
        { 
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 
  
        public void close() throws IOException 
        { 
            if (din == null) 
                return; 
            din.close(); 
        } 
    } 
  
 static  int find(int u){
	if(f[u]==u)return u;
	return f[u]=find(f[u]);
}
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
	//	Scanner sc=new Scanner(System.in);
	Reader sc=new Reader();
	PrintWriter out=new PrintWriter(System.out);
// 		int t=sc.nextInt();
// 		while(t-->0) {
		    int n=sc.nextInt();
		   int m=sc.nextInt();
		   for(int i=1;i<=m;i++)f[i]=i;
	
	for(int i=1;i<=n;i++){
		int op;
		op=sc.nextInt();
		if(op==1){
			int u;
			u=sc.nextInt();
			u = find(u);
			if(v[u]>0)continue;
			else {
				v[u]=1;
				p=p*2%mod;
				ans[++tot]=i;
			}
		}
		else {
			int x,y;
			x=sc.nextInt();
			y=sc.nextInt();
			
			x = find(x);
			y = find(y);
			if(x==y)continue;
			else {
				if(v[x]>0&&v[y]>0){
					continue;
				}
				else if(v[x]==0&&v[y]==0){
					f[x]=y;
					p=p*2%mod;
					ans[++tot]=i;
				}
				else {
					f[x]=y;
					v[y]=1;
					p=p*2%mod;
					ans[++tot]=i;
				}
			}
		}
	}
	

out.println(p+" "+tot+" ");
	for(int i=1;i<=tot;i++){
	    out.print(ans[i]+" ");
	
	}


		 out.println();
		 out.flush();
		 out.close();
    
		}
	}
//}
