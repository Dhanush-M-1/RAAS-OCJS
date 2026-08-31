import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Point> students = new ArrayList<Point>();
        List<Point> checkPoints = new ArrayList<Point>();
        for(int i = 0; i < n; i++){
            students.add(new Point(sc.nextInt(), sc.nextInt()));
        }
        for(int i = 0; i < m; i++){
            checkPoints.add(new Point(sc.nextInt(), sc.nextInt()));
        }
        for(Point s : students){
            int minDist = Integer.MAX_VALUE;
            int ans = 0;
            for(int i = 0; i < m; i++){
                int tmp = Math.abs(s.x - checkPoints.get(i).x) + Math.abs(s.y - checkPoints.get(i).y);
                if(minDist > tmp){
                    minDist = tmp;
                    ans = i+1;
                }
            }
            System.out.println(ans);
        }
    }
}

class Point{
    int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
