

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

		
			int rez=0;

			int numere=str.length()-str.replaceAll("8","").length();

			rez=Math.min(numere,n/11);

			System.out.println(rez);





	}

	}
