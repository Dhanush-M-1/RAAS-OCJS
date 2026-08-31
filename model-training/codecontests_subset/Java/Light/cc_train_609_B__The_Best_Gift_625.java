
 
import java.util.*;

public class BruteForce{
    public static Scanner in=new Scanner(System.in);
    public static int getNumber(int cur,HashMap<Integer,Integer> map){
        int count=0;
        Iterator<Integer>ptr=map.keySet().iterator();
        while(ptr.hasNext()){
            int key=ptr.next();
            if(key!=cur){
                int val=map.get(key);
                count+=val;
            }
        }
        return count;
    }
    public static void main(String[]args){
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int n=in.nextInt();
        int m =in.nextInt();
        int[]z=new int[n];
        for(int i=0;i<n;i++){
            int cur=in.nextInt();
            if(map.containsKey(cur))
                map.put(cur,map.get(cur)+1);
            else
                map.put(cur,1);
            z[i]=cur;
        }
        long count=0;
        for(int i=0;i<n;i++){
            int cur=z[i];
            int x=getNumber(cur,map);
            int val=map.get(cur)-1;
            if(val>0)
                map.put(cur,val);
            else
                map.put(cur,0);
            count+=x;
        }
        System.out.println(count);
    }

}
