

import java.util.Scanner;

public class Stones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c,stones=0;
		Scanner s = new Scanner(System.in);
		int t=s.nextInt();
		while(t!=0)
		{
			a=s.nextInt();
			b=s.nextInt();
			c=s.nextInt();
			while(b>=1 && c>=2)
			{
				b--;
				c-=2;
				stones+=3;
			}
			while(b>=2 && a>=1)
			{
				a--;
				b-=2;
				stones+=3;
			}
			System.out.println(stones);
			stones=0;
			t--;
		}
		

	}

}
