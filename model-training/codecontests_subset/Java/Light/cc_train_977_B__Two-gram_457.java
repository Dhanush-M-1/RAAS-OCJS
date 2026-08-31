

import java.util.Scanner;

public class q2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int x=Integer.parseInt(sc.nextLine());
		String s=sc.nextLine();
		int max=0;
		String r="";
		for (int i = 0; i < s.length()-1; i++)
		{
			int maxf=0;
			String t=s.charAt(i)+""+s.charAt(i+1);
			//System.out.println(t);
			for (int j = 0; j < s.length()-1; j++)
			{
				if(t.equals(s.charAt(j)+""+s.charAt(j+1)))
				{
					maxf++;
					//System.out.println(maxf);
				}		
			}
			if(maxf>max)
			{
				r="";
				r=t;
				max=maxf;
			}
			
			
		}
		System.out.println((r));
	}

}
