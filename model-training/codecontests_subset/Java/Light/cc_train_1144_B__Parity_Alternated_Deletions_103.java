import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
 
public class myFile
{
	public static void main(String args[])
	{
	   Scanner sc = new Scanner(System.in);
	   List<Integer> list = new ArrayList<Integer>();
	   Queue<Integer> odd = new LinkedList<Integer>();
	   Queue<Integer> even = new LinkedList<Integer>();
	   while(sc.hasNextInt())
	   {
		   Integer n = sc.nextInt();
		   list.clear();
		   odd.clear();
		   even.clear();
		   for(int i=0;i<n;i++)
		   {
			   Integer x = sc.nextInt();
			   list.add(x);
		   }
		   Collections.sort(list);
		   for(int i=list.size()-1;i>=0;i--)
		   {
			   Integer number = list.get(i);
			   if((number%2)==0)
				   even.add(number);
			   else
				   odd.add(number);
		   }
		   
		   int min = Math.min(even.size(), odd.size());
		   if(even.size()>odd.size())
		   {
			  even.poll(); 
		   }
		   if(odd.size()>even.size())
		   {
			   odd.poll();
		   }
		   for(int i=1;i<=min;i++)
		   {
			   even.poll();
			   odd.poll();
		   }
		   Long ans =0l;
		   while(even.isEmpty()==false)
		   {
			   Integer x = even.poll();
			   ans=ans+x;
		   }
		   while(odd.isEmpty()==false)
		   {
			   Integer x = odd.poll();
			   ans=ans+x;
		   }
		   System.out.println(ans);
	   }
	}
 
}

