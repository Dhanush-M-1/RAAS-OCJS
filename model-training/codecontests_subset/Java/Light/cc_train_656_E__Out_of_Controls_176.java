import java.util.*;

public class E {
	static int max;
	public static void main(String[] args) {
		
		
		Scanner qwe = new Scanner(System.in);
		
		int N = qwe.nextInt();
		int[][] a =new int[N][N];
		
		fill(qwe,0,0,a);
		
		floyd(0,0,0,a);
		
		max = 0;
		
		getmax(0,0,a);
		
		System.out.println(max);
		
		qwe.close();
		
	}
	
	static int fill(Scanner qwe, int r, int c, int[][] a){
		
		c = (c == a[0].length ? r+1-(r = r+1) : c);
		
		int fa = (r < a.length ? (a[r][c]= qwe.nextInt()) + fill(qwe,r,c+1,a) : -1);
		return fa;
	}
	
	static int floyd(int k, int i, int j, int[][] a){
		
		j = (j == a.length ? i+1-(i = i+1) : j);
		i = (i == a.length ? k+1-(k = k+1) : i);
		
		return (k < a.length ?  (a[i][j] > a[i][k] + a[k][j] ? a[i][j] = a[i][k] + a[k][j] : a[i][j]) + floyd(k,i,j+1,a) : -1);
		
	}
	
	static int getmax(int r, int c, int[][] a){
		c = (c == a[0].length ? r+1-(r = r+1) : c);
		
		int fa = (r < a.length ? (max = Math.max(max, a[r][c])) +getmax(r,c+1,a) : -1);
		return fa;
		
	}

}
