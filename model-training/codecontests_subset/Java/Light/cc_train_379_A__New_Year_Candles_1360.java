import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class NewYearCandles {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));

		String[] arr=(inp.readLine()).split(" ");
		int a=Integer.parseInt(arr[0]);
		int b=Integer.parseInt(arr[1]);		
		int result=((a*b)-1)/(b-1);
		System.out.println(result);
	}

}
