import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.HashSet;
public class myFile
{
	public static void main(String args[])
	{
		int i,n,x,max,total;
		List<Integer> list = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt())
        {
        	list.clear();
        	n = sc.nextInt();
        	max=total=0;
        	for(i=0;i<n;i++)
        	{
        		x = sc.nextInt();
        		total+=x;
        		list.add(x);
        		max = Math.max(max, x);
        	}
        	int total2=0;
        	for(i=0;i<n;i++)
        	{
        		total2 = total2+ max-list.get(i);
        	}
        	if(total<total2)
        		System.out.println(max);
        	else
        	{
        		int remaining = total-total2;
        		int u = (remaining/n)+1;
        		System.out.println(u+max);
        	}
        	
        }
	    
	}
	
	
}

