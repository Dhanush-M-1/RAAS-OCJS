import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public final class KingsPath {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s[]=br.readLine().split(" ");
        int x1=Integer.parseInt(s[0]);
        int y1=Integer.parseInt(s[1]);
        int x2=Integer.parseInt(s[2]);
        int y2=Integer.parseInt(s[3]);
        int n=Integer.parseInt(br.readLine());
        HashMap<Integer, ArrayList<Pair>> map =new HashMap<>();
        for (int i=0;i<n;i++){
            String st[]=br.readLine().split(" ");
            int r=Integer.parseInt(st[0]);
            int a=Integer.parseInt(st[1]);
            int b=Integer.parseInt(st[2]);
            if(map.containsKey(r)){
                ArrayList<Pair> l=map.get(r);
                l.add(new Pair(a,b));
                map.replace(r,l);
            }else{
                ArrayList<Pair> l=new ArrayList<>();
                l.add(new Pair(a,b));
                map.put(r,l);
            }
        }
        for(Map.Entry<Integer,ArrayList<Pair>> entry:map.entrySet()){
            int key=entry.getKey();
            ArrayList<Pair> list=entry.getValue();
            Collections.sort(list, new Comparator<Pair>() {
                @Override
                public int compare(Pair f, Pair s) {
                    if(f.a<s.a){
                        return -1;
                    }else if(f.a>s.a){
                        return 1;
                    }else
                        return 0;
                }
            });
            map.replace(key,list);
        }


        for(Map.Entry<Integer,ArrayList<Pair>> entry:map.entrySet()){
            int key=entry.getKey();
            ArrayList<Pair> list=entry.getValue();
            if(list.size()>1){
                int start=0;
                while (start<list.size()-1){
                    Pair first=list.get(start);
                    Pair second=list.get(start+1);
                    if(first.b>= second.a-1){
                        int low=first.a;
                        int high=Math.max(first.b,second.b);
                        list.remove(start); // removes first
                        list.remove(start); // removes second because list size is one less now
                        list.add(start,new Pair(low,high));
                    }else
                        start++;
                }
            }
            map.replace(key,list);
        }

        /*for(Map.Entry<Integer,ArrayList<Pair>> entry:map.entrySet()){
            System.out.println(entry.getKey());
            ArrayList<Pair> l=entry.getValue();
            for(Pair p:l)
                System.out.println(p.a+" "+p.b);
        }*/

        int minDis=helper(map,x1,y1,x2,y2);
        System.out.println(minDis);
    }

    private static int helper(HashMap<Integer, ArrayList<Pair>> map, int x1, int y1, int x2, int y2) {

        ArrayDeque<Pair> deque=new ArrayDeque<>();
        deque.add(new Pair(x1,y1));
        deque.add(new Pair(-1,-1));
        HashMap<Integer,HashSet<Integer>> vis=new HashMap<>();
        HashSet<Integer> set=new HashSet<>();
        set.add(y1);
        vis.put(x1,set);
        int level=0;
        if(x1==y1 && x2==y2) return level;


        while(!deque.isEmpty()){
            level++;
            while (deque.peek().a!=-1){

                Pair u=deque.poll();
                for(int i=-1;i<=1;i++){
                    for (int j=-1;j<=1;j++){
                        if(Math.abs(i)+Math.abs(j)!=0){
                            int ii=u.a+i;
                            int jj=u.b+j;
                            if(map.containsKey(ii) && rowContainCol(map,ii,jj)  &&   (!vis.containsKey(ii) || !vis.get(ii).contains(jj) )){

                                if(vis.containsKey(ii)){
                                   HashSet<Integer> set1=vis.get(ii);
                                    set1.add(jj);
                                    vis.replace(ii,set1);
                                }else{
                                    HashSet<Integer> set1=new HashSet<>();
                                    set1.add(jj);
                                    vis.put(ii,set1);
                                }
                                deque.add(new Pair(ii,jj));
                                if(ii==x2 && jj==y2) return level;
                            }
                        }
                    }
                }
            }
            deque.poll();
            if(deque.size()>0){
                deque.add(new Pair(-1,-1));
            }
        }
        return -1;
    }

    private static boolean rowContainCol(HashMap<Integer, ArrayList<Pair>> map, int ii, int jj) {

        ArrayList<Pair> list=map.get(ii);
        int left=0,right=list.size()-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            Pair p=list.get(mid);
            if(jj>=p.a && jj<=p.b){
                return  true;
            }
            else if(jj<p.a){
                right=mid-1;
            }else if(jj>p.b){
                left=mid+1;
            }
        }
        return false;
    }

}
class Pair {
    int a,b;
    Pair(int a, int b){
        this.a=a;
        this.b=b;
    }
    Pair(){

    }
}
