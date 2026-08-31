import java.util.*;
//多角形が凸であるか否か
public class Main{
    public static double area(Point p1, Point p2){
    	return (p1.x*p2.y - p1.y*p2.x)/2.0;
    }
    public static double solve(Point[] p){
	    double ans = 0;
	    for(int i = 0 ; i < p.length-1 ; i++)
            ans += area(p[i],p[i+1]);
	    return ans + area(p[p.length-1],p[0]);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point[] p = new Point[n];
	    Point[] work = new Point[n-1];
	    for(int i = 0 ; i < n ; i++)
		    p[i] = new Point(sc.nextDouble(),sc.nextDouble());
	    double ans = solve(p);
	    for(int i = 0 ; i < n ; i++){
		    int cnt = 0;
		        for(int j = 0 ; j < n ; j++){
			        if(j == i)
				        continue;
			        else
				        work[cnt++] = p[j];
		        }
		    if(solve(work) > ans){
			     System.out.println(0);
			     break;
		    }
		    else if(i == n-1)
			     System.out.println(1);
	    }
    }
}
class Point{
    double x;
    double y;
    Point(double x, double y){
        this.x = x;
        this.y = y;
    }
}

