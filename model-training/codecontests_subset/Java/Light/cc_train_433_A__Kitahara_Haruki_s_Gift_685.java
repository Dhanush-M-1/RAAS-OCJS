import java.util.*;
public class pra{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int _200 = 0;
		int _100 = 0;
		int sum = 0;
		while(n -- > 0){
			int item = s.nextInt();
			if(item == 100){
				_100++;
			}else{
				_200++;
			}

			sum+=item;
		}

		sum = sum/2;
		int req = sum/200;
		if(req <= _200){
			sum = sum % 200;
		}

		req = sum/100;
		if(req <= _100){
			sum = sum % 100;
		}

		if(sum == 0){
			System.out.print("YES");
		}else{
			System.out.print("NO");
		}

	}
}