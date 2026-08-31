import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R202_Div2_C //Name: Mafia
{
	public static void main(String[] args) {
		Scanner      in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		solve(in, out);
		out.close();
		in.close();	
	}
	
	public static void solve(Scanner in, PrintWriter out)
	{
		int n = in.nextInt();	
        int a; 
        long sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++)
        {
            a = in.nextInt();
            sum += a;
            max = Math.max(max, a);
        }
        long cnt = sum / (n - 1);
        if (sum % (n - 1) > 0) cnt++;

        cnt = Math.max(cnt, max);
		
		out.println(cnt);		
	}
}
