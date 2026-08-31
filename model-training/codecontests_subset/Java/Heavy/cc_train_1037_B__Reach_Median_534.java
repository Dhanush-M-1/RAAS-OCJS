import java.io.*;
import java.util.*;
public class ReachMedian {
    public static void main(String[] args) throws IOException{
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        long s=in.nextLong();
        PriorityQueue<Long> pq1=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Long> pq2=new PriorityQueue<>();
        int sCount=0;
        for(int i=0;i<n;i++){
            long c=in.nextLong();
            if(c>s){
               pq2.add(c);
            }
            else if(c<s){
               pq1.add(c);
            }
            else
                sCount++;
        }
        long cost=0;
        if(sCount==0){
            sCount++;
            if(pq1.size()<pq2.size()) {
                cost+=(pq2.remove()-s);
            }
            else{
                cost+=(s-pq1.remove());
            }}
            int size1=pq1.size();
            int size2=pq2.size();
            int need = Math.abs(size1-size2);
            if(need<sCount){
                System.out.println(cost);
                return;
            }
            else{
                if(size1>size2){
                    size2+=(sCount-1);
                while(size1>size2){
                    cost+=(s-pq1.remove());
                    size1--;size2++;
                }
                }
                if(size2>size1){
                    size1+=(sCount-1);
                    while(size2>size1){
                        cost+=(pq2.remove()-s);
                        size1++;size2--;
                    }
                }
            }
        System.out.print(cost);
    }
}