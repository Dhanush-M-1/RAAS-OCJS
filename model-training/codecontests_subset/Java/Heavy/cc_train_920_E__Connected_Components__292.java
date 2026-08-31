import java.util.*;
public class Connected{
    private int N;
    private int M;
    private TreeSet<Integer> notVisited = new TreeSet<Integer>();
    private ArrayList<ArrayList<Integer>> neighbour = new
        ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> sizeConnected = new ArrayList<Integer>();
    public void solve(){
        Scanner sc= new Scanner(System.in);
        N = sc.nextInt();
        M= sc.nextInt(); 
        for(int i=0;i<N;i++){
            neighbour.add(new ArrayList<Integer>());
            neighbour.get(i).add(-1);
            neighbour.get(i).add(N);
        }
        for(int i=0;i<N;i++){
            notVisited.add(i);
        }
        for(int i=0;i<M;i++){
            int first = sc.nextInt()-1;
            int second = sc.nextInt()-1;
            neighbour.get(first).add(second);
            neighbour.get(second).add(first);
        }
        for(int i=0;i<N;i++){
            Collections.sort(neighbour.get(i));
        }
        countConnected();
        Collections.sort(sizeConnected);
        System.out.println(sizeConnected.size());
        for(int i=0;i< sizeConnected.size();i++){
            System.out.print( sizeConnected.get(i) + ""+
            ((i==(sizeConnected.size()-1))? "" : " "));
        }
        System.out.println();
    }
    public void countConnected(){
        for(int i=0;i<N;i++){
            if( notVisited.contains(i)){
                sizeConnected.add(dfs(i));
            }
        }
    }
    public int dfs(int i){
        int count=1;
        notVisited.remove(i);
        ArrayList<Integer> curNeighbour = neighbour.get(i);
        for(int n=0;n<curNeighbour.size()-1;n++){
            Integer curi =curNeighbour.get(n);
            Integer next = curNeighbour.get(n+1);
            while(true){
                Integer cur = notVisited.higher(curi);
                if(cur==null || cur >= next){
                    break;
                }
                if(notVisited.contains(cur)){
                    count+= dfs(cur);
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
        Connected c = new Connected();
        c.solve();
    }
}
