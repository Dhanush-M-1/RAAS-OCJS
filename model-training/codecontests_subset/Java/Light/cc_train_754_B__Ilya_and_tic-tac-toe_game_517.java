import java.util.Scanner;
public class Main {
	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
		
		String x1 = sc.nextLine();
		String x2 = sc.nextLine();
		String x3 = sc.nextLine();
		String x4 = sc.nextLine();
		
		char m[][]= new char[4][4];
		String ou=null;
		for(int i=0;i<4;i++)
		{
			m[0][i] = x1.charAt(i);
			m[1][i] = x2.charAt(i);
			m[2][i] = x3.charAt(i);
			m[3][i] = x4.charAt(i);
		}
		a:for (int i=0;i<2;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(m[j][i]+m[j][i+1]+m[j][i+2]==286)
				{
					ou="YES";
					break a;
				}
			}
		}
		b:for (int i=0;i<2;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(m[i][j]+m[i+1][j]+m[i+2][j]==286)
				{
					ou="YES";
					break b;
				}
			}
		}
		c:for(int i=0;i<2;i++)
		{
			for(int j=0;j<2;j++)
			{
				if(m[i][j]+m[i+1][j+1]+m[i+2][j+2]==286)
				{
					ou="YES";
					break c;
				}
			}
		}
		d:for(int i=2;i<4;i++)
		{
			for(int j=0;j<2;j++)
			{
				if(m[i][j]+m[i-1][j+1]+m[i-2][j+2]==286)
				{
					ou="YES";
					break d;
				}
			}
		}
		if(ou==null)
		{
			System.out.println("NO");
		}
		else
		{
			System.out.println(ou);
		}
		sc.close();
	}

}
  	  	   	   	 	  		   				   	