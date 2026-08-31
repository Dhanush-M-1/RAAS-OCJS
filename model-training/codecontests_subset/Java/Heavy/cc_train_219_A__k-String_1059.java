import java.util.Scanner;

public class kString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String str = sc.next();
		if(n ==1) {
			System.out.println(str);
			return;
		}

		int len = str.length();

		if(len % n != 0) {
			System.out.println("-1");
			return;
		}	

		final int N = 26;
		int[] arr = new int[N];

		for(int i=0; i<len; i++) {
			int index = ((int)str.charAt(i) - 97);
			arr[index]++;
		}

		for(int i=0; i<N; i++) {
			if(arr[i]%n !=0){
				System.out.println("-1");
				return;
			}
		}

		String ans = "";
		for(int i=0; i<n; i++) {
			for(int j=0; j<N; j++) {
				for(int k = 0; k< arr[j]/n; k++){
					char ch = (char)(j + 97);
					ans+=ch;
				}
			}
		}

		System.out.println(ans);
	}
}