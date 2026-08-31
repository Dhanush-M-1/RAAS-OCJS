import java.util.Arrays;
import java.util.Scanner;

public class E {
	public static int answer = 0;
	public static int[][] adj;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int len = in.nextInt();
		adj = new int[len][len];
		go(0,0,in);
		gog(0,0,0);
		gor(0,0);
		System.out.println(answer);
	}
	public static int go(int a, int b, Scanner in){
	   b=b>=adj.length?0+(++a)-a:b;
	   a = a<adj.length?a+complete(a,b,in)+go(a,b+1,in):a;
	   return 0;
	}
	public static int gog(int a, int b, int c){
		   c=c>=adj.length?0+(++b)-b:c;
		   b=b>=adj.length?0+(++a)-a:b;
		   a = a<adj.length?a+complete2( c,b,a)+gog(a,b,c+1):a;
		   return 0;
		}
	public static int gor(int a, int b){
	   b=b>=adj.length?0+(++a)-a:b;
	   a = a<adj.length?a+complete3(a,b)+gor(a,b+1):a;
	   return 0;
	}
	public static int complete3(int a, int b){
		answer=adj[a][b]>answer?adj[a][b]:answer;
		return 0;
	}
	public static int complete(int a, int b, Scanner in){
		adj[a][b]=in.nextInt();
		return 0;
	}
	public static int complete2(int a, int b,int c){
		adj[a][b] = Math.min(adj[a][b], adj[a][c]+adj[c][b]);
		return 0;
	}
}
