import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true){
			int n = sc.nextInt();
			if(n==0) break;
			
			int cnt = 0;
			int[] m = new int[n];
			for(int i=0;i<n;i++){
				String s = sc.next();
				if(s.equals("ru")) m[i] = 1;
				else if(s.equals("lu")) m[i] = -2;
				else if(s.equals("rd")) m[i] = -1;
				else if(s.equals("ld")) m[i] = 2;
			}
			
			for(int i=0;i<n-1;i++){
				if(m[i]*m[i+1]==-2){
					cnt++;
					i++;
				}
			}
			
			System.out.println(cnt);
		}
	}
	
}