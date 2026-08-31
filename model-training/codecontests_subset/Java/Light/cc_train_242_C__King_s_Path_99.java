import java.util.*;

import javafx.util.Pair;


public class practice {
	
	
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int sx=scn.nextInt();int sy=scn.nextInt();
		int ex=scn.nextInt();int ey=scn.nextInt();
		int n=scn.nextInt(),r=0,a=0,b=0;
		HashMap<Pair<Integer, Integer>,Integer> map=new HashMap<>();
		for(int i=1;i<=n;i++){
			r=scn.nextInt();a=scn.nextInt(); b=scn.nextInt();
			for(int j=a;j<=b;j++){
				map.put(new Pair<Integer, Integer>(r,j),-1);
			}
		}
		int dx[]={0,0,1,1,1,-1,-1,-1};
		int dy[]={-1,1,-1,0,1,-1,0,1};
		map.put(new Pair<Integer, Integer>(sx,sy),0);
		LinkedList<Pair<Integer,Integer>> q=new LinkedList<>();
		q.add(new Pair<Integer,Integer>(sx,sy));
		while(!q.isEmpty()){
			Pair<Integer,Integer> t=q.pop();
			for(int i=0;i<8;i++){
				Pair<Integer,Integer>t2=new Pair(t.getKey()+dx[i],t.getValue()+dy[i]);
				if(map.containsKey(t2)){
					if(map.get(t2)==-1){
						q.add(t2);map.put(t2,map.get(t)+1);
					}
				}
			}
			
		}
		System.out.println(map.get(new Pair(ex,ey)));
		
	}

	}

