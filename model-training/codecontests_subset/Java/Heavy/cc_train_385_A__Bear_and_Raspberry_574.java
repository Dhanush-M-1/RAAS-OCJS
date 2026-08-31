
import java.io.*;
import java.util.*;
public class Solution {
		static int MAX = (int)1e5+1;
		static int ans = Integer.MAX_VALUE;
		static boolean vis[][];
		static int arr[][];
		static ArrayList<String> list = new ArrayList<>();
		public static void main(String[] args)throws Exception{
			//InputReader input = new InputReader(System.in);
			Scanner input = new Scanner(System.in);
			OutputStreamWriter out = new OutputStreamWriter(System.out);
			int n = input.nextInt();
			int c = input.nextInt();
			int arr[] = new int[n];
			for(int i =0;i<n;i++)arr[i] = input.nextInt();
			int res =0;
			for(int i =0;i<n-1;i++) {
				if(arr[i]>arr[i+1]) res = Math.max(res,arr[i]-arr[i+1]-c);
				//else res = Math.max(res, arr[i+1]-arr[i]-c);
			}
			System.out.println(res);
			
			
		}
		public static boolean solve(int x,int y,int tx,int ty) {
			if(x<0 || y<0 || x>=arr.length || y>=arr[0].length || vis[x][y] ||arr[x][y] == -1)return false;
			vis[x][y] = true;
			if(x == tx && y == ty)return true;
			return solve(x-1,y,tx,ty)||
					solve(x+1,y,tx,ty)||
					solve(x,y+1,tx,ty)||
					solve(x,y-1,tx,ty)||
					solve(x-1,y-1,tx,ty)||
					solve(x-1,y+1,tx,ty)||
					solve(x+1,y+1,tx,ty)||
					solve(x+1,y-1,tx,ty);
		}
		public static void construct(int a,int b,int arr[][]) {
			arr[a][b] = -1;
			int x = a,y=b;
			while(x>=0)arr[x--][b] = -1;
			x= a;
			while(x<arr.length)arr[x++][b] = -1;
			y =b;
			while(y<arr[0].length)arr[a][y++] = -1;
			y = b;
			while(y>=0)arr[a][y--] = -1;
			x = a;y=b;
			while(x>=0 && y>=0)arr[x--][y--] = -1;
			x = a;y=b;
			while(x>=0 && y<arr[0].length)arr[x--][y++] = -1;
			x=a;y=b;
			while(x<arr.length && y<arr[0].length)arr[x++][y++] = -1;
			x=a;y=b;
			while(x<arr.length && y>=0)arr[x++][y--] = -1;
		}
		public static int gcd(int a,int b) {
			return b==0? a:gcd(b,a%b);
		}
		public static boolean isPalindrome(int hh,int mm) {
			String s= "";
			if(hh<10)s+="0";
			s+=hh;
			if(mm<10)s+="0";
			s+=mm;
			int l =0;
			int r = s.length()-1;
			while(l<r){
				if(s.charAt(l)!= s.charAt(r))return false;
				l++;
				r--;
			}
			return true;
		}
		
		public static void sort(int arr[]) {
			ArrayList<Integer>list = new ArrayList<>();
			for(int it:arr)list.add(it);
			Collections.sort(list);
			for(int i =0;i<arr.length;i++)arr[i] = list.get(i);
		}
		public static void swap(int a,int b,int arr[]){
			int t = arr[a];
			arr[a]= arr[b];
			arr[b] = t;
		}
		
}
class Pair{
	int x,y;
	public Pair(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
class InputReader {
	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
	private SpaceCharFilter filter;
	
	public InputReader(InputStream stream) {
		this.stream = stream;
	}
	
	public int read() {
		if (numChars == -1) {
			throw new InputMismatchException();
		}
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars <= 0) {
				return -1;
			}
		}
		return buf[curChar++];
	}
	
	public int readInt() {
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
			if (c < '0' || c > '9') {
				throw new InputMismatchException();
			}
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}
	
	public String readString() {
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
	
	public double readDouble() {
		int c = read();
		while (isSpaceChar(c)) {
			c = read();
		}
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		double res = 0;
		while (!isSpaceChar(c) && c != '.') {
			if (c == 'e' || c == 'E') {
				return res * Math.pow(10, readInt());
			}
			if (c < '0' || c > '9') {
				throw new InputMismatchException();
			}
			res *= 10;
			res += c - '0';
			c = read();
		}
		if (c == '.') {
			c = read();
			double m = 1;
			while (!isSpaceChar(c)) {
				if (c == 'e' || c == 'E') {
					return res * Math.pow(10, readInt());
				}
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				m /= 10;
				res += (c - '0') * m;
				c = read();
			}
		}
		return res * sgn;
	}
	
	public long readLong() {
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
			if (c < '0' || c > '9') {
				throw new InputMismatchException();
			}
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}
	
	public boolean isSpaceChar(int c) {
		if (filter != null) {
			return filter.isSpaceChar(c);
		}
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}
	
	public String next() {
		return readString();
	}
	
	public interface SpaceCharFilter {
		public boolean isSpaceChar(int ch);
	}
}
