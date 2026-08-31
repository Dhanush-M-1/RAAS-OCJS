import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO ?????????????????????????????????????????????
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			String[] tmpArray = br.readLine().split(" ");
			int h = Integer.parseInt(tmpArray[0]);
			int m = Integer.parseInt(tmpArray[1]);
			int s = Integer.parseInt(tmpArray[2]);
			
			if(h == -1 && m == -1 && s == -1){
				break;
			}
			
			int sumOfSecond = h*3600 + m*60 + s;
			int remainTime = 120*60 - sumOfSecond;
			int remain3mode = remainTime*3;
			
			System.out.printf("%02d:%02d:%02d\n", hour(remainTime), minute(remainTime), second(remainTime));
			System.out.printf("%02d:%02d:%02d\n", hour(remain3mode), minute(remain3mode), second(remain3mode));
		}
	}
	
	static int hour(int second){
		return second/3600;
	}
	
	static int minute(int second){
		return (second%3600)/60;
	}
	
	static int second(int second){
		return (second%60);
	}

}