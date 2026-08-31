import java.util.*;
public class TaskA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		String s=scan.next();
		for(int i=1;i<=n/4;i++)
		{
			for(int j=0;j<n;j++)
			{
				boolean res=true;
				int nn=0;
				for(int k=0;k<=4;k++)
				{
					if(j+k*i<n)
					{
						if(s.charAt(j+k*i)=='.')
						{
							res=false;
							break;
						}
						else
						{
							nn++;
						}
					}
					
				}
				if(res==true&&nn>4)
				{
					System.out.println("yes ");
					return;
				}
			}
		}
		System.out.println("no");
		return;
	}

}
