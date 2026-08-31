import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;



 
public class george
{
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
 static int max(int a[],int n) {
	 int max=a[0];
	 int ind=0;
	 for(int i=1;i<n;i++) {
		 if(a[i]>=max) {
			 max=a[i];
			 ind=i;
		 }
	 }
	 return ind;
 }
 static int min(int a[],int n) {
	 int min=a[0];
	 int ind=0;
	 for(int i=1;i<n;i++) {
		 if(a[i]<min) {
			 min=a[i];
			 ind=i;
		 }
	 }
	 return ind;
 }
 static boolean fun(int i) {
	 for(int j=3;j<=20;j++) {
		 if(i%j!=0) {
			 return false;
		 }
	 }
	 return true;
 }
 static int bin(int arr[], int l, int r, int x)
 {
     if (r>=l)
     {
         int mid = l + (r - l)/2;

       
         if (arr[mid] == x)
            return mid;

       
         if (arr[mid] > x)
            return bin(arr, l, mid-1, x);
         return bin(arr, mid+1, r, x);
     }


     return -1;
 }
 static boolean isPalindrome(int n)
 {   
     
     int divisor = 1;
     while (n / divisor >= 10)
         divisor *= 10;
   
     while (n != 0)
     {
         int leading = n / divisor; 
         int trailing = n % 10;
   
         if (leading != trailing)  
             return false;
   
         n = (n % divisor) / 10;
   
         divisor = divisor / 100;
     }
     return true;
 }
    public static void main(String[] args) throws IOException
    {
        Reader s=new Reader();
        int n = s.nextInt();
        int k = s.nextInt();
        int ar[]=new int[n];
        int ans = 0;
        for(int i=0;i<n;i++) {	
        	ar[i]=s.nextInt();
        }
          for(int i=0;i<n;i++) {
        	
        	
        	k-=(i+1);
        	if(k<=0) {
        		ans =k+i;
        		break;
        	}
        }
       
        System.out.println(ar[ans]);
    }
}