//Author: Mo Abjal, MJP Rohilkhand University Bareilly, UP, India 2018.
// NSR - E-Card
import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
public class Main{
	public static StringTokenizer token = new StringTokenizer("");
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static PrintWriter output = new PrintWriter(System.out);
	public static void main(String[] args) throws Exception {		
		int N = ni();
		int K = ni();
		Integer A[] = ai(N);
		Arrays.sort(A);
		//for(int i=0;i<N;i++) output.print(A[i]+" "); output.println();
		long count = Math.abs(K-A[N/2]);
		for(int i=N/2+1;i<N;i++){
			if(A[i]<K) count = count + K-A[i];
			if(A[N-i-1]>K) count = count + A[N-i-1]-K;
		}
		output.println(count);
		output.close();
		/*char A[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		int N = ni();
		String data = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String digit = "0123456789";
		StringBuilder sb = new StringBuilder("");
		StringBuilder temp = new StringBuilder("");		
		StringBuilder col = new StringBuilder("");
		boolean flag = true;		
		for(int i=0;i<N;i++){
			sb = sb.append(ns());
			for(int j=0;j<sb.length();j++){
				if(data.contains(Character.toString(sb.charAt(j))) && flag==true){
					temp.append(Character.toString(sb.charAt(j)));
				}
				else{
					flag = false;
					
				}
			}
		}*/
	}
	//Scanning Inputs and Converting data library
	//Parse Integer
	public static Integer pi(String str){
		return Integer.parseInt(str);
	}
	//Parse Long
	public static Long pl(String str){
		return Long.parseLong(str);
	}
	//Converting Integer into String
	public static String ps(Integer N){
		return Integer.toString(N);
	}
	//Taking Integer Input
	public static Integer ni() throws IOException{
		if(!token.hasMoreElements()){
			token = new StringTokenizer(br.readLine());
		}
		return Integer.parseInt(token.nextToken());
	}
	//Taking Long Input
	public static Long nl() throws IOException{
		if(!token.hasMoreElements()){
			token = new StringTokenizer(br.readLine());
		}
		return Long.parseLong(token.nextToken());
	}
	//Taking String Input
	public static String ns() throws IOException{
		return new StringTokenizer(br.readLine()).nextToken();
	}
	//Taking Integer Array
	public static Integer[] ai(int N) throws IOException{
		Integer A[] = new Integer[N];
		token = new StringTokenizer(br.readLine());
		for(int i=0;i<A.length;i++){
			A[i] = pi(token.nextToken());
		}
		return A;
	}
	//Taking Long Array
	public static long[] al(int N) throws IOException{
		long A[] = new long[N];
		token = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			A[i] = Long.parseLong(token.nextToken());
		}
		return A;
	}
	//Taking 2D Char Array
	public static char[][] acc(int N,int M) throws IOException{
		char C[][] = new char[N][M];
		for(int i=0;i<N;i++){
			token = new StringTokenizer(br.readLine());
			String s = token.nextToken();
			for(int j=0;j<M;j++){
				C[i][j] = s.charAt(j);
			}
		}
		return C;
	}
	//Taking String Array
	public static String[] as(int N) throws IOException{
		String S[] = new String[N];
		token = new StringTokenizer(br.readLine());
		for(int i=0;i<S.length;i++){
			S[i] = token.nextToken();
		}
		return S;
	}

	//Calculating factorial
	public static long fact(long N){
		long fact = 1;
		for(int i=1;i<=N;i++){
			fact = fact * i;
		}
		return fact;
	}
	public static BigInteger factB(int N){
		BigInteger b = new BigInteger("1");
		for(int i=1;i<=N;i++){
			b = b.multiply(BigInteger.valueOf(i));
		}
		return b;
	}
	//Making Paares of given size
	public static long mp(long N,long size){
		long mul=1;
		long temp = N;
		for(long i=N;i>N-size;i--){
			mul = mul*temp--;
		}
		long fact = fact(size);
		if(mul/fact==0) return 1;
		return mul/fact;
	}
	public static long sod(long N){
		long sum = 0;
		while(N>0){
			long x = N%10;
			sum = sum + x;
			N = N/10;
		}
		return sum;
	}
}



//Copyright Reserved - Mo Abjal.