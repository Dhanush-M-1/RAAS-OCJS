import java.util.*;
public class newyear 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		int y=sc.nextInt();
		int count=0;
		int left=0;		
		while(x>0)
		{
			count=count+x;
			left=left+(x%y);
			x=x/y;
			if(left>=y)
			{
				x++;
				left=left-y;
			}
		}
		
		System.out.println(count);
	}
}
