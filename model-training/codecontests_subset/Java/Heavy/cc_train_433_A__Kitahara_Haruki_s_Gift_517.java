import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class EsA {

	public static void main(String[] args) throws IOException {
		//Scanner s = new Scanner(System.in);
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		String y = s.readLine();
		int n = Integer.parseInt(y);
		y= s.readLine();
		String[] aaa = y.split(" ");
		int n100=0;
		int n200=0;
		for(int i=0; i<n; i++){
			int x = Integer.parseInt(aaa[i]);
			if(x==100) n100 +=1;
			else n200 +=1;
		}
		
		if(n100%2==0 && n200%2==0){
			System.out.println("YES");
			return;
		}else if(n100%2==0){
			if(n100>=2){
				System.out.println("YES");
				return;
			}
		}else if(n200%2==0){
			System.out.println("NO");
			return;
		}else{
			System.out.println("NO");
			return;
		}
		System.out.println("NO");
	}

}
