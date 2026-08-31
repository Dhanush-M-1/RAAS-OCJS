import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int n = scanner.nextInt();
        Set<String> pts = new HashSet<>();
        for(int i = 0 ; i < n ; ++i){
            int r = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            for(int j = a ; j<=b ; ++j){
                pts.add(Integer.toString(r)+j);
            }
        }
        Map<String,Integer> len = new HashMap<>();
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{x1,y1});
        int sz=1,dep=0;
        for (;!q.isEmpty();++dep,sz=q.size()){
            while (sz-->0){
                int[] cur = q.remove();
                for(int i = -1 ; i <2 ; ++i){
                    for(int j =-1 ; j<2 ; ++j){
                        if(i==0 &&j==0)
                            continue;
                        int nx = cur[0]+i;
                        int ny = cur[1]+j;
                        if(pts.contains(Integer.toString(nx)+ny)&&!len.containsKey(Integer.toString(nx)+ny)){
                            q.add(new int[]{nx,ny});
                            len.put(Integer.toString(nx)+ny,dep+1);
                        }
                        if(nx==x2&&ny==y2){
                            System.out.println(dep+1);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
