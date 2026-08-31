
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static char[] c = {'a','b','c','d','e','f','g','h','i','j'}; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		outHyojun(n, 1, 0, "");
	}
	public static void outHyojun(int n,int currentDepth,int currentMaxC,String currentString) {
		int cm = currentMaxC;
		
		if(currentDepth <= n) {
			for(int i = 0 ; i < currentMaxC+1 ; i++) {
				if(i < currentMaxC) {
					outHyojun(n, currentDepth+1, currentMaxC, currentString+ c[i]);
				}else {
					outHyojun(n, currentDepth+1, currentMaxC+1, currentString + c[i]);
				}
			}
		}else {
			System.out.println(currentString);
		}
	}
}
