import java.util.*;
public class Main {
static int GCD(int a,int b){
  if(b==0)return a;	
	return GCD(b,a%b);
}	
public static void main(String [] args){
	Scanner in=new Scanner(System.in);
	int n=in.nextInt();
	int len[]=new int[n];
	int cost[]=new int[n];
	for(int i=0;i<n;i++)len[i]=in.nextInt();
	for(int i=0;i<n;i++)cost[i]=in.nextInt();
	HashMap<Integer,Integer>map=new HashMap<Integer,Integer>();
	ArrayList<Integer>list=new ArrayList<Integer>();
	for(int i=0;i<n;i++){
		list.add(len[i]);
		if(!map.containsKey(len[i]))
			map.put(len[i],cost[i]);
			else if(map.get(len[i]) > cost[i])
				map.put(len[i],cost[i]);
	}
	while(!list.isEmpty()){
	int node=list.get(0);
	list.remove(0);
	int price=map.get(node);
	for(int i=0;i<n;i++){
		int gcd=GCD(Math.max(len[i],node),Math.min(len[i],node));
		if(!map.containsKey(gcd)){
			map.put(gcd,cost[i]+price);
			list.add(gcd);
		}
		else if(map.get(gcd) > cost[i]+ price){
	        list.add(gcd);
			map.put(gcd,cost[i]+price);
	}
	}
	}
	Integer a=map.get(1);
	if(a==null)System.out.print("-1");
	else System.out.print(a);
}
}