import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		String[] card= {"S","H","C","D"};
		ArrayList<String> list=new ArrayList<String>();
		for(int j=0;j<=3;j++) {
			for(int i=1;i<=13;i++) {
				list.add(card[j]+" "+String.valueOf(i));
			}
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int count=0;

		while(n>count) {
			String m=br.readLine();
			list.remove(list.indexOf(m));
			count++;
		}

		for(String checked:list) {
			System.out.println(checked);
		}
	}

}

