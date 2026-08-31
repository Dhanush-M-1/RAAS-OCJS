import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){

	Scanner stdIn = new Scanner(System.in);
	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	int n = stdIn.nextInt();

	int ans = 0;
	for(int i = 0;i < n;i++){
		int a = stdIn.nextInt();
		ans += a - 1;
	}
	System.out.println(ans);
		
	}
}