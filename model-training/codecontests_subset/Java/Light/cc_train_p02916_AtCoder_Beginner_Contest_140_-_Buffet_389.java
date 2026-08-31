import java.util.*;
public class Main {
	Scanner sc = new Scanner(System.in);
	int a,b,c,d,e,f,k,l,m,n,x,y,z;
	int ans;
	int[] chk;
	String[] S;

	Main(){
		// 整数の入力
		n = sc.nextInt();
		chk = new int[n];

		int before = sc.nextInt();
		for(int i=1;i<n;i++){
			int after = sc.nextInt();
			if(before==after-1){
				chk[before-1]=1;
			}
			before=after;
		}
		for(int i=0;i<n;i++)ans+=sc.nextInt();

		for(int i=0;i<n-1;i++){
			int num = sc.nextInt();
			if(chk[i]==1)ans+=num;
		}

		// 出力
		System.out.println(ans);
	}

	public static void main(String[] args){
		new Main();
	}
}