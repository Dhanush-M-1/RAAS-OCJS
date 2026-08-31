import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {

	public static void main(String[] args) throws IOException{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer skt=new StringTokenizer(in.readLine());
		
		long a=Long.parseLong(skt.nextToken());
		long b=Long.parseLong(skt.nextToken());
		
		if(a==b&&a%2!=0) {
			
			System.out.println(a);
		}else {
			System.out.println("2");
		}
		
		

	}

}
