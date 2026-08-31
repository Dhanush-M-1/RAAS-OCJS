import java.io.*;
import java.util.*;
public class Game_Of_Robots {
public static void main(String args[])
{
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	int k=sc.nextInt();
	int arr[]=new int[n];
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();
	
	for(int i=0;i<n;i++)
	{
		if(k-(i+1)>0)
			k=k-(i+1);
		else
		{
			System.out.println(arr[k-1]);
			break;
		}
	}
}
}