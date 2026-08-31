import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//トッピングの種類
		int baseprice = sc.nextInt();	//生地の値段
		int	topprice  = sc.nextInt();	//トッピングの値段
		int basecal = sc.nextInt();	//生地のカロリー
		int topcal [] = new int[N];
		for(int i = 0; i < N; i++){
			topcal [i] = sc.nextInt();	//トッピングのカロリー
		}
		for(int i = 0; i < N; i++){
			for(int k = 0; k < N; k++){
				if( topcal[i]>topcal[k]){
					int work = topcal[i];
					topcal[i] = topcal[k];
					topcal[k] = work;
				}
			}
		}
		//Arrays.sort(topcal);
		for(int i = 0;i < N;i++){
			if((basecal+topcal[i])/(baseprice+topprice)>=(basecal/baseprice)){
				basecal += topcal[i];
				baseprice += topprice;
				}
			}
		System.out.println(basecal/baseprice);
	}

}