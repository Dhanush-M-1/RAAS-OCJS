/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		String[] arr = str.split(" ");
		int n = Integer.parseInt(arr[arr.length-1]), temp = 0,nm=0, np=0;
		
		for(int i=0; i<arr.length; i++){
			if(arr[i].equals("-"))
				nm++;
			else if(arr[i].equals("+"))
				np++;
		}
		//System.out.println(nm+" "+np);
		if(np == 0){
			if(nm>0)
			 System.out.println("Impossible");
		else{
			arr[0] = n+" ";
			System.out.print("Possible\n"+arr[0]);
			for(int i=1 ; i<arr.length; i++)
				System.out.print(arr[i]+" ");
		}
		}else if(nm == 0){
				if(n - np >=  1){
				System.out.println("Possible");
				arr[0] = (n-(np))+ " ";
				System.out.print(arr[0]);
				for(int i=1 ; i<arr.length; i++){
					if(arr[i].equals("+")){
						arr[i+1] = 1+"";
					}
					System.out.print(arr[i]+" ");	
				}
			}else System.out.println("Impossible");
		}
		else if(np>nm){
			int x = np/nm;
			int mod = np%nm;
			
			if(x<= n && (mod == 0 || (n-x)*nm >= (mod)) || n-(mod -(n-x)*nm) >=1){
				int incr = n-x, ToBeIncr = mod;
				//System.out.println(incr+" " + ToBeIncr+" "+x);
				System.out.println("Possible");
				arr[0] = n+" ";
				if(!((n-x)*nm >= mod))
					arr[0] = n - (mod -(n-x)*nm)+ " ";
				System.out.print(arr[0]);
			for(int i=1 ; i<arr.length ; i++){
				
				if(arr[i].equals("+"))
					arr[i+1] = 1+"";
					
				if(arr[i].equals("-")){
					if(ToBeIncr > incr){
						temp = incr;
						ToBeIncr -= incr;
					}else{
						temp = ToBeIncr;
						ToBeIncr = 0;
					}
					arr[i+1] = (x+temp)+"";
				}
				System.out.print(arr[i]+" ");
				}
			}else System.out.println("Impossible");
		}else{
			int x = nm/np;
			int mod = nm%np;
			if(x<= n && (mod==0 || (n-x)*np >= (mod))){
				int incr = n-x, ToBeIncr = mod;
			//	System.out.println(incr+" " + ToBeIncr+" "+x);
				System.out.println("Possible");
				arr[0] = n+" ";
				System.out.print(arr[0]);
			for(int i=1 ; i<arr.length ; i++){
				
				if(arr[i].equals("-"))
					arr[i+1] = 1+"";
					
				if(arr[i].equals("+")){
					if(ToBeIncr > incr){
						temp = incr;
						ToBeIncr -= incr;
					}else{
						temp = ToBeIncr;
						ToBeIncr = 0;
					}
					arr[i+1] = (x+temp)+"";
				}
				System.out.print(arr[i]+" ");
				}
			}else System.out.println("Impossible");
		}
			
	}
}