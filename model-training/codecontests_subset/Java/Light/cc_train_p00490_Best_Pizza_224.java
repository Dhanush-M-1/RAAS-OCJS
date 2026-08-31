import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] cpd=new int[n+1];	//cal/d
		int[] cal=new int[n];
		int a=sc.nextInt();	//生地の価格
		int b=sc.nextInt();	//トッピング1つの価格
		int c=sc.nextInt(); //生地の価格
		for(int i=0;i<n;i++) cal[i]=sc.nextInt();
		Arrays.sort(cal);
		for(int i=0;i<=n;i++){
			cpd[i]=c;
			for(int j=0;j<i;j++)	//iの数だけトッピングを追加する
				cpd[i]+=cal[n-1-j];	//大きな順に追加する
			cpd[i]/=(a+i*b);	//cpd=総カロリー/価格
		}
		Arrays.sort(cpd);
		System.out.println(cpd[n]);
		sc.close();
	}
}