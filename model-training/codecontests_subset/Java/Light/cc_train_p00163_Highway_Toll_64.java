import java.util.Scanner;
public class Main
{
	public static void main(String[] args) 
	{
		int cost[][]=
			{
				{0,300,500,600,700,1350,1650},
				{300,0,350,450,600,1150,1500},
				{500,350,0,250,400,1000,1350},
				{600,450,250,0,250,850,1300},
				{700,600,400,250,0,600,1150},
				{1350,1150,1000,850,600,0,500},
				{1650,1500,1350,1300,1150,500,0}
			};
		int km[][]=
			{
				{0,6,13,18,23,43,58},
				{6,0,7,12,17,37,52},
				{13,7,0,5,10,30,45},
				{18,12,5,0,5,25,40},
				{23,17,10,5,0,20,35},
				{43,37,30,25,20,0,15},
				{58,52,45,40,35,15,0}
			};
		Scanner in=new Scanner(System.in);
		for(;;)
		{
			int s=in.nextInt();
			if(s==0)
				return;
			int sh=in.nextInt(),sm=in.nextInt();
			int t=in.nextInt();
			int th=in.nextInt(),tm=in.nextInt();
			int ans=cost[s-1][t-1];
			int t1=sh*60+sm;
			int t2=th*60+tm;
			if(km[s-1][t-1]<=40&&(17*60+30<=t1&&t1<=19*60+30||17*60+30<=t2&&t2<=19*60+30))
				ans=ans/2+ans/2%50;
			System.out.println(ans);
		}
	}
}