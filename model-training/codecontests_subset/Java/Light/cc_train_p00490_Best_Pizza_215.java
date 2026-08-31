import java.util.*;
public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//トッピングの種類
		int baseprice = sc.nextInt();	//生地の値段
		int	topprice  = sc.nextInt();	//トッピングの値段
		int basecal = sc.nextInt();	//生地のカロリー
		int topcal [] = new int[N];
		for(int i = 0; i < N; i++){
			topcal [i] = sc.nextInt();	//トッピングのカロリー
		}
		Arrays.sort(topcal);
		for(int i=N;i>0;i--){
			if((basecal+topcal[i-1])/(baseprice+topprice)>=(basecal/baseprice)){
				basecal += topcal[i-1];
				baseprice += topprice;
				}
			}
		System.out.println(basecal/baseprice);
	}

}