import java.util.*;
public class Main{
	public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
      String x = sc.next();
      int sum = 0;
      int cnt = 1;
      Queue<Integer> que = new ArrayDeque<Integer>();
      for(int i = 1;i < x.length();i++){
      	if(x.substring(i,i+1).equals(x.substring(i-1,i)))cnt++;
        else{
          que.add(cnt);
          cnt = 1;
        }
      }
      que.add(cnt);
      int s = 0;
      if(x.substring(0,1).equals("T"))sum += que.poll();
      if(que.size()%2==0){
      	while(que.size()!=0){
      		int k = que.poll()+s;
        	int l = que.poll();
        	if(l>=k){
              sum+=l-k;
              s = 0;
            }
        	else s = k-l;
      	}
      }else{
        while(que.size()!=1){
        	int k = que.poll()+s;
            int l = que.poll();
            if(l>=k){
              sum+=l-k;
              s = 0;
            }
            else s = k-l;
        }
        if(que.size()==1)s+=que.poll();
      }
      sum += s;
      System.out.println(sum);
    }
}