import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n,i,m,j;
		boolean flg;
		n = sc.nextInt();
		int cnt =0;
		for(i=0;i<n;i++){
			flg = true;
			m = sc.nextInt();
			if(m<2) flg = false;
			if(m==2){
				cnt++;
				continue;
			}
			if(m%2==0) flg =false;
			double sqrtM = Math.sqrt(m);
			for(j=3;j<=sqrtM;j+=2){
				if(m%j==0) {
					flg = false;
					break;
				}
			}
			if(flg==true) cnt++;
	}
    System.out.println(cnt);

}}


