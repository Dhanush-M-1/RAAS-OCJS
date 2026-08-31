import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF776A {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens = bf.readLine().split(" ");
		String one = tokens[0];
		String two = tokens[1];
		System.out.println(one + " " + two);
		int n = Integer.valueOf(bf.readLine());
		for (int i=0;i<n;i++){
			tokens = bf.readLine().split(" ");
			String victim = tokens[0];
			String newb = tokens[1];
			if (one.equals(victim)){
				one = newb;
			} else {
				two = newb;
			}
			System.out.println(one +" "+ two);
		}
	}
}
