
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class WinOrFreeze_R107C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		if(n == 1)
		{
			System.out.println(1);
			System.out.println(0);
			return;
		}
		ArrayList<Long> arr = new ArrayList<>();
		int root =(int) Math.ceil(Math.sqrt(n));
		for(int i=2;i <= root;i++)
		{
			while(n % i == 0)
			{
				arr.add(1l*i);
				n/=i;
			}
		}
		if(n != 1)
			arr.add(n);
//		System.out.println(arr);
		PrintWriter pw = new PrintWriter(System.out);
		if(arr.size() == 1)
		{
			pw.println(1);
			pw.println(0);
		}
		else
			if(arr.size() > 2)
			{
				pw.println(1);
				pw.println(1l*arr.get(1) * arr.get(0));
			}
			else
			{
				pw.println(2);
			}
		pw.flush();
	}

}
