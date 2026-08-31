import java.util.*;
public class Main {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		int l = sc.nextInt();
		int r = sc.nextInt();
		
		
		int start_2=0,end_2=0;
		int start_3=0,end_3=0;
		if (l==r)
			System.out.println(l);
		else
		{
			for (int i =l;;i++)
			{
				if (i%2==0)
					{
					start_2=i;
					break;
					}
			}
			for (int i =l;;i++)
			{
				if (i%3==0)
					{
					start_3=i;
					break;
					}
			}
			
			for (int i =r;;i--)
			{
				if (i%2==0)
					{
					end_2=i;
					break;
					}
			}
			
			for (int i =r;;i--)
			{
				if (i%3==0)
					{
					end_3=i;
					break;
					}
			}
			
			int two = (end_2-start_2)/2;
			int three = (end_3-start_3)/3;
			
			
			
			
			if (two>three)
				System.out.println("2");
			else
				System.out.println("3");

		}
				
		sc.close();

	}

}
