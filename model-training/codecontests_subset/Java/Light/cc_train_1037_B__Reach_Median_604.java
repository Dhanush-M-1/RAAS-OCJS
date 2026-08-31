import java.util.Arrays;
import java.util.Scanner;

public class Class1 {
	public static void main(String[]	args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int s=input.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=input.nextInt();
		input.close();
		Arrays.sort(arr);
		long ans=0;
		int counter=(n-1)/2;
		if(arr[counter]<s) {
			while(counter<n&&arr[counter]<s) {
				ans+=s-arr[counter];
				counter++;
			}
		}
		else if(arr[counter]>s) {
			while(counter>-1&&arr[counter]>s) {
				ans+=arr[counter]-s;
				counter--;
			}
		}
		System.out.println(ans);
		
	}
}
