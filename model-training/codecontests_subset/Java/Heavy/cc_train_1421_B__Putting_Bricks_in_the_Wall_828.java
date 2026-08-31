import java.io.*;
import java.util.*;

public class B {

	
	public static void main(String[] args) throws IOException{
		FastScanner sc = new FastScanner();
		int yo = sc.nextInt();
		while(yo-->0) {
			int n = sc.nextInt();
			char[][] arr = new char[n][n];
			for(int i = 0; i < n; i++) {
				String s = sc.next();
				for(int j = 0; j < n; j++) {
					arr[i][j] = s.charAt(j);
				}
			}
			
			int startRight = arr[0][1]-'0';
			int startDown = arr[1][0]-'0';
			
			int endLeft = arr[n-1][n-2]-'0';
			int endTop = arr[n-2][n-1]-'0';
//			System.out.println(startRight + " " +startDown + " " + endLeft + " " + endTop);
			int count = 0;
			if(startRight == 0 && startDown == 0) {
				if(endLeft == 0) {
					count++;
				}
				if(endTop == 0) {
					count++;
				}
				System.out.println(count);
				if(endLeft == 0) {
					System.out.println((n-1+1) + " " + (n-2+1));
				}
				if(endTop == 0) {
					System.out.println((n-2+1) + " " + (n-1+1));
				}
			}
			
			else if(startRight == 1 && startDown == 1) {
				if(endLeft == 1) {
					count++;
				}
				if(endTop == 1) {
					count++;
				}
				System.out.println(count);
				if(endLeft == 1) {
					count++;
					System.out.println((n-1+1) + " " + (n-2+1));
				}
				if(endTop == 1) {
					count++;
					System.out.println((n-2+1) + " " + (n-1+1));
				}
			}
			else {
				count = 0;
				if((startRight == 0 && startDown == 1)) {
					if((endLeft == 1 && endTop == 0)) {
						System.out.println(2);
						System.out.println(1 + " " + 2);
						System.out.println((n) + " " + (n-1));
					}
					else if((endLeft == 0 && endTop == 1)) {
						System.out.println(2);
						System.out.println(1 + " " + 2);
						System.out.println((n-1) + " " + (n));
					}
					else if((endLeft == 0 && endTop == 0)) {
						System.out.println(1);
						System.out.println(1 + " " + 2);
					}
					else if((endLeft == 1 && endTop == 1)) {
						System.out.println(1);
						System.out.println(2 + " " + 1);
					}
				}
				else if((startRight == 1 && startDown == 0)) {
					if((endLeft == 1 && endTop == 0)) {
						System.out.println(2);
						System.out.println(1 + " " + 2);
						System.out.println((n-1) + " " + (n));
					}
					else if((endLeft == 0 && endTop == 1)) {
						System.out.println(2);
						System.out.println(1 + " " + 2);
						System.out.println((n) + " " + (n-1));
					}
					else if((endLeft == 0 && endTop == 0)) {
						System.out.println(1);
						System.out.println(2 + " " + 1);
					}
					else if((endLeft == 1 && endTop == 1)) {
						System.out.println(1);
						System.out.println(1 + " " + 2);
					}
					
				}
			}
		}
		
//S010
//1001
//1000
//111F
		
		
	}
	
	

	static int mod = 1000000007;
	
	static long pow(int a, int b) {
		if(b == 0) {
			return 1;
		}
		if(b == 1) {
			return a;
		}
		if(b%2 == 0) {
			long ans = pow(a,b/2);
			return ans*ans;
		}
		else {
			long ans = pow(a,(b-1)/2);
			return a * ans * ans;
		}
		
	}
	
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}
	
	static int gcd(int a, int b) {
		return a%b == 0 ? b : gcd(b,a%b);
	}
	
	static boolean[] sieve(int n) {
		
		boolean isPrime[] = new boolean[n+1];
		for(int i = 2; i <= n; i++) {
			if(isPrime[i]) continue;
			for(int j = 2*i; j <= n; j+=i) {
				isPrime[j] = true;
			}
		
		}
		return isPrime;
		
	}
	
//	For Input.txt and Output.txt
	
//	FileInputStream in = new FileInputStream("input.txt");
//	FileOutputStream out = new FileOutputStream("output.txt");
//	PrintWriter pw = new PrintWriter(out);
//	Scanner sc = new Scanner(in);
	
// 	sc.nextLine() 
	

}
