import java.util.Scanner;

public class ProblemC {
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		long n = sc.nextLong();
		long p = sc.nextLong();
		int w = sc.nextInt();
		int d = sc.nextInt();
		
		//int i=0;
		long x, y, z;
		 
		 
		for(y=0; y<w; y++) {
			if(((p-y*d)%w)==0 && (p-y*d)/w + y <= n) {
				x = ((p-y*d)/w);
				z = n - x - y;
				if(x>=0 && y>=0 && z>=0) {
					System.out.println(x + " " + y + " " + z);
					return;
				}
				else continue;
			}
		}
		System.out.println(-1);
	}
}
