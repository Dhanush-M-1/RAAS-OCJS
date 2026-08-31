

import java.util.*;


public class Ironman
{
	public static void main (String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		String nu = sc.next();
		String sel = nu.substring(n-x,n);
		
		int count = 0;
		for(int i=0;i<x;i++){
		    
		    if(sel.substring(i,i+1).equals("1")) count++;
		}
		if(sel.substring(x-y-1,x-y).equals("0")) count++;
		if(sel.substring(x-y-1,x-y).equals("1")) count--;
		
		System.out.println(count);
	}
}
