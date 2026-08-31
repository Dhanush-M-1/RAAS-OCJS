import java.text.DecimalFormat;
import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		DecimalFormat df=new DecimalFormat("0.00");
		int n=input.nextInt(),m=input.nextInt();
		int s[]=new int[105];
		for(int i=0;i<104;i++)  s[i]=0;
		for(int i=1;i<=n;i++){
			int x=input.nextInt();
			for(int j=1;j<=x;j++){
				int t=input.nextInt();
				s[t]=1;}
		}
		int k=0;
		for(int i=1;i<=m;i++)
			if(s[i]==0) {k=1;break;}
		if(k==0)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}