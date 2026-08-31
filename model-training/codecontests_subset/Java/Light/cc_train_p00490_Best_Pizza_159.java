import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a=sc.nextInt(),b=sc.nextInt();//生地値段、トッピング値段
		int c=sc.nextInt();//生地カロリー
		int[] d=new int[n];//トッピングカロリー
		for(int i=0;i<n;i++){
			d[i]=sc.nextInt();
		}
		for(int i=0;i<d.length-1;i++){	//降順sort
            for(int j=0;j<d.length-i-1;j++){
            	if(d[j]<d[j+1]){
            		int s=d[j];
            		d[j]=d[j+1];
            		d[j+1]=s;
            	}
            }
		}
		int pt=0;
		int ans=0;
		int bp=0;
		for(int i=0;i<n;i++){
			pt+=d[i];
			bp=(c+pt)/(a+(i+1)*b);//1ドルあたりのカロリー数
			if(bp>ans)ans=bp;
		}
		System.out.println(ans);
	}
}