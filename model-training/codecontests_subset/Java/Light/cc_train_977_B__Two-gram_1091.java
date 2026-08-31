import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
public class CodeChef
{
  public static void main(String[] args)
  {
	  Scanner scan = new Scanner(System.in);
	  String result="";
	  int max=0;
	  int n = scan.nextInt();
	  String str=scan.next();
	  HashMap<String,Integer> hashmap = new HashMap<>();
	  for(int i=0; i<n-1; i++)
	  {
		  String temp = str.substring(i,i+2);
		  hashmap.put(temp, hashmap.getOrDefault(temp,0)+1);
		  if(hashmap.get(temp)>=max)
		  {
			  max=hashmap.get(temp);
			  result=temp;
		  }
	  }
	  System.out.println(result);
  }
}