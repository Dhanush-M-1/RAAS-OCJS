import java.util.Scanner;

public class Palindrome
{
	public static void main(String[] args) {
		
	Scanner sc=new Scanner(System.in);
	int numofrobot=sc.nextInt();
	int k=sc.nextInt();
	sc.nextLine();
	int[] arr=new int[numofrobot];
	for(int i=0;i<numofrobot;i++)
	{
		arr[i]=sc.nextInt();
	}
	int number = 0;
	for(int i=1;i<100000;i++)
	{
		if(k-i>0)
		{
			k=k-i;
		}
		else
		{
			System.out.println(arr[k-1]);
			break;
		}
	}
	//System.out.println(arr[k-number-1]);
	}
}