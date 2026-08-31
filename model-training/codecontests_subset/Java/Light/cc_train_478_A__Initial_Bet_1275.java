import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] in1 = in.readLine().split(" ");
		int count = 0;
		for(int i = 0; i < in1.length; i++){
			count += Integer.parseInt(in1[i]);
		}
		if(count != 0 && count%5 == 0){
			System.out.print(count/5);
		}
		else{
			System.out.print(-1);
		}
	}

}
