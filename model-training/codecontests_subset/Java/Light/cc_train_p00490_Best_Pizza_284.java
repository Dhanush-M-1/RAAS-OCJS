import java.lang.reflect.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int A = scan.nextInt();
		int B = scan.nextInt();
		int c = scan.nextInt();
		int[] Di = new int[N];
		int y = 0, k = 0;
		double x = 0.0, pizza = 0.0;
		
		for(int i = 0; i < N; i++){
			Di[i] = scan.nextInt();
		}
		Arrays.sort(Di);
		
		pizza = (c + y) / (A + B * k);   //生地のみの１ドルあたりのカロリー
		for(int i = N-1; i >= 0; i--){
			y += Di[i];   //トッピングをのせていく
			k++;   //トッピング数をカウント
			x = (c + y) / (A + B * k);
			if(pizza <= x){
				pizza = x;
			}else break;
		}
		
		System.out.println((int)pizza);
	}
}