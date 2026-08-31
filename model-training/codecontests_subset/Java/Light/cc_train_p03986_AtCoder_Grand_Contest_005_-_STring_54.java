import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader input =new BufferedReader (new InputStreamReader (System.in));
		String str = input.readLine( );

		while(str.contains("ST")){
			if(str.indexOf("T")>str.length()/2-1){
				str = "";
			}else{
				str = str.replace("ST", "");
			}
		}

		System.out.println(str.length());

	}
}
