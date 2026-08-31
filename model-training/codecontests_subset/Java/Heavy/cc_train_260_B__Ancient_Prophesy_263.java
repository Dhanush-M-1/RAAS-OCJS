
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;
public class AncientProphesy {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String s=bf.readLine();
		TreeMap<String, Integer> map=new TreeMap<String, Integer>();
		int max=0;
		String ans="";
		for(int i=0;i<s.length()-9;i++){
			String t=s.substring(i, i+10);
			if(map.containsKey(t)){
				int occ=map.get(t);
				if(occ+1>max){
					max=occ+1;
					ans=t;
				}
				map.put(t, occ+1);
			}
			else{
				if(valid(t)){
					map.put(t, 1);
					if(max==0){
						max=1;
						ans=t;
					}
				}
			}
		}
		System.out.println(ans);
	}
	
	public static boolean valid(String s){
		String[]sa=s.split("-");
		if(sa.length==3){
			for(int i=0;i<3;i++){
				if(sa[i].length()<2)
					return false;
				for(int j=0;j<sa[i].length();j++)
					if(!Character.isDigit(sa[i].charAt(j)))
						return false;
			}
			int d=Integer.parseInt(sa[0]);
			int m=Integer.parseInt(sa[1]);
			int y=Integer.parseInt(sa[2]);
			boolean f=true;
			f=f && y>=2013 && y<=2015 && m>=1 && m<=12;
			f=f && valid(d,m);
			return f;
		}
		return false;
	}
	
	public static boolean valid(int d,int m){
		switch (m){
		case 2: return (d>=1 && d<=28);
		case 4:
		case 6:
		case 9:
		case 11: return (d>=1 && d<=30);
		default: return (d>=1 && d<=31);
		}
	}
}