
import java.util.*;
import java.lang.*;
import java.io.*;

public class GFG {
	public static void main (String[] args) {
		Scanner input=new Scanner(System.in);
		int test=input.nextInt();
		for(int t=0;t<test;t++)
		{
		    int n =input.nextInt();
		    int[] arr=new int[n];
		    Map<Integer,Integer> map= new TreeMap<Integer, Integer>(Collections.reverseOrder());
		    for(int i=0;i<n;i++)
		    {
		        int v=input.nextInt();
		        if(map.containsKey(v))
		        {
		            map.put(v,map.get(v)+1);
		        }
		        else map.put(v,1);
		    }
		    int m=n/2;
		    if(m<5)
		    {
		        System.out.println(0+" "+0+" "+0);
		    }
		    else{
		        int g=0;
		        int s=0;
		        int br=0;
		        for(Integer i:map.keySet())
		        {
		            int val=map.get(i);
		            if(g+s+br+val>m) break;
		            if(g==0) 
		            {
		                g=val;
		                continue;
		            }
		            if(s<=g)
		            {
		                s+=val;
		                continue;
		            }
		            br+=val;    
		        }
		        if((br==0)||(br<=g)||(s<=g)) System.out.println(0+" "+0+" "+0);
		        else System.out.println(g+" "+s+" "+br);
		    }
		}
		
	}
	
}