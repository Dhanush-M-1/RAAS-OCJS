import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//1行目入力
		int topping[] = new int[N];
		int BP = sc.nextInt();//2行目入力
		int OP = sc.nextInt();//2行目入力
		int BC = sc.nextInt();//3行目入力
		int price=0,calorie=0;
		int cpd=0;// calorie/dollar
		int great=0;//最高のcpd
		for(int i=0;i<N;i++){//トッピングカロリーを入力
			topping[i] = sc.nextInt();
		}
		Arrays.sort(topping);//カロリーを昇順に並び替える。
		price = BP;// 生地のみの値段を入れてしておく
		calorie = BC;//生地のみのカロリーを入れておく
		great= BP/BC;//生地のみを最高のピザと仮定。
		
		for(int i=N-1;i>=0;i--){//トッピングをカロリーの高い方から足す。
			price += OP;//全体の値段 
			calorie += topping[i];//全体のカロリー
			cpd = calorie/price;
			if(great<cpd){
				great = cpd;
			}
		}
		System.out.println(great);
	}
}