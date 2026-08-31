import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[][] T = new String[14][4];

		T[0][0] = "S";
		T[0][1] = "H";
		T[0][2] = "C";
		T[0][3] = "D";
			

		for(int i = 0; i < 4; i++)
			for (int j = 1; j < 14; j++)
				T[j][i] = "false";

		int n = sc.nextInt();

		String[][] N = new String[n][2];
		for (int i = 0; i < n; i++) {
			N[i][0] = sc.next();
			N[i][1] = sc.next();
			if (N[i][0].equals("S"))
				T[Integer.parseInt(N[i][1])][0] = "true";
			else if (N[i][0].equals("H"))
				T[Integer.parseInt(N[i][1])][1] = "true";
			else if (N[i][0].equals("C"))
				T[Integer.parseInt(N[i][1])][2] = "true";
			else
				T[Integer.parseInt(N[i][1])][3] = "true";
		}

		for(int i = 0; i < 4; i++)
			for (int j = 1; j < 14; j++)
				if(T[j][i].equals("false"))
					System.out.printf("%s %s\n", T[0][i], j);
	}
}	
