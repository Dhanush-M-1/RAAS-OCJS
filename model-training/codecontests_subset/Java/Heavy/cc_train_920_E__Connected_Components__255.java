import java.beans.IntrospectionException;
import java.io.*;
import java.util.*;
public class CcInCg{
    private static int N = 200001;
    private static HashMap<Integer,Integer>[] graph = new HashMap[N];
    private static TreeSet<Integer> vertices = new TreeSet<>();
    private static boolean[] visited = new boolean[N];
    private static int bfs(int u){
        int cnt = 1;
        visited[u] = true;
        vertices.remove(u);
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(u);
        while(!queue.isEmpty()){
            int currNode = queue.removeFirst();
            ArrayList<Integer> removeArr = new ArrayList<>();
            Iterator<Integer> itr = vertices.iterator();
            while(itr.hasNext()){
                int v = itr.next();
                if(!graph[currNode].containsKey(v)){
                    visited[v] = true;
                    queue.addLast(v);
                    removeArr.add(v);
                    cnt++;
                }
            }
            for(int i=0;i<removeArr.size();i++)
                vertices.remove(removeArr.get(i));
        }
        return cnt;
    }
    public static void main(String[] args){
        InputReader reader = new InputReader();
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        // your program goes here
        int n = reader.nextInt();
        int m = reader.nextInt();
        for(int i=0;i<n;i++) {
            graph[i] = new HashMap<>();
            vertices.add(i);
        }
        for(int i=0;i<m;i++){
            int u = reader.nextInt();
            int v = reader.nextInt();
            graph[u-1].put(v-1,1);
            graph[v-1].put(u-1,1);
        }
        int numComponents = 0;
        ArrayList<Integer> componentSizes = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!visited[i]) {
                componentSizes.add(bfs(i));
                numComponents++;
            }
        }
        writer.println(numComponents);
        Collections.sort(componentSizes);
        for(int i=0;i<componentSizes.size();i++)
            writer.print(componentSizes.get(i)+" ");
        writer.println();
        writer.close();
    }
    static class InputReader{
        BufferedReader br;
        StringTokenizer tokenizer;

        InputReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next(){
            while(tokenizer==null || !tokenizer.hasMoreElements()){
                try{
                    tokenizer = new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        public Integer nextInt(){
            return Integer.parseInt(next());
        }

        public Long nextLong(){
            return Long.parseLong(next());
        }

        public Double nextDouble(){
            return Double.parseDouble(next());
        }

        public String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}

