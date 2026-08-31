import java.util.Scanner;

public class BookReading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int totalPage = sc.nextInt();
		int initSpeed = sc.nextInt();
		int maxSpeed = sc.nextInt();
		int acc = sc.nextInt();
		int revised = sc.nextInt();
		int days=0,pages=0,flag=0,c=0;
		while(pages<totalPage)
		{
			int temp = initSpeed+(days*acc);
			if(temp>maxSpeed)
				flag=1;
			if(flag==1 && c==1)
				pages+=maxSpeed-revised;
			else if(flag==0 && c==1)
				pages+=temp-revised;
			else
			{
				pages+=temp;
			}
			c=1;
			days++;
		}
		System.out.println(days);
		sc.close();
	}

}
