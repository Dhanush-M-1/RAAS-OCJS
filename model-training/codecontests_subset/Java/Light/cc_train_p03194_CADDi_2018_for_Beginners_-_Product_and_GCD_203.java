import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long k = sc.nextLong();
		long num = sc.nextLong();
		List<Long> primes = primeFactor(num);
		List<Long> oks = new ArrayList<Long>();
//		System.out.println(Arrays.toString(primes.toArray()));
		for(int i=0;i<primes.size();i++) {
			int ind =primes.lastIndexOf(primes.get(i));

			if(ind - i  +1 >= k) {
				for(int be = 0; be<(ind-i+1)/k ; be++)oks.add(primes.get(i));
//				System.out.println("get:"+primes.get(i));
			}
			i = ind;
		}
		long ans=1;
		for(long pr:oks) {
			ans*=pr;
		}
		System.out.println(ans);
	}

	/**<h1>素因数分解のリストを作る</h1>
	 * @param num ： 素因数分解する値 (>=0)
	 * @return<b>List<Long></b> ： 素因数分解のリスト
	 */
	public static final List<Long> primeFactor(long num) {
		final List<Long> list = new ArrayList<Long>();
		if (num < 2) {    //n が2以上とわかっていれば、ここは不要
			return list;
		}

//		long fin = num/2+1;

		while (num != 1 && num % 2 == 0) {    //2で割り切れるだけ割る
			list.add(2l);
			num /= 2 ;        //÷2 の代わり
		}

		for (long i = 3; i * i <= num; i += 2) {    //奇数のみ [O(√n[/2])で可]
			while (num % i == 0) {
				list.add(i);
				num /= i;
			}
		}

		if (num != 1) {
			list.add(num);
		}
		return list;
	}


}
