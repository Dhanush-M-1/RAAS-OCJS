import java.util.Scanner;
public class Main {
	Scanner in = new Scanner(System.in);
	int[][] kin = {
			{0,300,500,600,700,1350,1650},
			{300,0,350,450,600,1150,1500},
			{500,350,0,250,400,1000,1350},
			{600,450,250,0,250,850,1300},
			{700,600,400,250,0,600,1150},
			{1350,1150,1000,850,600,0,500},
			{1650,1500,1350,1300,1150,500,0}};
	int[][]kyori = {
			{0,6,13,18,23,43,58},
			{6,0,7,12,17,37,52},
			{13,7,0,5,10,30,45},
			{18,12,5,0,5,25,40},
			{23,17,10,5,0,20,35},
			{43,37,30,25,20,0,15},
			{58,52,45,40,35,15,0}};
	public static void main(String[] args) {
		new Main();
	}
	public Main() {
		new AOJ0163().doIt();
	}
	
	class AOJ0163{
		void doIt(){
			while(true){
				int startID = in.nextInt();
				if(startID == 0)return;
				Calc c = new Calc(startID, in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
				System.out.println(c.getResult());
			}
		}
		
		class Calc{
			int StartID,endID,sh,sm,eh,em;
			int time;
			boolean sw;
			public Calc(int _sID,int _sh,int _sm,int _eID,int _eh,int _em) {
				StartID = _sID;sh = _sh;sm = _sm;
				endID = _eID;eh = _eh;em = _em;
				sw = false;
				getTime();
			}
			
			int getResult(){
				int result = kin[StartID-1][endID-1];
				if(sw&&kyori[StartID-1][endID-1]<=40){
					result = result/2;
					if(result%50!=0){
						result+=(50-result%50);
					}
				}
				return result;
			}
			
			void getTime(){
				int stime = sh*60+sm;
				int etime = eh*60+em;
				time = etime-stime;
				if(stime>=1050&&stime<=1170)sw = true;
				if(etime>=1050&&etime<=1170)sw = true;
			}
		}
		
	}
	
}