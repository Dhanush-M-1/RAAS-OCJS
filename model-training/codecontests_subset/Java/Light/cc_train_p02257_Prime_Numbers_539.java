import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int cnt=0;
		for(int i=0;i<n;i++){
			int m=s.nextInt();
			int c=0;
			for(int j=2;j<=Math.sqrt(m);j++){
				if(m%j==0) c=1;
			}
			if(c==0) cnt++;
		}
		System.out.println(cnt);
	}
}
