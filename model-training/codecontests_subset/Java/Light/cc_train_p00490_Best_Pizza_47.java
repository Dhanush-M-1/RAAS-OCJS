import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a=sc.nextInt(),b=sc.nextInt();
		int c=sc.nextInt();
		int[] d=new int[n];
		for(int i=0;i<n;i++){
			d[i]=sc.nextInt();
		}
		for(int i=0;i<d.length-1;i++){
            for(int j=0;j<d.length-i-1;j++){
            	if(d[j]<d[j+1]){
            		int s=d[j];
            		d[j]=d[j+1];
            		d[j+1]=s;
            	}
            }
		}
		int pt=d[0];
		int ans=(c+pt)/(a+b);
		int bp=0;
		for(int i=1;i<n;i++){
			pt+=d[i];
			bp=(c+pt)/(a+(i+1)*b);//1ドルあたりのカロリー数
			if(bp>ans)ans=bp;
		}
		System.out.println(ans);
	}
}