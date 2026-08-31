import java.util.*;

public class Problem56 {

	public static void main(String[] args) {
		
		Scanner read=new Scanner(System.in);
		int r1=read.nextInt(),r2=read.nextInt()
				,c1=read.nextInt(),c2=read.nextInt()
				,d1=read.nextInt(),d2=read.nextInt();
		boolean flag=true;
		
		for(int x00=1 ; x00<10 ;x00++) {
			for(int x01=1 ; x01<10 ; x01++) {
				if(x00==x01)continue;
				for(int x10=1 ; x10<10 ; x10++) {
					if(x00==x10 || x10==x01)continue;
					for(int x11=1 ; x11<10 ; x11++) {
						if(x00==x11 || x11==x01 || x11==x10)continue;
						if(check(x00,x01,x10,x11,r1,r2,c1,c2,d1,d2)) {
							System.out.print(x00+" "+x01+"\n"+x10+" "+x11);
							flag=false;
						}
					}
				}
			}
		}
		if(flag)System.out.print("-1");
	}
	 static boolean check(int x00,int x01,int x10,int x11,int r1,int r2,int c1,int c2,int d1,int d2) {
			return(x00+x01==r1 && x10+x11==r2 && x00+x10==c1 
					&& x01+x11==c2 && x00+x11==d1 && x10+x01==d2);
		}

}