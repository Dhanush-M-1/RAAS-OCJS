import java.util.*;
public class p1227D1 {
    static class Pair implements Comparable<Pair>{
        int i;
        long j;
        Pair(int i,long j){
            this.i=i;
            this.j=j;
          
        } 
        public int compareTo(Pair o){
            if(this.j>o.j){
                return(-1);
            }
            else if(o.j>this.j){
                return(1);
            }
            else if(this.i<o.i){
                return(-1);
            }
            else {
                return(1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>();
        for(int i=0;i<n;i++){
            int val=scn.nextInt();
            arr[i]=val;
            pq.add(new Pair(i,val));
        }
        ArrayList<Integer> ans=new ArrayList<Integer>();
        while(pq.size()>0){
            int i=pq.remove().i;
            ans.add(i);
        }
        int m=scn.nextInt();
        for(int i=0;i<m;i++){
            int k=scn.nextInt();
            int pos=scn.nextInt();
            PriorityQueue<Integer> med=new PriorityQueue<Integer>();
            for(int j=0;j<k;j++){
                med.add(ans.get(j));
            }
            for(int val=0;val<pos-1;val++){
                med.remove();
            }
            System.out.println(arr[med.remove()]);
        }
    }

}
