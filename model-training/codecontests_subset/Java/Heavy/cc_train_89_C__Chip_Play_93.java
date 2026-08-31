import java.util.Arrays;
import java.util.Scanner;


public class Main{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int r =  scn.nextInt();
		int c = scn.nextInt();
		
		char[][] a = new char[r][c];
		int[][] D = new int[r][c];
		int[][] U = new int[r][c];
		int[][] L = new int[r][c];
		int[][] R = new int[r][c];
		int[] h = new int[c];
		
		Arrays.fill(h, -1);
		
		for(int i = 0; i < r; i++){
			a[i] = scn.next().toCharArray();
			int k = -1;
			for(int j = 0; j < c; j++){
				if(a[i][j] != '.'){
					L[i][j] = k;
					if(k != -1)R[i][k] = j; 
					
					U[i][j] = h[j];
					if(h[j] != -1)D[h[j]][j] = i;
					
					k = j;
					h[j] = i; 
				}
			}
			if(k!=-1) R[i][k] = -1;
		}
		for(int j=0; j < c; j++ )
	        if(h[j]!=-1) D[h[j]][j] = -1;
		
		for(int i = 0; i < r; i++)
			for(int j = 0; j < c; j++)
				if(a[i][j] != '.')
					dfs(i, j, 0, U, D, L, R, a);
		
		System.out.println(max+" "+count);
	}

	static int max = 0;
	static int count = 0; 
	private static void dfs(int i, int j, int k, int[][] U, int[][] D, int[][] L, int[][] R, char[][] a) {
		if(i == -1 || j == -1){
			if(k > max){
				max = k;
				count = 1;
			}else if(k == max){
				count++;
			}
			return ;
		}
		
		delete(i, j, U, D, L, R);
		if(a[i][j] == 'D')
			dfs(D[i][j], j, k+1, U, D, L, R, a);
		else if(a[i][j] == 'U')
			dfs(U[i][j], j, k+1, U, D, L, R, a);
		else if(a[i][j] == 'L')
			dfs(i, L[i][j], k+1, U, D, L, R, a);
		else if(a[i][j] == 'R')
			dfs(i, R[i][j], k+1, U, D, L, R, a);
		Insert(i, j, U, D, L, R);
	}
	private static void Insert(int i, int j, int[][] U, int[][] D, int[][] L,
			int[][] R) {
	    if(R[i][j]!=-1) L[i][R[i][j]] = j;
	    if(L[i][j]!=-1) R[i][L[i][j]] = j;
	    if(U[i][j]!=-1) D[U[i][j]][j] = i;
	    if(D[i][j]!=-1) U[D[i][j]][j] = i;	
	}
	private static void delete(int i, int j, int[][] U, int[][] D, int[][] L, int[][] R) {
		if(R[i][j]!=-1) L[i][R[i][j]] = L[i][j];
	    if(L[i][j]!=-1) R[i][L[i][j]] = R[i][j];
	    if(U[i][j]!=-1) D[U[i][j]][j] = D[i][j];
	    if(D[i][j]!=-1) U[D[i][j]][j] = U[i][j];
	}
}