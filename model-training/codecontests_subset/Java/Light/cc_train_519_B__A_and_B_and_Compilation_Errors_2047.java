import java.util.*;

//Ejercicio 8 --> http://codeforces.com/problemset/problem/519/B

public class Main {
	
	@SuppressWarnings({ "resource" })
	public static void main(String[] args){
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int e1 = 0;
		for(int i=0; i<n; i++){
			e1 += s.nextInt();
		}
		int e2 = 0;
		for(int i=0; i<n-1; i++){
			e2 += s.nextInt();
		}
		int e3 = 0;
		for(int i=0; i<n-2; i++){
			e3 += s.nextInt();
		}
		System.out.println(e1 - e2);
		System.out.println(e2 - e3);
		
	}

}
