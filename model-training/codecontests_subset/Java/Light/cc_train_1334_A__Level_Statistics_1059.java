import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for(int a=0;a<t;a++) {
			int n = s.nextInt();
			int[] arr = new int[n];
			int[] arr2 = new int[n];
			
			int p1 = 0, p2 = 0;
			
			boolean ans = true;
			for(int i=0;i<n;i++) {
				int x1 = s.nextInt();
				int x2 = s.nextInt();
				
				if(x1 < x2 || x1 < p1 || x2 < p2 || (x1 - p1) < (x2 - p2)) {
					ans = false;
				}
				
				p1 = x1;
				p2 = x2;
			}
			
			if(ans)
				System.out.println("YES");
			else
				System.out.println("NO");
			
		}

	}

}
