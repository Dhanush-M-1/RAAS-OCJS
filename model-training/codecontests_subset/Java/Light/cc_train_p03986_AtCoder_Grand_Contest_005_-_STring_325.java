import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
//		Scanner s = new Scanner(System.in);
		int c,total=0,s=0;
		c=System.in.read();
		
		while(c!='\n'&&c!='\r')
		{
			total++;
			if(c=='S')
				s++;
			else
			{
				if(s>0)
				{
					s--;
					total-=2;
				}
			}
			c=System.in.read();
		}
		
		System.out.println(total);
	}

}
