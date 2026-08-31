import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int h,m,s,a,b;
		String ans[]=new String[3];
		String ans2[]=new String[3];
		while(true){
			h=sc.nextInt();
			m=sc.nextInt();
			s=sc.nextInt();
			if(h==-1 && m==-1 && s==-1) break;
			a=h*3600+m*60+s;
			a=120*60-a;
			b=a*3;

			if(a/3600==0)
				ans[0]="00";
			else if(a/3600<10)
				ans[0]="0"+Integer.toString(a/3600);
			else
				ans[0]=Integer.toString(a/3600);
			a=a%3600;

			if(b/3600==0)
				ans2[0]="00";
			else if(b/3600<10)
				ans2[0]="0"+Integer.toString(b/3600);
			else
				ans2[0]=Integer.toString(b/3600);
			b=b%3600;

			if(a/60==0)
				ans[1]="00";
			else if(a/60<10)
				ans[1]="0"+Integer.toString(a/60);
			else
				ans[1]=Integer.toString(a/60);
			a=a%60;

			if(b/60==0)
				ans2[1]="00";
			else if(b/60<10)
				ans2[1]="0"+Integer.toString(b/60);
			else
				ans2[1]=Integer.toString(b/60);
			b=b%60;

			if(a==0)
				ans[2]="00";
			else if(a<10)
				ans[2]="0"+Integer.toString(a);
			else
				ans[2]=Integer.toString(a);

			if(b==0)
				ans2[2]="00";
			else if(b<10)
				ans2[2]="0"+Integer.toString(b);
			else
				ans2[2]=Integer.toString(b);

			System.out.printf("%s:%s:%s\n",ans[0],ans[1],ans[2]);
			System.out.printf("%s:%s:%s\n",ans2[0],ans2[1],ans2[2]);
		}
	}
}