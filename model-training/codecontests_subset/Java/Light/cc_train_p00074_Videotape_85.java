import java.util.Scanner;

public class Main {

	static int h,s,m;
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while(true){
			int hour =cin.nextInt();
			int season =cin.nextInt();
			int minute =cin.nextInt();
			if(hour+season+minute==-3){
				break;
			}
			h=2;
			s=0;
			m=0;
			minute(minute);
			season(season);
			hour(hour);
			System.out.println(String.format("%1$02d", h)+":"+
					String.format("%1$02d", s)+":"+
					String.format("%1$02d", m));
			h=6;
			s=0;
			m=0;
			minute(minute);
			season(season);
			hour(hour);
			minute(minute);
			season(season);
			hour(hour);
			minute(minute);
			season(season);
			hour(hour);
			System.out.println(String.format("%1$02d", h)+":"+
					String.format("%1$02d", s)+":"+
					String.format("%1$02d", m));
			
		}
	}
	static void minute(int minute){
		m=m-minute;
		if(m<0){
			season(1);
			m = 60+m;
		}
	}
	static void season(int season){
		s = s-season;
		if(s<0){
			hour(1);
			s = 60+s;
		}
	}
	static void hour(int hour){
		h = h-hour;
		
	}
}