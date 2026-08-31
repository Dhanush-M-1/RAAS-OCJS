import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int a = kb.nextInt();int b = kb.nextInt();int c = kb.nextInt();
		if(a==0&&b==0&&c==0){
			System.out.println(-1);
			return;
		}else if(a==0&&b==0&&c!=0){
			System.out.println(0);
			return;
		}
		if(a==0){
			System.out.printf("1\n%.6f",(-(double)c)/(double)b);
			return;
		}
		double check = (Math.pow(b,2)-4.0*(double)(a)*(double)(c));
		if(check<0){
			System.out.println(0);
			return; 
		}
		double ans1 = (((double)(-b))+(Math.sqrt(check)))/(2.0*(double)(a));
		double ans2 = (((double)(-b))-(Math.sqrt(check)))/(2.0*(double)(a));
		if(ans1<ans2)
			System.out.printf("2\n%.6f\n%.6f",ans1,ans2);
		else if(ans1>ans2)
			System.out.printf("2\n%.6f\n%.6f",ans2,ans1);
		else
			System.out.printf("1\n%.6f",ans1);
		
	}
}
