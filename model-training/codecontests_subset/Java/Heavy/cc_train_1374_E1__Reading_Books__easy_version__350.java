import java.io.*;
import java.util.*;
public class hi {

	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		ArrayList<Integer> Bob= new ArrayList<Integer>();
		ArrayList<Integer> Alice= new ArrayList<Integer>();
		ArrayList<Integer> AB= new ArrayList<Integer>();
		int total=0;
		for(int x=0;x<n;x++)
		{
			int t=sc.nextInt();
			int a=sc.nextInt();
			int b=sc.nextInt();
			if(a==1&&b==1)
			{
				AB.add(t);
				//total+=t;
			}
			if(a==1&&b==0)
			{
				Alice.add(t);
			}
			if(a==0&&b==1)
			{
				Bob.add(t);
			}
		}
		Collections.sort(Alice);
		Collections.sort(Bob);
		if(Math.min(Alice.size(), Bob.size())+AB.size()<k)
		{
			System.out.println("-1");
		}
		else
		{
			for(int x=0;x<Math.min(Alice.size(), Bob.size());x++)
			{
				AB.add(Alice.get(x)+Bob.get(x));
			}
			Collections.sort(AB);
			for(int x=0;x<k;x++)
			{
				total+=AB.get(x);
			}
			System.out.println(total);
		}
		

	}

}
