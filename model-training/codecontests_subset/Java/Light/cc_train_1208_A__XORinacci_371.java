import java.util.Scanner;

public class Man19A
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0){
			int a = scan.nextInt();
			int b = scan.nextInt();
			int c = scan.nextInt();
			if(c%3==0){
				System.out.println(a);
			}else if(c%3==1){
				System.out.println(b);
			}else{
				System.out.println(a^b);
			}
		}
	}

}
