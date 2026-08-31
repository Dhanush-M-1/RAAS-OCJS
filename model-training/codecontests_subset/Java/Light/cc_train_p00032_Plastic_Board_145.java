import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int rect = 0;
		int dia = 0;
		while(true){
			String tmp = br.readLine();
			
			if(tmp == null){
				break;
			}
			
			String[] tmpArray = tmp.split(",");
			
			int a = Integer.parseInt(tmpArray[0]);
			int b = Integer.parseInt(tmpArray[1]);
			int c = Integer.parseInt(tmpArray[2]);
			///System.out.println(a + " "+ b + " "+ c);
			if(a*a + b*b == c*c){
				rect++;
			}
			if(a == b){
				dia++;
			}
			
		}
		
		System.out.println(rect);
		System.out.println(dia);
	}

}