import java.util.Arrays;
import java.util.Scanner;

public class A1 {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int n = scan.nextInt(), k = scan.nextInt();
	int[] arr =new int[n];
	for(int i = 0 ; i < n;i++)
	{
		arr[i]= scan.nextInt();
	}
	Arrays.sort(arr);
	int maxGcd = 1;
	for(int i = 0 ; i < arr.length;i++)
	{
		if(k%arr[i]==0)
			maxGcd = arr[i];
	}
	System.out.println(k/maxGcd);
}
}
