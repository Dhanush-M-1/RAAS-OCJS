import java.util.Scanner;

class Main{

	static int[] p;
	static	int N ;

	public static void main(String[] args) {


		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		p = new int[N+1];
		int ans = 0;

		for(int i = 1;i < N+1;i++){
			p[i] = scanner.nextInt();
		}

		for(int i = 1;i < N;i++){
			if(p[i] == i){
				int c = p[i];
				p[i] = p[i + 1];
				p[i+1] = c;
				ans++;
			}
		}
		if(p[N]==N){
			ans++;			

		}
		System.out.println(ans);

	}


}

class Pair implements Comparable{
	int from;
	int middle;
	int end;
	@Override
	public int compareTo(Object other) {
		Pair otherpair = (Pair)other;

		return end - otherpair.end;
	}
}



