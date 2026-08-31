/**
 * p1374E1
 */
import java.util.*;
public class p1374E1 {

    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        
        
            PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
            PriorityQueue<Integer> pq1=new PriorityQueue<Integer>();
            PriorityQueue<Integer> pq2=new PriorityQueue<Integer>();
            int n=scn.nextInt();
            int k=scn.nextInt();
            for(int i=0;i<n;i++){
                int val=scn.nextInt();
                int a=scn.nextInt();
                int b=scn.nextInt();
                if(a==1&&b==1){
                    pq.add(val);
                }
                else if(a==1){
                    pq1.add(val);
                }
                else if(b==1){
                    pq2.add(val);
                }
            }
            int ans=0;
            if((pq.size()+pq1.size()<k)||(pq.size()+pq2.size()<k)){
                System.out.println(-1);
                
            }
            else{
                int cnt=Math.min(pq1.size(),pq2.size());
            while(cnt>0){
                pq.add(pq1.remove()+pq2.remove());
                cnt--;
            }
           for(int i=0;i<k;i++){
               ans=ans+pq.remove();
           }
           System.out.println(ans);
            }
            
        
    }
}