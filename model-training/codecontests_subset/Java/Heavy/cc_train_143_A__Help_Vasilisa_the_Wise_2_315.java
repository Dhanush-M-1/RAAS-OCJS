

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
 
 
		

	
int r1=input.nextInt();
int r2=input.nextInt();

	
int c1=input.nextInt();
int c2=input.nextInt();

	
int d1=input.nextInt();
int d2=input.nextInt();


int raspuns=0;

	for (int a=1;a<=9;a++)
	for (int b=1;b<=9;b++)	
	for (int c=1;c<=9;c++)
	for (int d=1;d<=9 && raspuns==0;d++)

		if (raspuns==0 && a+d==d1 && b+c==d2 && a+c==c1 && b+d==c2 && a+b==r1 && c+d==r2 && a!=c && a!=d && a!=b && c!=d && c!=b && b!=d)
			{raspuns=1;
				System.out.println(a+" "+b);
				System.out.println(c+" "+d);
			}
			
			if ( raspuns==0) System.out.println(-1);
	
}
	
		
		}
		
		
		