/* package whatever; // don't place package name! */
 
import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;import java.math.BigInteger;
import java.io.OutputStreamWriter;
 
/* Name of the class has to be "Main" only if the class is public. */
public class bbg
{
	public static int result;
 
public static ArrayList<Integer> [] graph;
 
public static int[]cats;
 
public static int vizitat[];
public static int x;
//public static HashMap<String, Integer> map2;
 
 
	public static void main (String[] args) throws IOException {
 
Scanner input = new Scanner(System.in);
 
HashMap<Integer, Integer> contor1= new HashMap<Integer, Integer>();
HashMap<Integer, Integer> contor2= new HashMap<Integer, Integer>();


HashMap<Long, Long> map= new HashMap<Long, Long>();
HashMap<String, Integer> curatare= new HashMap<String, Integer>();
HashMap<String, Integer> combinari= new HashMap<String, Integer>();
 
 


 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
 

	
	
		 
	  int a=input.nextInt();
int b=input.nextInt();


int d=Math.abs(b-a);
int result;


if(d % 2==0) result =(d+2)*(d+0)/4;

else result=(d+1)*(d+1)/4;

System.out.println(result);

}

}