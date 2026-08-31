import java.util.*;
import java.io.*;
public class demo{
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		myMap map = new myMap(n);
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; ++i){
			long x = Long.parseLong(st.nextToken());
			map.insert(x);
		}
		st = new StringTokenizer(br.readLine());
		myMap map_2 = new myMap(n-1);
		for(int i = 0; i < n-1; ++i){
			long x = Long.parseLong(st.nextToken());
			map.alterate(x);
			map_2.insert(x);
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n-2; ++i){
			long x = Long.parseLong(st.nextToken());
			map_2.alterate(x);
		}
		map.error_unresolved();
		map_2.error_unresolved();
	}
}
class Pair{
	int count;
	int second_count;
	boolean flag;
	Pair(){
		count=0;
		flag=false;
	}
	Pair(int x){
		count=x;
		flag=true;
	}
	public void changeflag(){
		if(count == 1)flag=false;
		else{
			count--;
		}
	}
	public int first(){
		return count;
	}
	public boolean second(){
		return flag;
	}
}

class myMap{
	HashMap<Long,Pair> map;
	HashSet<Long> set;
	myMap(int x){
		map = new HashMap<Long,Pair>(x);
		set=new HashSet<Long>();
	}
	public void insert(long x){
		if(map.containsKey(x)){
			map.put(x,new Pair(map.get(x).first()+1));
		}else{
			map.put(x,new Pair(1));
		}
	}
	public void alterate(long x){
		if(map.containsKey(x)){
			map.get(x).changeflag();
			if(map.get(x).first() > 1)set.add(x);
		}
	}
	public void error_unresolved(){
		for(long i : map.keySet()){
			if((map.get(i).second()))System.out.println(i);
		}
	}
}
