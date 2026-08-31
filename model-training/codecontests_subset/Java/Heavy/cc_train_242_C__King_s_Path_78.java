import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
/**
 * Problem description: http://codeforces.com/problemset/problem/242/C
 */
public class KingsPath {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Point start = new Point(in.nextInt(), in.nextInt());
        Point end = new Point(in.nextInt(), in.nextInt());
        HashMap<Point, Set<Point>> allAllowed = new HashMap<>();

        // check if start and end are adjacent, if so, print 1 and exit
        if (start.x <= end.x+1 && start.x >= end.x-1
                && start.y <= end.y+1 && start.y >= end.y-1) {
            in.close();
            System.out.println((start.equals(end) ? 0 : 1));
            return;
        }

        allAllowed.put(start, new HashSet<>());
        allAllowed.put(end, new HashSet<>());
        int segments = in.nextInt();

        // Make graph
        for (int segment = 0; segment < segments; segment++) {
            int x = in.nextInt();
            int ystart = in.nextInt();
            int yend = in.nextInt();
            for (int y = ystart; y <= yend; y++) {
                Point p = new Point(x, y);
                if (!allAllowed.containsKey(p)) {
                    Set<Point> neighbors = new HashSet<>();
                    for (int xd = -1; xd <= 1; xd++) {
                        for (int yd = -1; yd <= 1; yd++) {
                            if (xd != 0 || yd != 0) {
                                Point n = new Point(x + xd, y + yd);
                                if (allAllowed.containsKey(n)) {
                                    Set<Point> neighborSet = allAllowed.get(n);
                                    neighborSet.add(p);
                                    neighbors.add(n);
                                }
                            }
                        }
                    }
                    allAllowed.put(p, neighbors);
                }
            }
        }
        in.close();

        // Print nodes and their edges
        // for (Map.Entry<Point, Set<Point>> e : allAllowed.entrySet()) {
        //     System.out.printf("%n\t(%d, %d)%n", e.getKey().x, e.getKey().y);
        //     System.out.println("------------------------");
        //     for (Point p : e.getValue()) {
        //         System.out.printf("(%d, %d), ", p.x, p.y);
        //     }
        //     System.out.println();
        // }

        // Do BFS
        Set<Point> visited = new HashSet<>();
        Queue<Point> currQueue = new LinkedList<>();
        Queue<Point> nextQueue = new LinkedList<>();
        currQueue.add(start);
        int count = 0;
        while (!currQueue.isEmpty() || !nextQueue.isEmpty()) {
            if (currQueue.isEmpty()) {
                count++;
                currQueue = nextQueue;
                nextQueue = new LinkedList<>();
            }
            Point p = currQueue.poll();
            if (!visited.contains(p)) {
                if (p.equals(end)) {
                    System.out.println(count);
                    return;
                }
                visited.add(p);
                for (Point neighbor : allAllowed.get(p)) {
                    nextQueue.add(neighbor);
                }
            }
        }
        System.out.println(-1);
    }
}