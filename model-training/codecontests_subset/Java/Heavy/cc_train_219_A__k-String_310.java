import java.util.Scanner;

public class KString {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int k=sc.nextInt();
		sc.nextLine();
		String s=sc.nextLine();
		char[] ref=new char[26];
		for(int i=0;i<26;i++)
		{
			ref[i]=(char) (i+'a');
		}
		int[] arr=new int[26];
		for(int i=0;i<s.length();i++)
		{
			arr[s.charAt(i)-'a']++;
		}
		int count = 0;
		boolean bool=false;
		for(int i=0;i<26;i++)
		{
			if(arr[i]!=0)
			{
				if(arr[i]%k!=0)
				{
					System.out.println("-1");
					return;
				}
			}
		}
		int x=count/k;
		String answer="";
		for(int i=0;i<k;i++)
		{
			for(int j=0;j<26;j++)
			{
				if(arr[j]!=0)
				{
					x=arr[j]/k;
					while(x!=0)
					{
						answer+=ref[j];
						x--;
					}
	
				}
			}
		}
		System.out.println(answer);
	}
}
