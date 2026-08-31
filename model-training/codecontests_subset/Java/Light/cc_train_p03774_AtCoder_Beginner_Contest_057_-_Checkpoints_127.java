import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
      	int m = scn.nextInt();
		int[][] a = new int[n][2];
		for(int i=0; i<n; i++){
          for(int j=0; j<2; j++){
			a[i][j] = scn.nextInt();
          }
		}
      	int[][] c = new int[m][2];
		for(int i=0; i<m; i++){
          for(int j=0; j<2; j++){
			c[i][j] = scn.nextInt();
          }
		}
      	for(int i=0; i<n; i++) {
    		int min = Integer.MAX_VALUE;
    		int min2 = 0;
    		for(int j=0; j<m; j++) {
      			int x =  Math.abs(a[i][0]-c[j][0])+Math.abs(a[i][1]-c[j][1]);
      			if(x<min) {
        			min = x;
        			min2 = j;
      			}
    		}
    		System.out.println(min2 + 1);
        }
	}
}
