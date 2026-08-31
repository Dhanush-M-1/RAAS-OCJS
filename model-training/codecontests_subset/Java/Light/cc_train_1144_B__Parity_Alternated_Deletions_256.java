/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner s  = new Scanner(System.in);
		int n = s.nextInt();
        ArrayList<Integer> e = new ArrayList<Integer>();
        ArrayList<Integer> o = new ArrayList<Integer>();
        int counto=0;
        int counte=0;
        for(int i=0;i<n;i++){
            int temp = s.nextInt();
            if(temp%2==0){
                counte++;
                e.add(temp);
            }
            else{
                counto++;
                o.add(temp);
            }
        }
        if(Math.abs(counto-counte)<=1){
            System.out.println(0);
        }
        else{
            Collections.sort(e);
            Collections.sort(o);
            long ans=0;
            for(int i=0;i<counte-counto-1;i++){
                ans=ans+e.get(i);
            }
            for(int i=0;i<counto-counte-1;i++){
                ans=ans+o.get(i);
            }
            System.out.println(ans);
        }
        
	}
}
