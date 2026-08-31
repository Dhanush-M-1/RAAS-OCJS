import java.util.Scanner;

public class problem117 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//int z = n;
		int m = sc.nextInt();
		int count =0;
		int w=0;
		count = count + n;
	    while(n>=m)
	    {
	    	count = count + n/m;
	    	n = n/m + n%m;
	    }
	    System.out.println(count);
	    
	 

	}

}
