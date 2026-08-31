import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class NYC {

	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		long candles = Long.parseLong(st.nextToken());
		long burntcandles = 0;
		long candlesneeded = Long.parseLong(st.nextToken());
		long hoursburnt = 0;
		while(candles>0){
			hoursburnt+=candles;
			burntcandles+=candles;
			candles=(long) Math.floor(((double)burntcandles)/((double)candlesneeded));
			burntcandles-=(candles*candlesneeded);
		}
		System.out.println(hoursburnt);
	}
}
