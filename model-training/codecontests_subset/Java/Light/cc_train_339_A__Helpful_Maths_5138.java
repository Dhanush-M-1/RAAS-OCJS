
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class CodeChef {
	public static void main(String[] args) throws NumberFormatException, IOException{
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String[]  str = str1.split("\\+");
		Arrays.sort(str);
		String str2="";
		for(String c:str){
			str2=str2+"+"+c;
		}
		System.out.println(str2.substring(1, str2.length()));
	}
}