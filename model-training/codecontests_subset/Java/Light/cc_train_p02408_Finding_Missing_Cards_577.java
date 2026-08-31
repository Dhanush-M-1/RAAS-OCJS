import java.util.Scanner;

public class Main{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int work,n = sc.nextInt();
		String str;
		int[] s = new int[13];
		int[] h = new int[13];
		int[] c = new int[13];
		int[] d = new int[13];
		for(int i = 0; i < n; i++){
			str = sc.next();
			work = sc.nextInt();
			if(str.equals("S")){
				s[work-1] = 1;
			}else if(str.equals("H")){
				h[work-1] = 1;
			}else if(str.equals("C")){
				c[work-1] = 1;
			}else if(str.equals("D")){
				d[work-1] = 1;
			}
				
		}
		for(int i = 0; i < 13; i++){
			if(s[i] == 0){
				System.out.println("S " + (i+1));
			}
		}
		for(int i = 0; i < 13; i++){
			if(h[i] == 0){
				System.out.println("H " + (i+1));
			}
		}
		for(int i = 0; i < 13; i++){
			if(c[i] == 0){
				System.out.println("C " + (i+1));
			}
		}
		for(int i = 0; i < 13; i++){
			if(d[i] == 0){
				System.out.println("D " + (i+1));
			}
		}
		
	}
}