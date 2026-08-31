import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int s[] = new int[13];
		int h[] = new int[13];
		int c[] = new int[13];
		int d[] = new int[13];
		for(int i=0;i<13;i++){
			s[i]=0;
			h[i]=0;
			c[i]=0;
			d[i]=0;
		}
		for(int i=0;i<n;i++){
			String cd=sc.next();
			int cn=sc.nextInt();
			switch(cd){
			case "S":
				s[cn-1]++;
				break;
			case "H":
				h[cn-1]++;
				break;
			case "C":
				c[cn-1]++;
				break;
			case "D":
				d[cn-1]++;
			}
		}
		for(int i=0;i<13;i++){
			if(s[i]==0){
				System.out.println("S "+(i+1));
			}
		}
		for(int i=0;i<13;i++){
			if(h[i]==0){
				System.out.println("H "+(i+1));
			}
		}
		for(int i=0;i<13;i++){
			if(c[i]==0){
				System.out.println("C "+(i+1));
			}
		}
		for(int i=0;i<13;i++){
			if(d[i]==0){
				System.out.println("D "+(i+1));
			}
		}
	}
}