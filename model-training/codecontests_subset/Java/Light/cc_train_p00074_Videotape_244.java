import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
	public static void main(String[] args) {
		BufferedReader bfr=new BufferedReader(new InputStreamReader(System.in));
		String str="";
		StringTokenizer stk;
		int hr=0,mn=0,sc=0;
		int time=0;
		int rest=0;

		int r_hr=0,r_mn=0,r_sc=0;

		try {
			while(true) {
				str=bfr.readLine();
				stk=new StringTokenizer(str," ");
				hr=Integer.parseInt(stk.nextToken());
				mn=Integer.parseInt(stk.nextToken());
				sc=Integer.parseInt(stk.nextToken());

				if(hr==-1 && mn==-1 && sc==-1) {
					break;
				}
				else {
					time=hr*3600+mn*60+sc;
					rest=7200-time;

					r_hr=rest/3600;
					r_mn=(rest%3600)/60;
					r_sc=rest%60;
					System.out.println(String.format("%02d", r_hr)+":"+String.format("%02d", r_mn)+":"+String.format("%02d", r_sc));

					rest=(7200-time)*3;
					r_hr=rest/3600;
					r_mn=(rest%3600)/60;
					r_sc=rest%60;
					System.out.println(String.format("%02d", r_hr)+":"+String.format("%02d", r_mn)+":"+String.format("%02d", r_sc));
				}
			}
		}catch(IOException e) {

		}
	}
}
