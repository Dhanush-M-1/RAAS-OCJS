import java.util.*;

public class splitText {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int x=sc.nextInt();
		int y=sc.nextInt();
		
		int a=0;
		if((y*n)%100==0)
		{
			a=(y*n)/100;
		}
		else 
		{
			a=(y*n)/100;
			a+=1;
		}
		if(x>=a) {
			System.out.println(0);
		}else {
			System.out.println(a-x);
		}
  sc.close();
	}

}
