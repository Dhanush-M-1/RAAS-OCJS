import java.util.*;
public class Main {
	public static void main(String[] args)  {
		Scanner scan = new Scanner(System.in);
		int n=Integer.parseInt(scan.next());
		int[] a = new int [n];
		for (int i = 0; i < n; ++i){
			a[i]=Integer.parseInt(scan.next());
		}

		long sum = 0;
		for (int i = 0; i < n; ++i){
			sum+=a[i];
		}
		System.out.print(sum-n);



}
}
//end