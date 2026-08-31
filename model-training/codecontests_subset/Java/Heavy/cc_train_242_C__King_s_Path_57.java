import java.io.*;
import java.util.*;

public class test1
{
    public static void main(String[] args) throws Exception
    {
        new test1().run();
    }

    PrintWriter out = null;

    void run() throws Exception
    {
        Scanner in = new Scanner(System.in);
        out = new PrintWriter(System.out);
        Point start=new Point(in.nextInt(),in.nextInt());
        Point end=new Point(in.nextInt(),in.nextInt());
        
        int n=in.nextInt();

        HashSet<Point> hs=new HashSet<Point>();
        HashSet<Point> visited=new HashSet<Point>();

        for(int i=0;i<n;i++)
        {
            int r=in.nextInt();
            int a=in.nextInt();
            int b=in.nextInt();
            for(int j=a;j<=b;j++)
            {
                hs.add(new Point(r,j));
            }
        }
        
        Queue<Point> queue=new LinkedList<Point>();
        queue.add(start);
        int ans=0;
        boolean f=false;
        
        while(!queue.isEmpty())
        {
            Point curr=queue.poll();
            if(curr.equals(end))
            {
                f=true;
                ans=curr.d;
                break;
            }

            for(int i=-1;i<=1;i++)
                for(int j=-1;j<=1;j++)
                {
                    Point p=new Point(curr.x+i,curr.y+j);
                    p.d=curr.d+1;
                    if(hs.contains(p) && visited.add(p))
                    {
                        queue.add(p);
                    }
                }
        }
        
        if(f)
            out.println(ans);
        else
            out.println(-1);
        out.close();
    }
}

class Point
{
    int x;
    int y;
    int d;
    public Point(int _x, int _y)
    {
        x=_x;
        y=_y;
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
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Point other = (Point) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }
}
