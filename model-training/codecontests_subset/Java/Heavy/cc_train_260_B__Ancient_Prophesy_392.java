import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {

	
	
	public static String lastOf(String s,int n){
		if(s.length()<n) return "-1";
		return s.substring(s.length()-n);
	}

	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		String s=cin.next();
		String arr[]=s.split("-");
		HashMap<String, Integer>  M=new HashMap<String,Integer>();
		int md[]=new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
		for(int i=0;i<arr.length-2;i++){
			if(arr[i].length()>=2 && arr[i+1].length()==2 && arr[i+2].length()>=4) {
				String ds=lastOf(arr[i],2);
				String ms=arr[i+1];
				String ys=arr[i+2].substring(0, 4);
				String ss=ds+"-"+ms+"-"+ys;
				int y=Integer.valueOf(ys);
				int m=Integer.valueOf(ms);
				int d=Integer.valueOf(ds);
				if(y>=2013 && y<=2015 && m>=1 && m<=12 && d>0 && d<=md[m]){
					M.put(ss, M.get(ss)==null?1:M.get(ss)+1);
				}
			}
		}
		String ans="";
		int tmax=-1;
		for(Iterator iter=M.entrySet().iterator();iter.hasNext();){
			 Entry entry = (Entry)iter.next();
			if((Integer)entry.getValue()>tmax){
				tmax=(Integer)entry.getValue();
				ans=(String)entry.getKey();
			}
		}
		System.out.println(ans);
		
		
	}

}
