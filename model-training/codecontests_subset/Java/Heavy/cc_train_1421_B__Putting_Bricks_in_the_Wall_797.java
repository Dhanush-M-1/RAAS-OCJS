import java.util.*;

public class b {

	public static void main(String[] args) {
	
		Scanner stdin = new Scanner(System.in);
		int nC = stdin.nextInt();
		for (int loop=0; loop<nC; loop++) {
			int n = stdin.nextInt();
			char[][] g = new char[n][];
			for (int i=0; i<n; i++)
				g[i] = stdin.next().toCharArray();
			
			int tZ = 0;
			if (g[0][1] == '0') tZ++;
			if (g[1][0] == '0') tZ++;
			
			int bZ = 0;
			if (g[n-2][n-1] == '0') bZ++;
			if (g[n-1][n-2] == '0') bZ++;
			
			//System.out.println(tZ+" and "+bZ);
			
			if ((tZ == 0 && bZ == 0) || (tZ == 2 && bZ == 2)) {
				System.out.println(2);
				System.out.println("1 2");
				System.out.println("2 1");
			}
			else if (tZ == 0 && bZ == 1) {
				System.out.println(1);
				if (g[n-2][n-1] == '1')
					System.out.println((n-1)+" "+(n));
				else
					System.out.println((n)+" "+(n-1));
			}
			else if ((tZ == 0 && bZ == 2) || (tZ == 2 && bZ == 0))
				System.out.println(0);
			else if (tZ == 1 && bZ == 0) {
				System.out.println(1);
				if (g[0][1] == '1')
					System.out.println("1 2");
				else
					System.out.println("2 1");			
			}
			else if (tZ == 1 && bZ == 1) {
				System.out.println(2);
				if (g[0][1] == '1')
					System.out.println("1 2");
				else
					System.out.println("2 1");
				if (g[n-2][n-1] == '0')
					System.out.println((n-1)+" "+(n));
				else
					System.out.println((n)+" "+(n-1));
			}
			else if (tZ == 1 && bZ == 2) {
				System.out.println(1);
				if (g[0][1] == '0')
					System.out.println("1 2");
				else
					System.out.println("2 1");			
			}			
			else {
				System.out.println(1);
				if (g[n-2][n-1] == '0')
					System.out.println((n-1)+" "+(n));
				else
					System.out.println((n)+" "+(n-1));	

				
			}
		}
	}
}