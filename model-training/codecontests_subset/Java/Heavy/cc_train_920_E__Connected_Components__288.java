import java.util.*;

public class Solve{
    static TreeSet<Integer> tset;
     static  HashSet<Integer>[] set;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        tset=new TreeSet<>();
      set=new HashSet[n];
        for(int i=0;i<n;i++){
          tset.add(i);
          set[i]=new HashSet<>();
        }
        
        for(int i=0;i<m;i++){
            int a=sc.nextInt()-1;
            int b=sc.nextInt()-1;
            set[a].add(b);
            set[b].add(a);
        }
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(tset.contains(i)){
                al.add(dfs(i));
            }
        }
        Collections.sort(al);
        StringBuilder sb=new StringBuilder();
        sb.append(al.size()+"\n");
        for(int i=0;i<al.size();i++){
            sb.append(al.get(i)+" ");
        }
        System.out.println(sb);
       
    }
    static int dfs(int a){
        tset.remove(a);
        int n=set.length;
        int cnt=0;
        if (tset.size() > 0) {
            int b = tset.first();
            while (b < n) {
                Integer w = tset.ceiling(b);
                if (w == null) {
                    break;
                }
                if (!set[a].contains(w)) {
                    cnt += dfs(w);
                }
                b = w + 1;
            }
        }
         return cnt+1;
    }
}