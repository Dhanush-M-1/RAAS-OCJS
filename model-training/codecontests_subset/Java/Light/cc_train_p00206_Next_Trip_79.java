import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true){
			int l=sc.nextInt();
			if(l==0)break;
			int ans=0;
			for(int i=0;i<12;i++){
				int m=sc.nextInt();
				int n=sc.nextInt();
				l-=(m-n);
				if(l<=0){
					if(ans>0)continue;
					ans=i+1;
				}
			}
			if(l<=0)System.out.println(ans);
			else System.out.println("NA");
		}
	}
}