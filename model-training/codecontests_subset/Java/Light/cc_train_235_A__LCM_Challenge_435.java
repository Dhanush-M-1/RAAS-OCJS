import java.util.*;

public class LCM_Challenge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		long num = input.nextInt();
		long res;
		
		if(num==1)
		{
			System.out.println(1);
			System.exit(0);
		}
		
		if(num==2)
		{
			System.out.println(2);
			System.exit(0);
		}
		
		if(num==3)
		{
			System.out.println(6);
			System.exit(0);
		}
		
		if(num%2==0)
		{
			if(num%3==0)
			{
				res = (num-1)*(num-2)*(num-3);
			}
			else
			{
				res = (num)*(num-1)*(num-3);
			}
		}
		else
		{
			res = (num)*(num-1)*(num-2);
		}
		
		System.out.println(res);

	}

}
