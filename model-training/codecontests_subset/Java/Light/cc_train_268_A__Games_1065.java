import java.util.Scanner;

public class Games 
{
	public static void solution(int[] a1,int m1)
	{
		int count1=0;
		
		for(int i=0;i<2*m1-1;i+=2)
			for(int j=1;j<2*m1;j+=2)
				if(a1[i]==a1[j])
					count1++;

		System.out.println(count1);
	}
	public static void main(String[] zima)
	{
		Scanner sc=new Scanner(System.in);
		
		int m1=sc.nextInt();
		int[] a1=new int[2*m1];
		
		for(int i=0;i<2*m1;i++)
			a1[i]=sc.nextInt();
		
		solution(a1,m1);
		sc.close();
	}
}