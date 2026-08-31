import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongInteger3 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(reader.readLine());
		String[] st = reader.readLine().split(" ");
		long[] str = new long[count];
		int i = 0;
		while(count-- > 0) {
			str[i] = Long.parseLong(st[i]);
			i++;
		}
		solve(str);
	}
	
	private static void solve(long[] ip) {
		
		if(ip.length == 1) {
			System.out.println(1+" "+1);
			System.out.println(0);
			System.out.println(1+" "+1);
			System.out.println(0);
			System.out.println(1+" "+1);
			System.out.println(-ip[0]);
		} else {
			System.out.println(1+" "+1);
			System.out.println(-ip[0]);
			System.out.println(1+" "+ip.length);
			System.out.print("0 ");
			for(int i = 1;i < ip.length; i++) {
				System.out.print(-(ip.length)*ip[i]+" ");
			}
			System.out.println();
			System.out.println(2+" "+ip.length);
			for(int i = 1 ; i < ip.length;i++) {
				System.out.print((ip.length-1)*ip[i]+" ");
			}
			System.out.println();
		}
		
	}

	
}
