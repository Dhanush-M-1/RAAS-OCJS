import java.util.*;
import java.io.*;
public class ProbA {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] w = new int[n];
		int countOne = 0 , countTwo = 0;
		for(int i=0;i<n;i++){
			w[i] = scanner.nextInt();
			if(w[i]==100){
				countOne++;
			}else{
				countTwo++;
			}
		}
		if(countOne!=0 && countTwo!=0){
			if(countOne%2==0){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}else{
			if(countOne==0){
				if(countTwo%2==0){
					System.out.println("YES");
				}else{
					System.out.println("NO");
				}
			}else{
				if(countOne%2==0){
					System.out.println("YES");
				}else{
					System.out.println("NO");
				}
			}
		}
	}
}
