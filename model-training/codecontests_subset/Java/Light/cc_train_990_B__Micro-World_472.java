
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class B {

	static int[] a;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int K = in.nextInt();
		
		a = new int[n];
		for(int i = 0; i < n; ++i)  {
			a[i] = in.nextInt();
		}
		shuffle(a);
		Arrays.sort(a);
		
		int i = 0; int j = 1;
		
		int num = 0;
		while(j < n && i < n) {
			if(a[j] - a[i] <= K && a[j] > a[i]) {
			//	System.out.println(i + " " + j );
			//	System.out.println(a[j] + " eats " + a[i]);
				num++;
				i++;
			}
			else if(a[j] == a[i]) j++;
			else i++;
			if(i == j) j++;
		}
		System.out.println(a.length - num);
	}
	
	static void shuffle(int[] a) {
		  Random r = new Random();
		  int j; 
		  for (int i = a.length - 1; i > 0; i--) {
		   j = r.nextInt(i + 1);
		   if(i == j) continue;
		   a[i] = a[i] ^ a[j];
		   a[j] = a[i] ^ a[j];
		   a[i] = a[i] ^ a[j];
		  }
		 }
	

}
