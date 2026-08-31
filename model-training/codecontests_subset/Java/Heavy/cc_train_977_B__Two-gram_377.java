import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Maze{
	int a=10;
	public static void main(String []args){
		//Increment(a);
		//System.out.println((a));
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		String str=s.next();
		TreeMap<String,Integer> tm=new TreeMap<String,Integer>(); 
		for(int i=0;i<str.length()-1;i++){
			String part=str.substring(i,i+2);
			if(!tm.containsKey(part)){
				tm.put(part, 1);
			}
			else{
				tm.put(part, tm.get(part)+1);
			}
		}
		int max=0;
		String ans="";
		for(Entry<String, Integer> entry : tm.entrySet()) {
			  String key = entry.getKey();
			  Integer value = entry.getValue();
			  //System.out.println(key+" "+value);
			  if(value>max){
				  ans=key;
				  max=value;
			  }
			}
		System.out.println(ans);
	}
}