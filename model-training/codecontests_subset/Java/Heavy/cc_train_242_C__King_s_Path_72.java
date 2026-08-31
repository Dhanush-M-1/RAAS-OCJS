import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;



public class Main
{
    
    static class Point{
        int x, y, level;
        Point(int x, int y, int level){
            this.x = x;
            this.y = y;
            this.level = level;
        }
    
        public String toString(){
            return x+", "+y;
        }
    }


	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    
	    int y0 = in.nextInt();
	    int x0 = in.nextInt();
	    int y1 = in.nextInt();
	    int x1 = in.nextInt();
	    int n = in.nextInt();
	    HashSet<String> allowed = new HashSet<String>();
	    for (int i = 0; i < n; i++){
	        int y = in.nextInt();
	        int x_start = in.nextInt();
	        int x_end = in.nextInt();
	        for(int j = x_start; j <= x_end; j++){
	            allowed.add(j+", "+ y);
	        }
	    }
	    Queue<Point> points = new LinkedList();
	    Set<String> visited = new HashSet<String>();
	    
	    points.add(new Point(x0, y0, 0));
	    
	    while(!points.isEmpty()){
	        Point current = points.remove();
	        if(current.x == x1 && current.y == y1){
	            System.out.println(current.level);
	            return;
	        }
	        Point n1 = new Point(current.x + 1, current.y, current.level + 1);
	        Point n2 = new Point(current.x - 1, current.y, current.level + 1);
	        Point n3 = new Point(current.x, current.y + 1, current.level + 1);
	        Point n4 = new Point(current.x, current.y - 1, current.level + 1);
	        Point n5 = new Point(current.x + 1, current.y + 1, current.level + 1);
	        Point n6 = new Point(current.x + 1, current.y - 1, current.level + 1);
	        Point n7 = new Point(current.x - 1, current.y + 1, current.level + 1);
	        Point n8 = new Point(current.x - 1, current.y - 1, current.level + 1);
	        if((!visited.contains(n1.toString())) && allowed.contains(n1.x+", "+ n1.y)){
	            points.add(n1);
	            visited.add(n1.toString());
	        }
	        if((!visited.contains(n2.toString())) && allowed.contains(n2.x+", "+ n2.y)){
	            points.add(n2);
	            visited.add(n2.toString());
	        }
	        if((!visited.contains(n3.toString())) && allowed.contains(n3.x+", "+ n3.y)){
	            points.add(n3);
	            visited.add(n3.toString());
	        }
	        if((!visited.contains(n4.toString())) && allowed.contains(n4.x+", "+ n4.y)){
	            points.add(n4);
	            visited.add(n4.toString());
	        }
	        if((!visited.contains(n5.toString())) && allowed.contains(n5.x+", "+ n5.y)){
	            points.add(n5);
	            visited.add(n5.toString());
	        }
	        if((!visited.contains(n6.toString())) && allowed.contains(n6.x+", "+ n6.y)){
	            points.add(n6);
	            visited.add(n6.toString());
	        }
	        if((!visited.contains(n7.toString())) && allowed.contains(n7.x+", "+ n7.y)){
	            points.add(n7);
	            visited.add(n7.toString());
	        }
	        if((!visited.contains(n8.toString())) && allowed.contains(n8.x+", "+ n8.y)){
	            points.add(n8);
	            visited.add(n8.toString());
	        }
	    }
	    
	     System.out.println(-1);
	     return;
	   
	}
}