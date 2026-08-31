import java.util.Scanner;


public class AAA {
public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);
	 int n=sc.nextInt();
	int x=1,y=2;
	for (int i = 1; i <=n; i++) {
		int aa=sc.nextInt();
//		System.out.println(x+" "+y+" "+aa);
		if(x==aa){
			if(y==1&&x==2){y=3;continue;}
			if(y==1&&x==3){y=2;continue;}
			if(y==2&&x==3){y=1;continue;}
			if(y==2&&x==1){y=3;continue;}
			if(y==3&&x==1){y=2;continue;}
			if(y==3&&x==2){y=1;continue;}
		}else if(y==aa){
			if(y==1&&x==2){x=3;continue;}
			if(y==1&&x==3){x=2;continue;}
			if(y==2&&x==3){x=1;continue;}
			if(y==2&&x==1){x=3;continue;}
			if(y==3&&x==1){x=2;continue;}
			if(y==3&&x==2){x=1;continue;}
		}else{
			System.out.println("NO");
			return;
		}
	}
	System.out.println("YES");
	

	}
}
