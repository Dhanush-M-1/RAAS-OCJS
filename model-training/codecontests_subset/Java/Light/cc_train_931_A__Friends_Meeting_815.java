import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greed {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int dist=Math.abs(b-a);
		int sum=0;
		if(dist%2!=0) {
			int x =(dist+1)/2;
			while(x-->0)sum+=x;
			System.out.println(sum*2+(dist+1)/2);
		}
		else {
			int x =dist/2+1;
			while(x-->0)sum+=x;
			System.out.println((sum*2));
		}
		
	}
}
