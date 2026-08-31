import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s[] = new int[13];
		int h[] = new int[13];
		int c[] = new int[13];
		int d[] = new int[13];
		for(int i=0;i<n;i++){
			String t = sc.next();
			if(t.equals("S")){
				int j = sc.nextInt();
				s[j-1]++;
			}else if(t.equals("H")){
				int j = sc.nextInt();
				h[j-1]++;
			}else if(t.equals("C")){
				int j = sc.nextInt();
				c[j-1]++;
			}else{
				int j = sc.nextInt();
				d[j-1]++;
			}
		}
		for(int i=0;i<13;i++){
			if(s[i]==0){
				int t = i+1;
				System.out.println("S "+t);
			}
		}
		for(int i=0;i<13;i++){
			if(h[i]==0){
				int t = i+1;
				System.out.println("H "+t);
			}
		}
		for(int i=0;i<13;i++){
			if(c[i]==0){
				int t = i+1;
				System.out.println("C "+t);
			}
		}
		for(int i=0;i<13;i++){
			if(d[i]==0){
				int t = i+1;
				System.out.println("D "+t);
			}
		}
	}

}