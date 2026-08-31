                //Arrays.fill(l,i);
import java.io.IOException;
import java.io.InputStreamReader; 
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.io.DataInputStream; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.util.ArrayList;
import java.util.Scanner; 
import java.util.StringTokenizer; 
import java.util.*;
import java.io.*;
import java.math.*;

public final class AnkushJavaTemplate{ 
    static class FastReader { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
  
        public FastReader() 
        { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public FastReader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 

        //Method to read String values
        public String nextLine() throws IOException 
        { 
            byte[] buf = new byte[1000000]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt).trim(); 
        } 

        //Method to read Integer values
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

        //Method to read Long values
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

        //Method to read Double data type values
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
    int[] radixSort(int[] f){
        int[] to = new int[f.length];
        {
            int[] b = new int[65537];
            for(int i = 0;i < f.length;i++)b[1+(f[i]&0xffff)]++;
            for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
            for(int i = 0;i < f.length;i++)to[b[f[i]&0xffff]++] = f[i];
            int[] d = f; f = to;to = d;
        }
        {
            int[] b = new int[65537];
            for(int i = 0;i < f.length;i++)b[1+(f[i]>>>16)]++;
            for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
            for(int i = 0;i < f.length;i++)to[b[f[i]>>>16]++] = f[i];
            int[] d = f; f = to;to = d;
        }
        return f;
    }
    int phi(long n){ 
        long result = n;  
      
        // Consider all prime factors of n and subtract their multiples from result 
        for (long p = 2L; p * p <= n; ++p) { 
              
            // Check if p is  a prime factor. 
            if (n % p == 0)  { 
                  
                // If yes, then update n and result 
                while (n % p == 0) 
                    n /= p; 
                result -= result / p; 
            } 
        } 
    
        // If n has a prime factor greater than sqrt(n)  (There can be at-most one such prime factor) 
        if (n > 1) 
            result -= result / n; 
        return (int)result; 
    }
    void shuffleArray(int[] arr){
        int n = arr.length;
        Random rnd = new Random();
        for(int i=0; i<n; ++i){
            int tmp = arr[i];
            int randomPos = i + rnd.nextInt(n-i);
            arr[i] = arr[randomPos];
            arr[randomPos] = tmp;
        }   
    }
    long modInverse(long a, long m) { 
        long g = gcd(a, m); 
        if (g != 1) 
            return -1; 
        else 
        { 
            // If a and m are relatively prime, then modulo inverse is a^(m-2) mode m 
            return modpower(a, m - 2, m); 
        } 
        //return 0;
    } 
    boolean isPowerOfTwo (long x) { 
        // First x in the below expression is for the case when x is 0 
        return x!=0 && ((x&(x-1)) == 0);     
    } 
    long nextPowerOf2(long n) { 
        n--; 
        n |= n >> 1; 
        n |= n >> 2; 
        n |= n >> 4; 
        n |= n >> 8; 
        n |= n >> 16; 
        n |= n >> 32;
        //n |= n >> 64;
        n++; 
        return n; 
    }
    public long lcm_of_array_elements(long[] element_array) 
    { 
        long lcm_of_array_elements = 1; 
        long divisor = 2; 
          
        while (true) { 
            long counter = 0; 
            boolean divisible = false; 
              
            for (int i = 0; i < element_array.length; i++) { 
  
                // lcm_of_array_elements (n1, n2, ... 0) = 0. For negative number we convert into positive and calculate lcm_of_array_elements. 
  
                if (element_array[i] == 0) { 
                    return 0; 
                } 
                else if (element_array[i] < 0) { 
                    element_array[i] = element_array[i] * (-1); 
                } 
                if (element_array[i] == 1) { 
                    counter++; 
                } 
  
                // Divide element_array by devisor if complete division i.e. without remainder then replace  number with quotient; used for find next factor 
                if (element_array[i] % divisor == 0) { 
                    divisible = true; 
                    element_array[i] = element_array[i] / divisor; 
                } 
            } 
  
            // If divisor able to completely divide any number from array multiply with lcm_of_array_elements and store into lcm_of_array_elements and 
            // continue to same divisor for next factor finding. else increment divisor 
            if (divisible) { 
                lcm_of_array_elements = lcm_of_array_elements * divisor; 
            } 
            else { 
                divisor++; 
            } 
  
            // Check if all element_array is 1 indicate  we found all factors and terminate while loop. 
            if (counter == element_array.length) { 
                return lcm_of_array_elements; 
            } 
        } 
    } 

    // return gcd of 2 numbers
    long gcd(long a, long b) 
    { 
        if (a == 0) 
            return b; 
        return gcd(b % a, a); 
    } 
  
