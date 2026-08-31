import java.util.*;
public class Solve {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   //	System.out.println("");

		Scanner o=new Scanner(System.in);

		int sum=0;
		for(int i=0;i<5;i++)
		{
			int a=o.nextInt();
			
			sum+=a;
			
		}
			
		if(sum%5==0 && sum!=0)
		{
			System.out.println(sum/5);
		}
		else
		{
			System.out.println(-1);
		}
		
		
		
		//end
	}
	

}
