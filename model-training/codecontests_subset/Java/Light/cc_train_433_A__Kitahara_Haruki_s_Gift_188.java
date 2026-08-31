import java.util.Scanner;


public class T433A {

	public void solve(int n, int[] w) {
		
		int w100 = 0;
		int w200 = 0;
		
		for (int i = 0; i < n; i ++) {
			if (w[i] == 100) w100 ++;
			if (w[i] == 200) w200 ++;
		}
		
		if (w100 % 2 != 0)
			System.out.println("NO");
		else
			if (w100 > 0)
				System.out.println("YES");
			else
				if (w200 % 2 == 0)
					System.out.println("YES");
				else
					System.out.println("NO");
	}
	
	public static void main(String[] args) {
		T433A t = new T433A();
		/*
		int n0 = 3;
		int[] w0 = {100, 200, 100};
		
		int n1 = 4;
		int[] w1 = {100, 100, 100, 200};
		
		t.solve(n0, w0);
		t.solve(n1, w1);
		*/
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] w = new int[n];
		for (int i = 0; i < n; i ++) w[i] = in.nextInt();
		t.solve(n, w);
	}

}
