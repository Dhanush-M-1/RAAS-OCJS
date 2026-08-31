import java.io.DataInputStream;
import java.io.IOException;
import java.util.Scanner;


public class a379 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Scanner input=new Scanner(System.in);
		int a=input.nextInt();
		int b=input.nextInt();
		int x=a,c=0;
		int sum=0;
		while(x>0)
		{sum=sum+x;
		c=c+x%b;
		if(c>=b)
			{x=x+b;
			c=c%b;
			}
		x=x/b;
			}
		System.out.println(sum);

	}

}
