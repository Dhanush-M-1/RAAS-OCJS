import java.util.*;

public class Main {
	
	public static int Needhp(int aty,int dfy,int hpm,int atm,int dfm){
		int dameme=Math.max(0,atm-dfy);
		int dameyou=Math.max(0, aty-dfm);
		if(dameyou==0)return Integer.MAX_VALUE;
		if(dameme==0)return 0;
		int jumyou=0;
		if(hpm<=dameyou)jumyou=1;
		else if(hpm%dameyou==0)jumyou=hpm/dameyou;
		else jumyou=hpm/dameyou+1;
		
		return 1+jumyou*dameme;
	}
  public static void main(String[] args) {
	  Scanner sc=new Scanner(System.in);
	  int hpy=sc.nextInt();
	  int aty=sc.nextInt();
	  int dfy=sc.nextInt();
	  int hpm=sc.nextInt();
	  int atm=sc.nextInt();
	  int dfm=sc.nextInt();
	  int bith=sc.nextInt();
	  int bita=sc.nextInt();
	  int bitd=sc.nextInt();
	  int need=0;
	  while(aty<=dfm){
		  need+=bita;
		  aty++;
	  }
	  int ans=Integer.MAX_VALUE;
	  for(int i=aty;hpm>Math.max(0,i-1-dfm) || i==aty;i++){
		  if(ans<=(i-aty)*bita)break;
		  for(int j=dfy;j-1<=Math.max(dfy,atm+1) || j==dfy;j++){
			  if(ans<=(i-aty)*bita+(j-dfy)*bitd)break;
			  int needhp=Needhp(i,j,hpm,atm,dfm);
			  int needitem=Math.max(0,needhp-hpy);
			  int cost=needitem*bith+(i-aty)*bita+(j-dfy)*bitd;
			  ans=Math.min(cost,ans);
			  }
		  }
	  System.out.println(ans+need);
	  }
	  
  }
  