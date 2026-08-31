import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Codeforces {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0){
			long n= in.nextInt();
			int  to =0;
			Set<Long> set = new HashSet<>();
			boolean flag = false;
			while(true){
				if(n==1) break;
				if(set.contains(n)){
					flag= true;
					break;
				}
				set.add(n);
				if(n%6==0){
					n = n/6;
				} else {
					n = n*2;
				}
				to++;
			}
			
			if(flag){
			  System.out.println(-1);	
			} else {
				System.out.println(to);	
			}
		}
		
		
	}



}