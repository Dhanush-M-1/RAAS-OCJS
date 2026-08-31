  import java.util.*;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    static class Point{
        int row;
        int column;

        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
    public static int row_points[]={0,1,0,-1,1,-1,1,-1};
    public static int col_points[] ={1,0,-1,0,1,-1,-1,1};
    public static int BFS(Point initial_point,Point final_point,Map<Integer,Set<Integer>>valid){
        Queue<Point> queue = new LinkedList<>();
        Map<Point,Integer> map = new HashMap<>();
        Map<Integer,Set<Integer>> visited = new HashMap<>();
        visited.put(initial_point.row,new HashSet<>());
        visited.get(initial_point.row).add(initial_point.column);
        queue.add(initial_point);
        map.put(initial_point,0);
        while (!queue.isEmpty()){
            Point point = queue.poll();
            for(int i=0;i<8;i++){
                int new_row = point.row + row_points[i];
                int new_col = point.column + col_points[i];
                Point new_Point = new Point(new_row,new_col);
                if(valid.containsKey(new_row) && valid.get(new_row).contains(new_col) && (!visited.containsKey(new_row)||
                        !visited.get(new_row).contains(new_col))){
                    if(new_row == final_point.row && new_col == final_point.column){
                        return map.get(point)+1;
                    }
                    queue.add(new_Point);
                    if(!visited.containsKey(new_row)){
                        visited.put(new_row,new HashSet<>());
                    }
                    visited.get(new_row).add(new_col);
                    map.put(new_Point,map.get(point)+1);
                }
            }
        }
        return -1;
    }
    public static void KingPath(){
        int initial_row = scan.nextInt();
        int initial_col = scan.nextInt();
        Point inital_point = new Point(initial_row,initial_col);
        int final_row = scan.nextInt();
        int final_col = scan.nextInt();
        Point final_point = new Point(final_row,final_col);
        int n = scan.nextInt();
        Map<Integer,Set<Integer>> valid = new HashMap<>();
        while (n-- > 0){
        int row = scan.nextInt();
        int col_1 = scan.nextInt();
        int col_2 = scan.nextInt();
            if(!valid.containsKey(row)){
                valid.put(row,new HashSet<>());
            }
        for(int i=col_1;i<=col_2;i++){
            valid.get(row).add(i);
        }
        }
        int res = BFS(inital_point,final_point,valid);
        System.out.println(res);

    }
    public static void main(String[] args){
        KingPath();
    }
}