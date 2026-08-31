import java.util.HashMap;
import java.util.Scanner;

class Main{



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);			//文字の入力
		long n = sc.nextLong();
		long p = sc.nextLong();

		HashMap<Long, Long> insu = new HashMap<Long,Long>();
		long c = 2;
		if(p == 1){
			System.out.println(1);
			return;
		}
		if(n == 1){
			System.out.println((long)p);
			return;
		}

		while(true){				//素因数分解
			if(p < c*c){
				break;
			}

			if(p%c == 0){
				if(insu.get(c) != null){
					long nn = insu.get(c) + 1;
					insu.put(c, nn);
					p /= (long)c;
					c = 2;
				}else{
					long nn = 1;
					insu.put(c, nn);
					p /= (long)c;
					c = 2;
				}
			}else{

				c++;
			}
		}

		if(insu.get(p) != null){
			long nn = insu.get(p) + 1;
			insu.put(p, nn);
		}else{
			long nn = 1;
			insu.put(p, nn);
		}

//		for(long i:insu.keySet()){				//確認
//			System.out.println("素数 "+i + " 数 "+insu.get(i));
//		}		
//		System.out.println();


		//
		//
		//		for(long i:insu.keySet()){				//整理
		//			if(insu.get(i) >= 2*n){
		//				insu.put(i*i, insu.get(i)/2);
		//			}
		//		}

		long setnum = 0;
		for(long i:insu.keySet()){			
			
			setnum++;
		}
		
		

		if(n <= setnum){
			long min = (long)1000000000*1000000;
			long keynum = (long)1;
			for(long i:insu.keySet()){				//数が3つ以上のを見つける
				min = (long)Math.min(min, i);
				if(insu.get(i) >= n){
//					System.out.println((long)Math.pow(i, insu.get(i)/setnum));
					keynum *= (long)Math.pow(i, insu.get(i)/n);
				}
			}

			if(keynum!= 1){
				System.out.println((long)keynum);
			}else{
				System.out.println((long)1);

			}

		}else{
			long min = (long)1000000000*1000000;

			long keynum = (long)1;
			for(long i:insu.keySet()){				//数が3つ以上のを見つける
				min = (long)Math.min(min, i);
				if(insu.get(i) >= n){
					keynum *= (long)Math.pow(i, insu.get(i)/n);
				}
			}

			if(keynum!= 1){
				System.out.println((long)keynum);
			}else{
				System.out.println((long)1);

			}
		}

	}


}

class Pair implements Comparable{
	int from;
	int end;
	@Override
	public int compareTo(Object other) {
		Pair otherpair = (Pair)other;

		return end - otherpair.end;
	}
}
