import java.awt.*;
import java.util.*;

public class bfsPractice {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<ArrayList<Point>> adjList = new ArrayList<ArrayList<Point>>();
        int y1 = s.nextInt();
        int x1 = s.nextInt();
        int y2 = s.nextInt();
        int x2 = s.nextInt();

        Coordinate fat = new Coordinate(x1,y1);

        Coordinate fat2 = new Coordinate(x2,y2);

        long start = ((long)(Math.pow(10.0,9.0)+1)*x1) +y1;
        long end = ((long)(Math.pow(10.0,9.0)+1)*x2) +y2;




        HashMap<Long, Integer> map = new HashMap<>();
        HashSet<Long> validlist = new HashSet<>();
        int regions = s.nextInt();
        while(regions > 0) {
            int r = s.nextInt();
            int a = s.nextInt();
            int b = s.nextInt();

            for(int i = a; i <= b; i++) {
                long validnumb = ((long)(Math.pow(10.0,9.0)+1)*i) + r;
                validlist.add(validnumb);
                map.put(validnumb, -1);
            }

            regions--;
        }

        validlist.add(start);
        validlist.add(end);

        LinkedList<Coordinate> queue = new LinkedList<Coordinate>();
        map.put(start, 0);

        int dx[] = {1, 1, 1, 0, -1, -1, -1, 0};
        int dy[] = {1, 0, -1, -1, -1, 0, 1, 1};


        //add starting point
        queue.add(fat);


        boolean shiva = false;
        long good = 0;
        while(queue.size() != 0) {
            Coordinate b = queue.poll();

            for (int i = 0; i < 8; i++) {
                long newX = b.x + dx[i];
                long newY = b.y + dy[i];
                Coordinate newCoord = new Coordinate(newX, newY);

                long old = ((long)(Math.pow(10.0,9.0)+1)) * b.x+b.y;
                long distinct = ((long)(Math.pow(10.0,9.0)+1)) * newX + newY;
                if (validlist.contains(distinct) && map.get(distinct) == -1) {
                    queue.add(newCoord);
                    map.replace(distinct, map.get(old)+1);
                }

                if(newCoord.x == fat2.x && newCoord.y == fat2.y) {
                    shiva = true;
                    good = distinct;
                    break;
                }
            }

            if(shiva) {
                break;
            }



        }
        if(good == 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(map.get(good));
        }







        


    }


    public static class Coordinate {
        long x;
        long y;

        public long getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public long getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public Coordinate(long x, long y) {
            this.x = x;
            this.y = y;
        }


    }



}
