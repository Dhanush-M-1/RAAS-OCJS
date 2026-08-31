import java.util.Scanner;

public class Main {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in); 
		
		int n = scan.nextInt();
		
		int H, S, D, C;
		int h[] = new int[14];
		int s[] = new int[14];
		int d[] = new int[14];
		int c[] = new int[14];
		
		for(int i = 1; i <= n; i++){
			String mark = scan.next();
			if(mark.equals("H")){
				h[scan.nextInt()] = 1;
			}else if(mark.equals("S")){
				s[scan.nextInt()] = 1;
			}else if(mark.equals("D")){
				d[scan.nextInt()] = 1;
			}else if(mark.equals("C")){
				c[scan.nextInt()] = 1;
			}
		}
		
		for(int i = 1; i <= 13; i++){
			if(s[i] != 1){
				System.out.println("S " + i);
			}
		}
		for(int i = 1; i <= 13; i++){
			if(h[i] != 1){
				System.out.println("H " + i);
			}
		}
		for(int i = 1; i <= 13; i++){
			if(c[i] != 1){
				System.out.println("C " + i);
			}
		}
		for(int i = 1; i <= 13; i++){
			if(d[i] != 1){
				System.out.println("D " + i);
			}
		}
	}
}
	
	