import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeMap;

public class AncientProphecy {
	public static int monthDays(int month){
		switch(month){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12: return 31;
		case 4:
		case 6:
		case 9:
		case 11: return 30;
		default: return 28;
		}
	}
	public static int count(StringBuilder s, String date){
		int out = 0;
		for(int i = 0;i<s.length()-9;i++){
			if(s.charAt(i)!='-'&&s.charAt(i+1)!='-'&&s.charAt(i+2)=='-'&&s.charAt(i+3)!='-'&&s.charAt(i+4)!='-'&&s.charAt(i+5)=='-'&&s.charAt(i+6)!='-'&&s.charAt(i+7)!='-')
				if(s.substring(i,i+10).equals(date)){
					out++;
					i += 9;
				}
		}
		return out;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		sb.append(bf.readLine());
		String maxDate = ""; int max = 0;
		for(int year = 2013;year<=2015;year++){
			for(int month = 1;month<=12;month++){
				for(int day = 1;day<=monthDays(month);day++){
					sb2=new StringBuilder();
					sb2.append(""+(day<10?"0"+day:day)+"-"+(month<10?"0"+month:month)+"-"+year);
					int count = count(sb,sb2.toString());
					if(count>max){
						max = count;
						maxDate = sb2.toString();
					}
				}
			}
		}
		System.out.println(maxDate);
		//		String newS = "";
		//		for(int i = 0;i<s.length();i++){
		//			if(s.charAt(i)=='-'){
		//				if(newS.charAt(newS.length()-1)!=' ')
		//					newS += " ";
		//			}
		//			else
		//				newS += s.charAt(i);
		//		}
		//		String[] ns = newS.split(" ");
		//		HashMap<String, Integer> dates = new HashMap<String, Integer>();
		//		String maxDate = ""; int max = 0;
		//		for(int i = 0;i<ns.length-2;i++){
		//			if(ns[i].length()>1){
		//				String dayS = ns[i].substring(ns[i].length()-2, ns[i].length());
		//				int day = Integer.parseInt(dayS);
		//				
		//				if(ns[i+1].length()==2){
		//					String monthS = ns[i+1].substring(ns[i+1].length()-2, ns[i+1].length());
		//					int month = Integer.parseInt(monthS);
		//					
		//					if(ns[i+2].length()>=4){
		//						String yearS = ns[i+2].substring(0, 4);
		//						int year = Integer.parseInt(yearS);
		//
		//						if(year>=2013&year<=2015){
		//							if(month>=1&month<=12){
		//								int daysInMonth = monthDays(month);
		//								if(day>0&day<=daysInMonth){
		//									String date = ""+dayS+monthS+yearS;
		//									if(!dates.containsKey(date))
		//										dates.put(date, 1);
		//									else
		//										dates.replace(date, dates.get(date)+1);
		//									if(dates.get(date)>max){
		//										max = dates.get(date);
		//										maxDate = date;
		//									}
		//								}
		//							}
		//						}
		//					}
		//				}
		//			}
		//		}
		//		System.out.println(maxDate.substring(0,2)+"-"+maxDate.substring(2,4)+"-"+maxDate.substring(4));
	}
}
