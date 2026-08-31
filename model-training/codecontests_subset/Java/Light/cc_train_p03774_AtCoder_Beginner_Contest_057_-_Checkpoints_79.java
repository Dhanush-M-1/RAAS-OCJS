import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] px = new int[n];
		int[] py = new int[n];
		int[] cx = new int[m];
		int[] cy = new int[m];
		int dist1;
		for(int i=0;i<n;i++) {
			px[i] = sc.nextInt();
			py[i] = sc.nextInt();
		}
		for(int i=0;i<m;i++) {
			cx[i] = sc.nextInt();
			cy[i] = sc.nextInt();
		}
		
		for(int i=0;i<n;i++) {
			int idx = 0;
			dist1=dist(px[i],py[i],cx[0],cy[0]);
			for(int k=0;k<m;k++) {
				if(dist(px[i],py[i],cx[k],cy[k])<dist1) {
					idx=k;
					dist1=dist(px[i],py[i],cx[k],cy[k]);
				}
			}
			System.out.println(idx+1);
		}
	}
	
	static int dist(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

}
