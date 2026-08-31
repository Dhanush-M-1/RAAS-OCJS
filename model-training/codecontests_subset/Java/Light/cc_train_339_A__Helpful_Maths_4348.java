import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s[]=sc.nextLine().split("\\+");
		int arr[]=new int[500];
		for(int i=0;i<s.length;i++)
		{
		    arr[i]=Integer.parseInt(s[i]);
		}
		for(int i=0;i<s.length;i++)
		{
		    for(int j=i+1;j<s.length;j++)
		    {
		        if(arr[i]>arr[j])
		        {
		        int temp;
		        temp=arr[i];
		        arr[i]=arr[j];
		        arr[j]=temp;
		        }
		    }
		}
		int sum=0;
		for(int i=0;i<s.length-1;i++)
		{
		    System.out.print(arr[i]+"+");
		}
		System.out.print(arr[s.length-1]);
	}
}
