import java.io.*;
import java.util.*;

public class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int sum = 0 , max = 0;
		for(int i = 0; i < n; i++){
		    a[i] = sc.nextInt();
		    sum += a[i];
		    if(a[i] > max){
		        max = a[i];
		    }
		}
		if((n * max) > (2 * sum)){
		    System.out.println(max);
		}
		else{
		    int p = (2 * sum) / n;
		    System.out.println(p + 1);
		}
		
	}
}