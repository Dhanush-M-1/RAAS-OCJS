/* package whatever; // don't place package name! */
 
import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
 
/* Name of the class has to be "Main" only if the class is public. */
public class bbg
{
	public static int result;
 
public static ArrayList<Integer> [] graph;
 
public static int[]cats;
 
public static int vizitat[];
public static int x;
//public static HashMap<String, Integer> map2;
 
 
	public static void main (String[] args) throws java.lang.Exception
{
 
Scanner input=new Scanner(System.in);
 
HashMap<Integer, Integer> contor1= new HashMap<Integer, Integer>();
HashMap<Integer, Integer> contor2= new HashMap<Integer, Integer>();


HashMap<Integer, Integer> map= new HashMap<Integer, Integer>();
HashMap<String, Integer> curatare= new HashMap<String, Integer>();
HashMap<String, Integer> combinari= new HashMap<String, Integer>();
 
 
		
		
		String nn=input.next();
		int n=Integer.parseInt(nn);
		
		String str=input.next();
		
		String v[]=new String[n];
		int s[]=new int[n];
		String a;
		
		

	int y=0;
	
	
		for(int i=0;i<str.length();i++)
		
		if(str.substring(i,i+1).equals("*")) s[i]=1;
		
	//	for(int i=0;i<n;i++) System.out.print(s[i]);
		
	for(int i=0;i<n;i++)
	if(s[i]==1){
	    
	    
	
	for(int j=1;j<=100;j++)
	{int contor=1;
	for(int x=1;x<=5;x++){
	    
	  
	    
	    int part=i+j*x;
	    
	    if(i+j*x<n) {if(contor<5 && s[i+j*x]==0) contor=0;
	   
	    else if(s[part]==1) {contor++;
	        
	       // System.out.println(i+" "+part+" "+contor);
	    }
	     if(contor>=5) y=1;
	     
	     
	     
	    }
	    
	}
	
}
	
	}
	
	if(y==0) System.out.println("no");
	else System.out.println("yes");
		
		}
		
		
		}
		
		