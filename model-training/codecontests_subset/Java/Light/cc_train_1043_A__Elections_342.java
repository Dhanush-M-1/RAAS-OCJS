import java.util.Scanner;
import java.io.PrintWriter;
public class Solution {
static Scanner in=new Scanner(System.in);
public static void main(String[] args) {
	int n=in.nextInt();
	int arr[]=new int[n];
	int max=0,intitalSum=0;
	for(int i=0;i<n;i++) {
		arr[i]=in.nextInt();
		intitalSum+=arr[i];
		if(max<arr[i])
			max=arr[i];
	}
	int sum=0;
	while(sum<intitalSum) {
		sum=0;
		for(int i=0;i<n;i++) {
			sum=sum+max-arr[i];
		}
		if(sum>intitalSum) {
			break;
		}
		else {
			max++;
		}
	}
	System.out.println(max);

}
}
