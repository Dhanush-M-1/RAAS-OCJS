import java.util.Scanner;


public class Remainder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		String str = sc.next();
		long ans = 0;
		int j=0;
		for(int i=n-1;i>=0;i--){
			char ch = str.charAt(i);
			if(j<y){
				if(ch == '1')
					ans++;
			}
			else if(j==y){
				if(ch == '0')
					ans++;
			}
			else if(j<x){
				if(ch == '1')
					ans++;
			}
			else if(j==x){
//				if(ch == '0')
//					ans++;
				break;
			}
			j++;
		}
		System.out.println(ans);
		
	}

}
