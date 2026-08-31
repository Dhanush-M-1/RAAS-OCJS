import java.util.*;
import java.io.*;

public class b{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] a = new int[n];
		for (int i=0; i<n ; i++) {
			a[i] = in.nextInt();
		}
		long i=1;
		long r=0;
		while(r<k && r+i<k){
			r = r+i;
			i++;
		}
		System.out.println(a[(int)(k-r-1)]);
	}
}