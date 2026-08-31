import java.util.ArrayList;
import java.util.Scanner;

public class BadTriangle {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		ArrayList<ArrayList<Integer>> list=new ArrayList<>();
		while(t>0)
		{
			int n=scn.nextInt();
			int[] arr= new int[n];
			for(int i=0;i<n;i++)
				arr[i]=scn.nextInt();
			int[] ans=badTriangle(arr);
			ArrayList<Integer> ll=new ArrayList<>();
			if(ans.length==0)
			  ll.add(-1);
			else {
				for(int a:ans)
					ll.add(a);
			}
			list.add(ll);
			t--;
		}
		for(ArrayList<Integer> ll1:list)
		{
			for(int a :ll1)
				System.out.print(a+" ");
			System.out.println();
		}
	}
	public static int[] badTriangle(int[] arr)
	{
		int[] ans=new int[3];
		
		if(arr[0]+arr[1]<=arr[arr.length-1])
		{
			ans[0]=1;
			ans[1]=2;
			ans[2]=arr.length;
			return ans;
		}
		
		 return new int[0];
		
		
	}

}