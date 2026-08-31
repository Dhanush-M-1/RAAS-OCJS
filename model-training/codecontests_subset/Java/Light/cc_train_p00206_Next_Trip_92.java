import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true){
			int a = sc.nextInt();
			if(a==0)break;
			int[] n = new int[12];
			boolean flag = true;
			int sum = 0;
			
			for(int i=0;i<12;i++){
				n[i] = sc.nextInt() - sc.nextInt();
			}
			
			for(int i=0;i<12;i++){
				sum += n[i];
				if(sum>=a){
					System.out.println((i+1));
					flag = false;
					break;
				}
			}
			if(flag==true)System.out.println("NA");
		}
	}	
}