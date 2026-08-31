import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import static java.lang.System.out;

import java.awt.RenderingHints.Key;
public class Main
{ @SuppressWarnings("unchecked")
public static void main(String []args)
	{Scanner sc = new Scanner(System.in);
	int n=sc.nextInt();
	String s=sc.next();
	StringBuilder []o=new StringBuilder[n];
	for(int i=0;i<o.length;i++)
		o[i]=new StringBuilder();
	StringBuilder x = new StringBuilder();
	int arr[]=new int[n];
	for(int i=0;i<n-1;i++)
	{ x.append(s.substring(i, i+2));
	        int q=check(o,x);
		if(q==-1) {
		o[i].append(s.substring(i,i+2));
		arr[i]++;
		}
		else {
			
			arr[q]++;
			}
		x.setLength(0);
	}
	int max=0;
	int index=0;
	for(int i=0;i<n;i++)
	{
		if(arr[i]>max) {
			max=arr[i];
			index=i;}
	}
	System.out.print(o[index]);
	}
	 static int check(StringBuilder f[],StringBuilder g)
	{  
		 int flag=0;
		 int i=0;
		for( i=0;i<f.length;i++)
		{
			if(f[i].toString().equals(g.toString()))
			{
				
				flag=1;
				break;
			}
		}
		if(flag==1)
			return i;
		else
			return -1;
	}
	
	}