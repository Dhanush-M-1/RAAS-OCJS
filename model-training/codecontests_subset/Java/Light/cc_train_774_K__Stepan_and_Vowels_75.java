import java.util.*;

public class Main 
{
	public static void main(String[] args)
	{
		int num;
		Scanner sc=new Scanner(System.in);
		num=sc.nextInt();
		String s=sc.nextLine();
		s=sc.nextLine();
		char ch;
		int cnt=0;
		for(int i=0;i<s.length();i++)
		{
			ch=s.charAt(i);
			cnt=1;
			if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='y')
			{
				for (int j=i+1;j<s.length();j++)
				{
					if (ch==s.charAt(j))
						cnt++;
					else 
					    break;
				}
				if(cnt==2 && (ch=='o' || ch=='e'))
					System.out.print(ch);
				i+=cnt-1;
			}
			System.out.print(ch);
		}
	}
}