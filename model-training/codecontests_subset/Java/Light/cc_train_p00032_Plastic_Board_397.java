import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = null;
		int cup = 0;
		int mun = 0;
		int ter = 0;
		String[] rrr;
		int st = 0,sr = 0;
		int mon = 0;
		int syo=0,hisi=0;
		
		
		while(true){
			
			try {
				tmp = br.readLine();
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			
			if(tmp == null){
				break;
			}
			
			if(tmp.equals("")){
				break;
			}
			
			rrr = tmp.split(",");
			int a = Integer.parseInt(rrr[0]);
			int b = Integer.parseInt(rrr[1]);
			int c = Integer.parseInt(rrr[2]);
			
			if(a == b){
				syo++;
			}
			if((a*a+b*b) == c*c){
				hisi++;
			}
		}
		System.out.println(hisi);
		System.out.println(syo);

	}

}