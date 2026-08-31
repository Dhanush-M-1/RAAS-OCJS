import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws Exception
	{
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		String str[]=s.split(" ");
		int d=Integer.parseInt(str[0]);
		int st=Integer.parseInt(str[1]);
		String ss=br.readLine();
		String str2[]=ss.split(" ");
		int arr[]=new int[d];
		for(int i=0;i<d;i++)
		arr[i]=Integer.parseInt(str2[i]);
		int max=0;
		for(int i=1;i<d;i++)
		{
		    if((arr[i-1]-arr[i])>max)
		    max=arr[i-1]-arr[i];
		}
		if(max-st>0)
		System.out.println(max-st);
		else
		System.out.println("0");
	}
}
