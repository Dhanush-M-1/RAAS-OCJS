import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Garden {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		int k=scan.nextInt();
		int[] a= new int[n];
		HashSet<Integer> h= new HashSet<Integer>();
		for(int i=0;i<n;i++) {
			a[i]=scan.nextInt();
			if(k%a[i]==0) {
				h.add(k/a[i]);
			}
		}
		System.out.println(Collections.min(h));
		
	}

}
