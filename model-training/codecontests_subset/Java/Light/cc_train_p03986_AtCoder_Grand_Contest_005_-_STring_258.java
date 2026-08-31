import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scan = new Scanner(System.in);
		String X =scan.next();

		char s;
		int cnt=0;
		int max=0;

		for(int i=0;i<X.length();i++){
			s=X.charAt(i);
			if(s=='S'){cnt--;}
			else{cnt++;}
			if(cnt>max){
				max = cnt;
			}
		}

		System.out.println(max*2);

	}

}


//文字列の左から順に特定の文字列を探す