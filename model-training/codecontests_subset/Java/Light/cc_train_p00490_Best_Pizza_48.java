import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		double best,bestc,sumc,sump;
		int on = sc.nextInt();
		int onc[] = new int[on];
		int basep = sc.nextInt();
		int onp = sc.nextInt();
		int basec = sc.nextInt();
		for(int i=0;i<on;i++){
			onc[i]=sc.nextInt();
		}
		Arrays.sort(onc);
		sumc=basec;//カロリーの合計
		sump=basep;//金額の合計
		best=basec/basep;//生地の1ドル当たりのカロリー
		for(int i=on-1;i>=0;i--){
			sumc+=onc[i];
			sump+=onp;
			bestc=sumc/sump;
			if(best<bestc){
				best=bestc;
			}
			//System.out.println(sumc+""+sump+""+best);
		}
		System.out.println((int)best);
	}

}