import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
public  class Exam {
	public static long mod = (long)Math.pow(10, 9)+7 ;
	public static double epsilon=0.00000000008854;//value of epsilon
	public static InputReader sc = new InputReader(System.in);
	public static PrintWriter pw = new PrintWriter(System.out);
	public static int sort(int arr[],int r) 
    { 
        int n = arr.length; 
  
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i); 
		int c=0;
        // One by one extract an element from heap 
        for (int i=n-1; i>=0; i--) 
        { 
            // Move current root to end 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
			if(temp-c*r>0){
				c++;
			}
			else{
				break;
			}
            // call max heapify on the reduced heap 
            heapify(arr, i, 0); 
		}
		return c;
    }
  
    // To heapify a subtree rooted with node i which is 
    // an index in arr[]. n is size of heap 
	public static void heapify(int arr[], int n, int i) 
    { 
        int largest = i; // Initialize largest as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        // If largest is not root 
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  
            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest); 
        } 
	} 
	public static int countSet(int a){
		int c=0;
		while(a>0){
			a&=(a-1);
			c++;
		}
		return c;
	}
	public static long pow(long x, long n, long M) {
		long result = 1;
		while (n > 0) {
			if (n % 2 == 1)
				result = (result * x) % M;
			x = (x * x) % M;
			n = n / 2;
		}
		return result;
	}
	public static void main(String[] args) {
		// code starts..
		StringBuilder out=new StringBuilder();
		int q=sc.nextInt();
		while(q-->0){
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			int co=Math.min(b, c/2);
			int s=3*co;
			b-=co;
			co=Math.min(a,b/2);
			s+=3*co;
			pw.println(s);
		}

		// Code ends...
		pw.flush();
		pw.close();
	}
	static class tripletL implements Comparable<tripletL> {
		Long x, y, z;

		tripletL(long x, long y, long z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public int compareTo(tripletL o) {
			int result = x.compareTo(o.x);
			if (result == 0)
				result = y.compareTo(o.y);
			if (result == 0)
				result = z.compareTo(o.z);

			return result;
		}

		public boolean equlas(Object o) {
			if (o instanceof tripletL) {
				tripletL p = (tripletL) o;
				return (x - p.x == 0) && (y - p.y ==0 ) && (z - p.z == 0);
			}
			return false;
		}

		public String toString() {
			return x + " " + y + " " + z;
		}

		public int hashCode() {
			return new Long(x).hashCode() * 31 + new Long(y).hashCode() + new Long(z).hashCode();
		}
	}
	public static String Doubleformate(double a){
		DecimalFormat f =new DecimalFormat("#.00");
		return f.format(a);
	}
 
	public static Comparator<Integer[]> column(int i){
		return 
		new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
					Integer quantityOne = o1[i];
				Integer quantityTwo = o2[i];
				return quantityOne.compareTo(quantityTwo);
			}
		};
	}
	public static Comparator<Long[]> Triplet(){
		return 
		new Comparator<Long[]>() {
			@Override
			public int compare(Long[] o1, Long[] o2) {
					int result=o1[0].compareTo(o2[0]);
					if(result==0)
					result=o1[1].compareTo(o2[1]);
					if(result==0)
					result=o1[2].compareTo(o2[2]);
					return result;
			}
		};
	}
	
	
	public static String reverseString(String s){
		StringBuilder input1 = new StringBuilder(); 
        input1.append(s);  
		input1 = input1.reverse();
		return input1.toString();
	}
	public static int[] scanArray(int n){
		int a[]=new int [n];
		for(int i=0;i<n;i++)
		a[i]=sc.nextInt();
 
		return a;
	}
	public static long[] scanLongArray(int n){
		long a[]=new long [n];
		for(int i=0;i<n;i++)
		a[i]=sc.nextLong();
 
		return a;
	}
	public static String [] scanStrings(int n){
		String a[]=new String [n];
		for(int i=0;i<n;i++)
		a[i]=sc.nextLine();
 
		return a;
	}
	static class InputReader {
 
		private final InputStream stream;
		private final byte[] buf = new byte[8192];
		private int curChar, snumChars;
		private SpaceCharFilter filter;
 
		public InputReader(InputStream stream) {
			this.stream = stream;
		}
 
		public int snext() {
			if (snumChars == -1)
				throw new InputMismatchException();
			if (curChar >= snumChars) {
				curChar = 0;
				try {
					snumChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (snumChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}
 
		public int nextInt() {
			int c = snext();
			while (isSpaceChar(c)) {
				c = snext();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = snext();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
 
		public long nextLong() {
			int c = snext();
			while (isSpaceChar(c)) {
				c = snext();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = snext();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
 
		public int[] nextIntArray(int n) {
			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
 
		public String readString() {
			int c = snext();
			while (isSpaceChar(c)) {
				c = snext();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = snext();
			} while (!isSpaceChar(c));
			return res.toString();
		}
 
		public String nextLine() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = snext();
			} while (!isEndOfLine(c));
			return res.toString();
		}
 
		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
 
		private boolean isEndOfLine(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}
 
		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}
 
}