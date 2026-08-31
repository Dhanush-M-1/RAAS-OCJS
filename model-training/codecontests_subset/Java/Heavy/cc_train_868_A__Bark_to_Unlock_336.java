/* package whatever; // don't place package name! */
 
import java.util.*;
import java.lang.*;
import java.io.*;
 
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


HashMap<String, Integer> map= new HashMap<String, Integer>();
HashMap<String, Integer> curatare= new HashMap<String, Integer>();
HashMap<String, Integer> combinari= new HashMap<String, Integer>();
 
		
	String str=input.next();
	String nn=input.next();
	
	int n=Integer.parseInt(nn);
	
	int x=0;
	
	for(int i=1;i<=n && x==0;i++){
	
	String a=input.next();
	if(a.equals(str)) x=1;
	else {map.put(a.substring(1),1); curatare.put(a.substring(0,1),1);
	
	}
	
	
	}
	
	if(x==0 && map.containsKey(str.substring(0,1)) && curatare.containsKey(str.substring(1))) x=1;
	if(x==1) System.out.println("YES");
	else System.out.println("NO");
	 
	 }
	
	
		
		}
		
		
		