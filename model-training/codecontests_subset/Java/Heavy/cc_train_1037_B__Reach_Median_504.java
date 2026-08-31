
import java.util.Arrays;
import java.util.Scanner;

public class ReachMedian {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt(),s=in.nextInt(),medind,flag=0,i=0;
		long count=0;
		int arr[]=new int[n];
		for(i=0;i<n;i++)
			arr[i]=in.nextInt();
		Arrays.sort(arr);
		medind=(n/2);
		if(s<=arr[medind]) {
			count=arr[medind]-s;flag=1;i=medind-1;		

		}else {
			count=s-arr[medind];		
			i=medind+1;
		}
		if(flag==1)
			while(i>-1&&arr[i]>s) {
				count+=Math.abs(s-arr[i]);
				i--;
			}
		else {
			while(i<n&&arr[i]<s) {
				count+=Math.abs(s-arr[i]);
				i++;
			}
		}
		System.out.println(count);
	}
}
