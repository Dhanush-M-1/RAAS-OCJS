import java.util.Scanner;


public class cards {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner input=new Scanner(System.in);
		n=input.nextInt();
		String abc;
		int count=0,count1=0,count2=0;
		abc=input.next().trim();
		for(int i=0;i<n;i++)
		{
			if(abc.charAt(i)=='A')
			count++;
			else if(abc.charAt(i)=='F')
				count1++;
			else if(abc.charAt(i)=='I')
				count2++;
			
			
		}
		if(count2>1)
		{
			System.out.println("0");
		}
		else if(count2==1)
		{
			System.out.println(""+count2);
		}
		else 
		{
			System.out.println(""+count);
		}
		

	}

}
