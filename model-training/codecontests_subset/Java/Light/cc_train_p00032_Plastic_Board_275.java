import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tyoucount = 0;
		int hisicount = 0;
		while(sc.hasNext()){
			String[] input = sc.next().split(",");
			int hen1 = Integer.valueOf(input[0]);
			int hen2 = Integer.valueOf(input[1]);
			int taikakusen = Integer.valueOf(input[2]);
			if(taikakusen*taikakusen == hen1*hen1 + hen2*hen2){
				tyoucount++;
			}else if(hen1 == hen2){
				hisicount++;
			}
		}
		System.out.printf("%d\n%d\n",tyoucount,hisicount);
		sc.close();
	}
}