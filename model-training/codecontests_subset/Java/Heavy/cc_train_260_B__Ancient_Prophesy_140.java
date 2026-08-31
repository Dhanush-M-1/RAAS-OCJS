import java.io.*;
import java.util.*;

public class B {
	HashMap<String, Integer> h = new HashMap<String, Integer>();
	int days[] = {0,31,28,31,30,31,30,31,31,30,31,30,31,30,31,30};
	
	boolean check(int d, int m, int y){
		if(y>=2013 && y<=2015 && m>0 && m <= 12 && d>0 && d<32){
			if(d>days[m]) return false;
			return true;
		}
		
		return false;
	}
	
	void run()throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line = bf.readLine();
		String[] toks = line.split("-");
		int max = 0;
		String ret = "-1";
		for(int i=0; i<toks.length-2; i++){
			if(toks[i].length()>1){
				if(toks[i+1].length()==2 && toks[i+2].length()>3){
					String dd = toks[i].substring(toks[i].length()-2);
					String mm = toks[i+1];
					String yy = toks[i+2].substring(0, 4);
					String date = dd+"-"+mm+"-"+yy;
//					System.out.println("date = " + date);
					int d = Integer.parseInt(dd);
					int m = Integer.parseInt(toks[i+1]);
					int y = Integer.parseInt(yy);
					
					if(check(d, m, y)){
						if(h.containsKey(date)){
							h.put(date, h.get(date)+1);
						}else h.put(date, 1);
						
						if(h.get(date)>max){
							ret = date;
							max = h.get(date);
						}
					}
				}
			}
		}
		System.out.println(ret);
		
	}
	
	public static void main(String[] args)throws IOException {
		new B().run();
	}
}
