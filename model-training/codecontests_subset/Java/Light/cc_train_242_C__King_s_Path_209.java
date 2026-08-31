import java.util.*;
import java.io.*;
public class search {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int x1=sc.nextInt();
        int y1=sc.nextInt();
        int x2=sc.nextInt();
        int y2=sc.nextInt();
        int n=sc.nextInt();
        HashSet<Long> set=new HashSet<Long>();
        HashMap<Long, Integer> map=new HashMap<Long, Integer>();
        for (int i = 0; i < n; i++) {
            int a=sc.nextInt();
            int x=sc.nextInt();
            int y=sc.nextInt();
            for (int j = 0; j < y-x+1; j++) {
                set.add((long )a*p+x+j);
            }
        }
        Queue<Long> q=new LinkedList<Long>();
        q.add((long )x1*p+y1);
        map.put((long )x1*p+y1, 0);
        while(!q.isEmpty()){
            long a=q.poll();
            if(a/p==x2 && a%p==y2){System.out.println(map.get(a)); return;}
            long x=a/p;
            long y=a%p;
            int k=map.get(a);
            for(int i=0;i<8;i++){
                long t=((x+dirx[i])*p+(y+diry[i]));
                if(!map.containsKey(t)&& set.contains(t)){
                    q.add(t);
                    map.put(t, k+1);
                }   
            }
        }
        System.out.println(-1);
        
    }
    static long p=1<<30;
    static int [] dirx=new int [] {1,1,1,-1,-1,-1,0,0};
    static int [] diry=new int [] {1,-1,0,1,-1,0,1,-1};
}


