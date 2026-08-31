import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++){
			String s = sc.next();
			int count = 0;
			int a, b, max;
			
			while(s.length()>1){
				max = 0;
				for(int j=1;j<s.length();j++){
					a = Integer.valueOf(s.substring(0,j));
					b = Integer.valueOf(s.substring(j,s.length()));
					max = Math.max(max, a*b);
				}
				s = Integer.toString(max);
				count++;
			}
			System.out.println(count);
		}
	}	
}