/*package whatever //do not write package name here */

import java.util.*;

public class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		HashMap<Integer,Integer> hmap=new HashMap<Integer,Integer> ();
		int i=0,sum=0;
		for(i=0;i<n;i++)
		{
		    int ele=sc.nextInt();
		    if(hmap.containsKey(ele))
		        hmap.put(ele,((hmap.get(ele))+1));
		  else
		    hmap.put(ele,1);
		    sum+=1;
		}
		ArrayList<Integer> a=new ArrayList<>(hmap.keySet());
		Collections.sort(a);
		//System.out.println(sum+" "+hmap+" "+a);
		for(i=a.size()-1;i>=1;i--)
		{
		        if(a.get(i)>a.get(i-1)&&a.get(i)<=(a.get(i-1)+k))
		        sum-=hmap.get(a.get(i-1));
		}
		    System.out.println(sum);
		
	}
}