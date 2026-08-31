import java.util.*;
import java.io.*;

public class Div2_350B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(), k = sc.nextInt();
		int[] array = new int[n];
		for(int i = 0; i < n; i++)
			array[i] = sc.nextInt();
		
		int c = 1;
		while(true) {
			if(k <= c)
				break;
			k -= c++;
		}
		
		System.out.println(array[k - 1]);
	}
}
