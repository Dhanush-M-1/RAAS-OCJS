import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{
	public static boolean condition(char x){
	   return (x=='a'||x=='e'||x=='i'||x=='o'||x=='u'||x=='y');	
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int number=Integer.parseInt(br.readLine());
		int[] array=new int[10000001];
		String[] str=br.readLine().split(" ");
		for(int i=0;i<number;i++) {
			array[Integer.parseInt(str[i])]++;
		}
		int max=0;
		int min=0;
		int my=1000000/2;
		int friend=my+1;
		int count=0;
		for(int i=1;i<=999999;i++) {
			if(i<=my && array[i]!=0 && i>=max)
				max=i;
			if(count==0 && i>=friend && array[i]!=0)
				{min=i;count++;}
		}
		if(max==0)
			System.out.println(1000000-min);
		else if(min==0)
		System.out.println(max-1);
		else
		System.out.print(Math.max(max-1,1000000-min));
	}
	}