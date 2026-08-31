import java.util.*;
import java.lang.*;
import java.io.*;

public class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String s=sc.next();
		int i;
		HashMap<String,Integer> hmap=new HashMap<String,Integer> ();
		for(i=0;i<n-2;i++)
		{
			String s1=s.substring(i,i+2);
			if(hmap.containsKey(s1))
			    hmap.put(s1,(hmap.get(s1))+1);
			
			else
			    hmap.put(s1,1);
		}
		String s4=(s.substring(n-2,n));
		if(hmap.containsKey(s4))
		    hmap.put(s4,(hmap.get(s4))+1);
		
		if(hmap.size()==0)
		  System.out.println(s.substring(0,2));
		else
		{
		int max=0;
		String stri="";
		for(Map.Entry<String,Integer> entry: hmap.entrySet())
		{
			if(entry.getValue()>max)
			{
				max=entry.getValue();
				stri=entry.getKey();
				
			}
		}
		System.out.println(stri);
	}
}
}