import java.util.*;

public class A{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int ave = (n + m) / 2;
			int nn = n - ave;
			int mm = m - ave;
			if(nn < 0){nn = -nn;}
			if(mm < 0){mm = -mm;}
			int ans = 0;
			for(int i = 1;i <= nn;i ++){
				ans = ans + i;
			}
			for(int i = 1;i <= mm;i ++){
				ans = ans + i;
			}
			System.out.println(ans);
		}
	}
}