    // Function to find gcd of array of numbers 
    long arrayGCD(long arr[], long n) 
    { 
        long result = arr[0]; 
        for (int i = 1; i < n; i++) 
            result = gcd(arr[i], result); 
  
        return result; 
    }
    long lcm(long a, long b) 
    { 
        return (a*b)/gcd(a, b); 
    } 
    long modpower(long x, long y, long p) { 
        // Initialize result 
        long res = 1;      
         
        // Update x if it is more than or equal to p 
        x = x % p;  
      
        while (y > 0) 
        { 
            // If y is odd, multiply x with result 
            if((y & 1)==1) 
                res = (res * x) % p; 
      
            // y must be even now; y = y / 2 
            y = y >> 1;  
            x = (x * x) % p;  
        } 
        return res; 
    } 
    int binarySearch(int arr[], int x) 
    { 
        int l = 0, r = arr.length - 1; 
        while (l <= r) { 
            int m = l + (r - l) / 2; 
            // Check if x is present at mid 
            if (arr[m] == x) 
                return m; 
            // If x greater, ignore left half 
            if (arr[m] < x) 
                l = m + 1; 
            // If x is smaller, ignore right half 
            else
                r = m - 1;
        } 
        // if we reach here, then element was not present 
        return -1; 
    } 
    int rightMostIndex(int arr[], int target){
        int l = 0;
        int r = arr.length;
        while(l<r){
            int mid = (l+r)/2;
            if(target<arr[mid])
                r = mid;
            else 
                l = mid+1;
        }
        return l;
    }
    int leftMostIndex(long arr[], long target){
        int l = 0;
        int r = arr.length;
        while(l<r){
            int mid = (l+r)/2;
            if(arr[mid]<target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
    HashMap<Character,Integer> Counter(char arr[]){
        HashMap<Character,Integer> hash = new HashMap<>();
        for(char i: arr){
            hash.put(i,hash.getOrDefault(i,0)+1);
        }
        return hash;
    }
    int[] sieveOfEratosthenes(int n) 
    { 
        // Create a boolean array "prime[0..n]" and initialize all entries it as true. A value in prime[i] will 
        // finally be false if i is Not a prime, else true. 
        boolean prime[] = new boolean[n+1]; 
        for(int i=0;i<=n;i++) 
            prime[i] = true; 
        int cnt = 0;
        for(int p = 2; p*p <=n; p++) 
        { 
            // If prime[p] is not changed, then it is a prime 
            if(prime[p] == true) 
            { 
                // Update all multiples of p 
                for(int i = p*p; i <= n; i += p) 
                    prime[i] = false; 
            } 
        } 
        // Print all prime numbers 
        for(int i = 2; i <= n; i++) 
        { 
            if(prime[i] == true) {
                cnt++;
                //System.out.print(i + " "); 
            }
        }
        int arr[] = new int[cnt];
        int j = 0;
        System.out.println("cnt is = "+cnt);
        for(int i = 2; i <= n; i++) 
        { 
            if(prime[i] == true) {
                arr[j++]=i;
                //System.out.print(i + " "); 
            }
        }
        return arr;
    }
    // **** Segment tree Code by Ankush Sharma written from scratch **** //
    
    int tree[]; // This is the Segment tree, initially it has size 0, and later we will allocate the memory according to our requirements 
    
    // This update is used to update only a value at particular index
    void update(int arr[], int node, int index, int val, int start, int end){
        if(start == end){
            arr[start] += val; // arr[index] += val;
            tree[node] += val;
        }
        else{
            int mid = (start + end) / 2;
            if(start <= index && index <= mid)
                update(arr, 2*node+1, index, val, start, mid);
            else
                update(arr, 2*node+2, index, val, mid+1, end);
        }
        tree[node] = tree[2*node+1] + tree[2*node+2];
    }
    //This is the method to build the Segment tree, first process in order to perform operations
    void build(int arr[], int pos, int l, int r){
        if(l==r)
            tree[pos] = arr[l];
        else{
            int mid = (l+r)/2;
            build(arr, 2*pos+1, l, mid);
            build(arr, 2*pos+2, mid+1, r);
            tree[pos] = tree[2*pos+1] + tree[2*pos+2];
        }
    }
    // start and end are the starting and ending index of Segment tree 
    // l and r are the range of queries
    // This is the method to return the result of range queries it can be changed according to the operations to be perform
    int query(int node, int start, int end, int l, int r){
        if(r < start || l > end)
            return 0;
        if(l <= start && r >= end)
            return tree[node];
        int mid = (start + end) / 2;
        int ans1 = query(2*node+1, start, mid, l, r);
        int ans2 = query(2*node+2, mid+1, end, l, r);
        return ans1 + ans2;
    } 
    boolean isprime(long n){
        if(n==2 || n==3)
            return true;
        if(n%2==0 || n%3==0 || n<=1)
            return false;
        long x=5;
        while(x*x<=n){
            if(n%x==0 || n%(x+2)==0)
                return false;
            x+=6;
        }
        return true;
    }
    ArrayList<Long> fact(long n){
        ArrayList<Long> arr = new ArrayList<Long>();
        long x = 1;
        while(x*x<=n){
            if(n%x==0)
                arr.add(x);
            if(n/x!=x && n%(n/x)==0)
                arr.add(n/x);
            x+=1;
        }
        return arr;
    }
    /*
    int x = (int) Math.ceil(Math.log(n)/Math.log(2));
        int maxSize = 2*(int)Math.pow(2, x)-1;
        size = maxSize;
    */
    void solve() throws Exception{
        int n = read.nextInt();
        long arr[][] = new long[n][2];
        for(int i = 0; i < n; i++){
            arr[i][0] = read.nextLong();
            arr[i][1] = read.nextLong();
        }
        if(n==1){
            System.out.println(1);
            System.exit(0);
        }
        int ans = 1;
        for(int i = 1; i < n; i++){
            if(i<n-1 && arr[i][0]-arr[i][1]>arr[i-1][0])
                ans++;
            else if(i < n - 1 && arr[i][0] + arr[i][1] < arr[i + 1][0]){
                ans++;
                arr[i][0] += arr[i][1];
            }
            //System.out.println("ans = "+ans);
        }
        System.out.print(ans+1);
    }
    FastReader read=new FastReader();
    public static void main(String[] args) throws Exception { 
    	new AnkushJavaTemplate().solve();
    } 
} 