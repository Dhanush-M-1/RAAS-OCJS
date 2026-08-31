import java.util.*;
import java.io.*;
import java.math.*;
public class Solution{
    
    static HashMap<Integer,Node> luckup = new HashMap<Integer,Node>();
    
    static class Node implements Comparable<Node>{
        int id;
        int father;
        int rank;
        int nb;
        boolean end;
        LinkedList<Integer> neighbers = new LinkedList<Integer>();
        Node(int id,int father){
            this.id = id;
            this.father = father;
            rank = 0;
            nb = 0;
            end = false;
        }
        
        @Override
        public int compareTo(Node n){
            if(n.rank-rank!=0) return n.rank - rank;
            else return id - n.id;
        }
    }
    
    static Node getNode(int id){
        return luckup.get(id);
    }
    
    static void addEdges(int first,int second){
        Node node = getNode(first);
        node.neighbers.add(second);
    }
    
    static void bfs(int first){
        LinkedList<Integer> nextToVisit = new LinkedList<Integer>();
        nextToVisit.add(first);
        while(!nextToVisit.isEmpty()){
            Node node = getNode(nextToVisit.poll());
            for(int i:node.neighbers){
                getNode(i).rank = node.rank + 1;
                nextToVisit.add(i);
            }
        }
    }
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        PrintWriter out = new PrintWriter(System.out);
        st = new StringTokenizer(br.readLine());
        int racine = 0;
        int[] f = new int[n+1];
        for(int i=1;i<=n;i++){
            f[i] = Integer.parseInt(st.nextToken()); 
            luckup.put(i,new Node(i,f[i]));
            if(f[i]==0) racine = i;
        }
        
        for(int i=1;i<=n;i++){
            if(f[i]==0) continue;
            addEdges(f[i],i);
            getNode(f[i]).nb++;
            getNode(i).nb++;
        }
        
        bfs(racine);
        
        boolean[] exist = new boolean[n+1];
        
        TreeSet<Node> nextToVisit = new TreeSet<Node>();
        int even = 0;
        for(int i=1;i<=n;i++){
            if(getNode(i).nb%2==0) {
                nextToVisit.add(getNode(i));
                even++;
                exist[i] = true;
            }
        }
        
        if(even%2==0){
            out.println("NO");
        }else{
            
            out.println("YES");
            
            
            
            while(!nextToVisit.isEmpty()){
                
                Node node = nextToVisit.pollFirst();
                if(node.nb%2==1) {
                    exist[node.id] = false;
                    continue;
                }
                
                node.end = true;
                out.println(node.id);
                
                for(int i:node.neighbers){
                    getNode(i).nb--;
                    if(exist[i] || getNode(i).end || getNode(i).nb%2==1) continue;
                    exist[i] = true;
                    nextToVisit.add(getNode(i));
                }
                
                if(node.father!=0){
                    int i = node.father;
                    getNode(i).nb--;
                    if(exist[i] || getNode(i).end || getNode(i).nb%2==1) continue;
                    exist[i] = true;
                    nextToVisit.add(getNode(i));
                    
                }
                
                
            }
            
            
            
            
            
            
        }

        out.flush();
    }
    
}