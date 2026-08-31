import java.util.Scanner;

public class Main {
	//A. Kitahara Haruki's Gift
	//http://codeforces.com/contest/433/problem/A

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); //Numero de manzanas
		int[] v = new int[3];
		
		int k;
		for(int i=0; i<n; i++){
			k = in.nextInt();
			v[k/100]++;
		}
		int resto = v[2]%2;
		boolean divisibles = (v[1]-2*resto)%2 == 0; 
		if(v[1]>=resto && divisibles) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		

	}

}
