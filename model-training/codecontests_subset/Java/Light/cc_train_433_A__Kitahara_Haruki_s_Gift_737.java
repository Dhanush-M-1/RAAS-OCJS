import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KitaharaHarukisGift_433A {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = new Integer(br.readLine());
		int[] a = new int[2];
		StringTokenizer s = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			if(new Integer(s.nextToken()) == 100)
				a[0]++;
			else
				a[1]++;
		}
		if((a[0] == 0 && a[1]%2 != 0) || (a[0] %2 != 0))
			System.out.println("NO");
		else
			System.out.println("YES");
	}

}
