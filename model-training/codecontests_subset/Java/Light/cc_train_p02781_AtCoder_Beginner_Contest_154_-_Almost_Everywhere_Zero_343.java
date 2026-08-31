import java.util.*;

class Main {
	Scanner sc;
	String N;
	int K;
	
	private void calc() {
		sc = new Scanner(System.in);
		N = sc.next();
		K = sc.nextInt();

		switch (K) {
		case 1:
			System.out.println(case1(N));
			break;
		case 2:
			System.out.println(case2(N));
			break;
		case 3:
			System.out.println(case3(N));
		}
	}

	private int case1(String n) {
		int s = 0;
		int len = n.length();
		int d = n.charAt(0) - '0';
		s = d; // 最上位桁のみある場合
		// 最上位桁が 0 ならいずれかの桁が 1～9
		s += 9 * (len-1);
		return s;
	}

	private int case2(String n) {
		// K=2 の場合
		int s = 0;
		int len = n.length();
		int d = n.charAt(0) - '0';
		// 最上位桁が1以上で小さい場合
		s = (d-1)*(len-1)*9;
		// 最上位桁が一致する場合, 残った数字に対して K=1 を適用
		s += case1(trim(n));
		// 最上位桁が0の場合 nCr(len-1,2) * 9^2
		if (len > 2) s += (len-1)*(len-2)/2*9*9;
		return s;
	}

	private int case3(String n) {
		int s = 0;
		int len = n.length();
		int d = n.charAt(0) - '0';
		s = (d-1)*(len-1)*(len-2)/2*9*9;
		s += case2(trim(n));
		if (len > 3) s += (len-1)*(len-2)*(len-3)/6*9*9*9;
		return s;
	}

	private String trim(String n) {
		int i = 1;
		for (; i < n.length(); i++) {
			if (n.charAt(i) != '0') break;
		}
		if (i == n.length()) return "0";
		return n.substring(i);
	}
	
	public static void main(String[] args) {
		new Main().calc();
	}
}
