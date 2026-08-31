/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Collections;
/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int s=sc.nextInt();
		ArrayList<Integer> a=new ArrayList<Integer> ();
		int i;
		long ans=0,ans1=0;
		for(i=0;i<n;i++)
		a.add(sc.nextInt());
		Collections.sort(a);
		
		for(i = 0;i < n/2; i++){
            if(a.get(i) > s){
                ans += Math.abs(s - a.get(i));
            }
        }
        for(i = n/2 + 1; i < n; i++){
            if(a.get(i)< s){
                ans += Math.abs(s - a.get(i));
            }
        }
	//ans=Math.min(ans,ans1);
	ans += Math.abs(s - a.get(n/2));
		System.out.println(ans);
	}
}