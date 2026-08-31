

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
 
 
		

		

		int n=input.nextInt();
		int v[]=new int[n];
		int sum=0;
		int max=-1;

		for(int i=0;i<n;i++) {v[i]=input.nextInt(); sum+=v[i]; max=Math.max(max,v[i]);}

			int k=(2*sum+1)/n;
			if ((2*sum+1)%n!=0) k++;
		if(k<max) k=max;
 
		System.out.println(k);


	}

	}
