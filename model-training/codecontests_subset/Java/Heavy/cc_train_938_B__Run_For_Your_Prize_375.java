import java.io.*;
import java.math.*;
import java.util.*;
 
public class practice {
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
            byte[] buf = new byte[100001]; // line length 
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
	public static void debug(int[][] arr) {
		int r = arr.length;
		int c = arr[0].length;
		int i,j;
		for(i=0;i<r;++i) {
			for(j=0;j<c;++j)  System.err.print(arr[i][j]+" ");
			System.err.println();
		}
	}
	public static void debug(long[][] arr) {
		int r = arr.length;
		int c = arr[0].length;
		int i,j;
		for(i=0;i<r;++i) {
			for(j=0;j<c;++j)  System.err.print(arr[i][j]+" ");
			System.err.println();
		}
	}
	public static void debug(int ...var) {
		for(int i:var)  System.err.print(i+" ");
		System.err.println();
	}
	public static void debug(String ...var) {
		for(String i:var)  System.err.print(i+" ");
		System.err.println();
	}
	public static void debug(double ...var) {
		for(double i:var)  System.err.print(i+" ");
		System.err.println();
	}
	
	public static void debug(long ...var) {
		for(long i:var)  System.err.print(i+" ");
		System.err.println();
	}

    public static void main(String args[]) throws Exception{
        Reader scan = new Reader();
        //be careful of readLine() length of string;
        //Scanner scan = new Scanner(System.in);
		//scan.useDelimiter("");  // for reading character by character

        int n=scan.nextInt();
        int[] positions = new int[n];
        for(int i=0;i<n;++i) {
            positions[i]=scan.nextInt();
        }
        int l=0;
        int r=n;
        int val = 500000;
        while(l<r) {
            int mid = l+((r-l)>>1);
            if(positions[mid]>val) {
                r=mid;
            } else {
                l=mid+1;
            }
        }
        int y=(r!=n)?positions[r]:1000000;
        int x=(r!=0)?positions[r-1]:0;
        int time = Math.max(x-1,1000000-y);
        System.out.println(time);
        scan.close();

    }
}