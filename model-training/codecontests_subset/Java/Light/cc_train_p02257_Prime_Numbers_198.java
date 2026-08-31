import java.util.*;

class Main {
	public static void main(String args[]){
		ArrayList<Integer> ar = new ArrayList<Integer>();
		int cnt = 0;
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		for(int i = 0;i < size;i++){
			int num = sc.nextInt();
			if(hantei(num)){
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	
	private static boolean hantei(int x){
		int n = (int) Math.ceil(Math.sqrt((double)x));
		if(x == 2){
			return true;
		}
		for(int j = 2;j <= n;j++){
			if(x % j == 0){
				return false;
			}
		}
		return true;	
	}
	
}