import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

import javax.sound.sampled.Port;


public class C_Div2_149 {
    public static void main(String[]arg) throws IOException
    {
        new C_Div2_149().solve();
    }
    HashMap<Integer, ArrayList<Point>> map;
    int lim = 1000000000;
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
    public void solve()throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        map = new HashMap<Integer, ArrayList<Point>>();
        int x0,y0,x1,y1;
        ArrayList<Point> arr;
        x0 = Integer.parseInt(st.nextToken());
        y0 = Integer.parseInt(st.nextToken());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(in.readLine()),nn;
        int row, colA,colB;
        for(nn = 0; nn < n; nn++)
        {
            st = new StringTokenizer(in.readLine());
            row = Integer.parseInt(st.nextToken());
            colA = Integer.parseInt(st.nextToken());
            colB = Integer.parseInt(st.nextToken());
            if(map.containsKey(row))
            {
                arr = map.get(row);
                arr.add(new Point(colA,colB));
                map.put(row, arr);
            }
            else
            {
                arr = new ArrayList<Point>();
                arr.add(new Point(colA,colB));
                map.put(row, arr);
            }
        }
        ArrayDeque<Integer> qx = new ArrayDeque<Integer>();
        ArrayDeque<Integer> qy = new ArrayDeque<Integer>();
        ArrayDeque<Integer> qz = new ArrayDeque<Integer>();
        qx.add(x0);
        qy.add(y0); 
        qz.add(0);
        HashSet<String> set = new HashSet<String>();
        set.add(x0+""+y0);
        int d;
        int x = 0,y=0,xn,yn,m,min = Integer.MAX_VALUE;
        boolean found = false;
        while(!qx.isEmpty())
        {           
            x = qx.poll();
            y = qy.poll();
            m = qz.poll();
            if(x == x1 && y == y1)
            {
                found = true;
                min = Math.min(m, min);
            }
            for(d = 0; d < 8; d++)
            {
                xn = x + dir[d][0];
                yn = y + dir[d][1];
                //System.out.println(valid(xn, yn));
                if(xn > 0 && yn > 0 && xn <= lim && yn <= lim)
                {
                    if(!set.contains(xn + "" + yn))
                    {
                        if(valid(xn, yn))
                        {
                            qx.add(xn);
                            qy.add(yn);
                            qz.add(m+1);
                            set.add(xn+""+yn);
                        }
                    }
                }
            }
        }
        if(found)
        {
            System.out.println(min);
        }
        else
            System.out.println(-1);
    }
    private boolean valid(int x, int y)
    {
        boolean flag = false;
        Point p; 
        ArrayList<Point> arr;
        int i;
        if(map.containsKey(x))
        {
            arr = map.get(x);
            for(i = 0; i < arr.size() && !flag; i++)
            {
                p = arr.get(i);
                if(y >= p.x && y <= p.y)
                {                   
                    flag = true;
                }
            }
        }
        return flag;
    }
}
