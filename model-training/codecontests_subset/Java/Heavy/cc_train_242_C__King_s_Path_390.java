import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class C {
    
    static HashSet<Pair> all;
    static final int MAX = (int)1e9;
    
    static class Pair{
        int x; int y;
        Pair(int x, int y){
            this.x=x;
            this.y=y;           
        }
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }

        @Override
        public boolean equals(Object o) {
            return (x==((Pair)o).x && y==((Pair)o).y);          
        }   
    }
    
    static int BFS(Pair in, Pair fin){
        int movesx[] = {1,-1,0,0,1,1,-1,-1};
        int movesy[] = {0,0,1,-1,1,-1,1,-1};        
        HashSet<Pair> v = new HashSet<Pair>();
        Queue<Pair> Q = new LinkedList<Pair>();
        Queue<Integer> moves = new LinkedList<Integer>();       
        Q.add(in);
        moves.add(0);
        while(!Q.isEmpty()){
            Pair now = Q.remove();
            int move = moves.remove();
            if(now.equals(fin)) return move;
            for(int i=0;i<8;i++){
                int x = now.x+movesx[i];
                int y = now.y+movesy[i];
                Pair aux = new Pair(x,y);               
                if(x>=0 && x<=MAX && y>=0 && y<=MAX && all.contains(aux) && !v.contains(aux)){
                    Q.add(aux);
                    moves.add(move+1);
                    v.add(aux);
                }               
            }
        }
        return -1;
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        all = new HashSet<Pair>();
        
        Pair start = new Pair(in.nextInt(),in.nextInt());
        Pair end = new Pair(in.nextInt(),in.nextInt());
        all.add(start);
        all.add(end);
        
        int q = in.nextInt();
        for(int i=0;i<q;i++){
            int r = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            for(int j=a;j<=b;j++)
                all.add(new Pair(r,j));
        }        
        System.out.println(BFS(start,end));
    }
}