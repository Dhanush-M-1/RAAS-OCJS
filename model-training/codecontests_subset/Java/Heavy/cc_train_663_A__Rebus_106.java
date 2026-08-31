//package string;
import java.util.*;
public class house {

	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		//Object out;
		//PrintWriter=new PrintWriter(System.out);
		String s1=sc.nextLine();
		int plus=0,minus=0;
		String ar[]=s1.split(" ");
		int n=Integer.parseInt(ar[ar.length-1]);
		for(int i=1;i<ar.length-1;i+=2)
		{
			if(ar[i].equals("+"))
				plus++;
			if(ar[i].equals("-"))
				minus++;
		}
		plus++;
		if(n<(1*plus-n*minus) || n>(n*plus-1*minus))
		{
			System.out.println("Impossible");
		}
		else
		{
			System.out.println("Possible");
			int S=0;
			for(int i=0;i<ar.length;i=i+2)
			{
				int sgn=1;
				if(i>0 && ar[i-1].equals("-"))
					sgn=-1;
				if(sgn==1)plus--;
				else minus--;
				for(int j=1;j<=n;j++)
				{
					if((S+sgn*j+plus-n*minus)<=n && n<=(S+sgn*j+plus*n-1*minus))
					{
						ar[i]=Integer.toString(j);
						S+=sgn*j;
						break;
					}
				}
			}
			for(int i=0;i<ar.length;i++)
			{
				System.out.println(ar[i]+ " ");
			}
		}
	
	}
}
