import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class p036 {
	public static void main(String args[]) throws Exception {
// 		StringTokenizer stok = new StringTokenizer(new Scanner(new File("C:/Users/Arunkumar/Downloads/input.txt")).useDelimiter("\\A").next());
		StringTokenizer stok = new StringTokenizer(new Scanner(System.in).useDelimiter("\\A").next());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(stok.nextToken());
		int[][] p  = new int[][]{{Integer.MIN_VALUE,0},{Integer.MIN_VALUE,0},{Integer.MIN_VALUE,0}};
		for(int i=0;i<n;i++) {
			int pt = Integer.parseInt(stok.nextToken());
			int h = Integer.parseInt(stok.nextToken());
			int[][] c = new int[][] {{pt,0},{pt,0},{pt+h,0}};
			if(p[0][0]<c[0][0]-h) c[0][1] = Math.max(c[0][1], p[0][1]+1);
			if(p[1][0]<c[0][0]-h) c[0][1] = Math.max(c[0][1], p[1][1]+1);
			if(p[2][0]<c[0][0]-h) c[0][1] = Math.max(c[0][1], p[2][1]+1);
			if(p[0][0]<c[1][0]) c[1][1] = Math.max(c[0][1], p[0][1]);
			if(p[1][0]<c[1][0]) c[1][1] = Math.max(c[0][1], p[1][1]);
			if(p[2][0]<c[1][0]) c[1][1] = Math.max(c[0][1], p[2][1]);
			if(p[2][0]<pt) c[2][1] = Math.max(c[2][1], p[2][1]+1);
			c[2][1]= Math.max(c[2][1],p[1][1]+1);
			c[2][1] = Math.max(c[2][1], p[0][1]+1);
			p = c;
		}
		System.out.println(Math.max(Math.max(p[0][1], p[1][1]), p[2][1]));
	}
}