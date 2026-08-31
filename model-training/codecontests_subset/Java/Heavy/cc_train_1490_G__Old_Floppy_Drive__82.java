import java.util.*;

public class Solve{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
           StringBuilder sb=new StringBuilder();
        while(t-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            long[] ar=new long[n];
            for(int i=0;i<n;i++){
                ar[i]=sc.nextLong();
            }
            TreeMap<Long,Integer> tm=new TreeMap<>();
            long presum=ar[0];
            long maxsum=ar[0];
            tm.put(presum,0);
            for(int i=1;i<n;i++){
                presum+=ar[i];
                if(presum>maxsum){
                    tm.put(presum,i);
                    maxsum=presum;
                }
            }
         
            for(int i=0;i<m;i++){
                long x=sc.nextLong();
                
                if(maxsum>=x){
                    sb.append(tm.ceilingEntry(x).getValue()+" ");
                }
                else if(presum<=0){
                    sb.append("-1 ");
                }
                else{
                    long left=x-tm.lastKey();
				long cy=(left+presum-1)/presum;
				long time=cy*n+tm.ceilingEntry(x-presum*cy).getValue();
				sb.append(time+" ");
                }
            }
            
           
            sb.append("\n");
            
        }
         System.out.println(sb);
    }
}