import java.util.*;
public class Main {


	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int nos = scan.nextInt();
		int sum = 0;
		for( int i=0 ; i<nos; i++)
		{
			int input = scan.nextInt();
			sum+=input-1;
		}
		System.out.println(sum);
		scan.close();
	}

}
