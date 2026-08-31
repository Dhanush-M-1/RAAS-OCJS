import java.util.*;
import java.io.*;
public class Solution1{
	public static long deletion(int arr[]){
		ArrayList<Integer> even=new ArrayList<>(),
						   odd=new ArrayList<>();

		for(int i=0;i<arr.length;i++)
			if((arr[i]&1)==1)
				odd.add(arr[i]);
			else
				even.add(arr[i]);


		if(Math.abs(even.size()-odd.size())<=1)
			return 0L;

		long sum=0;
		if(even.size()>odd.size()){
			Collections.sort(even,Collections.reverseOrder());
			for(int i=odd.size()+1;i<even.size();i++)
				sum+=even.get(i);
		}
		else{
			Collections.sort(odd,Collections.reverseOrder());
			for(int i=even.size()+1;i<odd.size();i++)
				sum+=odd.get(i);
		}
		return sum;
	}
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
			int n=in.nextInt();
			int arr[]=new int[n];
			for(int i=0;i<n;i++)
				arr[i]=in.nextInt();

			System.out.println(deletion(arr));
	}
}