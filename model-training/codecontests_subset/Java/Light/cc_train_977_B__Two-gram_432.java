import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		int[][] arr=new int[26][26];
		int n=s.nextInt();
		String str=s.next();
		for(int a=0;a<str.length()-1;a++)
		{
			arr[str.charAt(a)-'A'][str.charAt(a+1)-'A']++;
		}
		int x=0,y=0;
		for(int a=0;a<26;a++)
		{
			for(int b=0;b<26;b++)
			{
				if(arr[a][b]>arr[x][y])
				{
					x=a;
					y=b;
				}
			}
		}
		System.out.println((char)('A'+x)+""+(char)('A'+y));
		s.close();
	}
	
}
