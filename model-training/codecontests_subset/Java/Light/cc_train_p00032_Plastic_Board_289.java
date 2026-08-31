import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static String strArray[];
	static int re=0, hishi=0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;

		while(null != (str=br.readLine())){
			strArray = str.split(",");
			box();
		}

		System.out.println(re);
		System.out.println(hishi);

	}

	static void box(){
		int l1 = Integer.parseInt(strArray[0]);
		int l2 = Integer.parseInt(strArray[1]);
		int t = Integer.parseInt(strArray[2]);

		if(l1 == l2){
			hishi++;
		}else if((Math.pow(l1, 2) + Math.pow(l2, 2)) == Math.pow(t, 2)){
			re++;
		}

	}

}