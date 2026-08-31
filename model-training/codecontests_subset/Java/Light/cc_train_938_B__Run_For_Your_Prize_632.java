import java.util.*;
public class experiment{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i = 0;i<n;i++)
			arr[i] = sc.nextInt();
		int s1 = 1,s2 = 1000000;
		int curr = 0,time = 0;
		while(curr<n && arr[curr]<=s2-arr[curr])
		{
			s1 = arr[curr];
			curr++;
		}
		if(curr == n){
			System.out.println((s1-1));
		}
		else
			System.out.println(Math.max(s1-1, s2-arr[curr]));
		}
	
}