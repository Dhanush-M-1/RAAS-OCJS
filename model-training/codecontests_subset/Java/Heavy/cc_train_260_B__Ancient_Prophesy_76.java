import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class B {
	int[] dom = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	int[] cumdom = new int[]{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
	
	public void solve(){
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] subinput = input.split("-");
		
		
		int[] ans = new int[365*4];
		
		for(int i = 0; i < subinput.length; i++){
			if(i < 2) continue;
			
			if( subinput[i].length() >= 4){
				int year = Integer.parseInt( subinput[i].substring(0,4) );
				if(year >= 2013 && year <= 2015){
					if( subinput[i-1].length() == 2){
						int month = Integer.parseInt( subinput[i-1]);
						if( month >= 1 && month <= 12){
							if( subinput[i-2].length() >= 2){
								String s = subinput[i-2].substring( subinput[i-2].length()-2, subinput[i-2].length() );
								int day = Integer.parseInt( s );
								if( day > 0 && day <= dom[month]){
									ans[datetonum(year, month, day)]++;
								}
							}
						}
					}
				}
			}	
//			System.out.println( subinput[i]);
		}
		
		int max = Integer.MIN_VALUE;
		int maxdate = -1;
		for(int i = 0; i < ans.length; i++){
			if( ans[i] > max){
				max = ans[i];
				maxdate = i;
			}
		}
		System.out.println( numtodate(maxdate) );
	}
	public String numtodate(int num){
		int year = num / 365 + 2013;
		int month = 0;
		int day = 0;
		num %= 365;
		for(int m = 1; m <= 12; m++){
			if( cumdom[m] > num){
				month = m;
				day = num - cumdom[m-1] + 1;
				break;
			}
		}
		return (day>9?"":"0") + day + "-" + (month>9?"":"0") + month + "-" + year;
	}
	public int datetonum(int year, int month, int day){
		return (year-2013)*365 + cumdom[month-1] + day-1;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new B().solve();
	}

}
