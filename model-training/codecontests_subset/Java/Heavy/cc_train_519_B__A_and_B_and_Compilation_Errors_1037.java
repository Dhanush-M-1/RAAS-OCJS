import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int[] a1 = new int[n];
		int[] a2 = new int[n-1];
		int[] a3 = new int[n-2];
		
		for(int i=0; i<n; i++)
			a1[i] = sc.nextInt();
		for(int i=0; i<n-1; i++)
			a2[i] = sc.nextInt();
		for(int i=0; i<n-2; i++)
			a3[i] = sc.nextInt();
		
		Arrays.sort(a1);
		Arrays.sort(a2);
		Arrays.sort(a3);
		
		int i = 0;
		for(i=0; i<n-1; i++) {
			if(a1[i] != a2[i])
				break;
		}
		System.out.println(a1[i]);
		
		for(i=0; i<n-2; i++) {
			if(a2[i] != a3[i])
				break;
		}
		System.out.println(a2[i]);
		
		sc.close();
	}

}