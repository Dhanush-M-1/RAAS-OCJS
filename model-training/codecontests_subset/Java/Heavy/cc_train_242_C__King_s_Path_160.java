import java.io.*;
import java.util.*;

public class P242C
{
    public static StringTokenizer st;
    public static void nextLine(BufferedReader br) throws IOException
    {
        st = new StringTokenizer(br.readLine());
    }
    
    public static String next()
    {
        return st.nextToken();
    }
    
    public static int nextInt()
    {
        return Integer.parseInt(st.nextToken());
    }
    
    public static long nextLong()
    {
        return Long.parseLong(st.nextToken());
    }
    
    public static double nextDouble()
    {
        return Double.parseDouble(st.nextToken());
    }
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nextLine(br);
        int x0 = nextInt();
        int y0 = nextInt();
        int x1 = nextInt();
        int y1 = nextInt();
        nextLine(br);
        int n = nextInt();
        HashMap<Integer, ArrayList<Pair>> map = new HashMap<Integer, ArrayList<Pair>>();
        for (int i = 0; i < n; i++)
        {
            nextLine(br);
            int r = nextInt();
            int a = nextInt();
            int b = nextInt();
            if (map.containsKey(r))
            {
                map.get(r).add(new Pair(a, b));
            }
            else
            {
                ArrayList<Pair> list = new ArrayList<Pair>();
                list.add(new Pair(a, b));
                map.put(r, list);
            }
        }
        for (Map.Entry<Integer, ArrayList<Pair>> entry : map.entrySet())
        {
            ArrayList<Pair> list = entry.getValue();
            ArrayList<Pair> temp = new ArrayList<Pair>();
            temp.addAll(list);
            list.clear();
            Collections.sort(temp);
            int lb = -1;
            int rb = -1;
            for (int i = 0; i < temp.size(); i++)
            {
                if (lb == -1)
                {
                    lb = temp.get(i).x;
                    rb = temp.get(i).y;
                    continue;
                }
                if (temp.get(i).x <= rb + 1)
                {
                    rb = Math.max(rb, temp.get(i).y);
                }
                else
                {
                    list.add(new Pair(lb, rb));
                    lb = temp.get(i).x;
                    rb = temp.get(i).y;
                }
            }
            list.add(new Pair(lb, rb));
        }
        HashMap<Pair, Integer> dists = new HashMap<Pair, Integer>();
        Pair start = new Pair(x0, y0);
        dists.put(start, 0);
        LinkedList<Pair> queue = new LinkedList<Pair>();
        queue.offer(start);
        int found = -1;
        while (!queue.isEmpty())
        {
            Pair pos = queue.poll();
            int d = dists.get(pos);
            for (int i = -1; i <= 1; i++)
            {
                for (int j = -1; j <= 1; j++)
                {
                    Pair next = new Pair(pos.x + i, pos.y + j);
                    if (dists.containsKey(next))
                    {
                        continue;
                    }
                    if (next.x == x1 && next.y == y1)
                    {
                        found = d+1;
                        break;
                    }
                    if (exists(map, next.x, next.y))
                    {
                        dists.put(next, d+1);
                        queue.offer(next);
                    }
                }
            }
            if (found != -1)
            {
                break;
            }
        }
        System.out.println(found);
    }
    
    private static boolean exists(HashMap<Integer, ArrayList<Pair>> map, int x, int y)
    {
        ArrayList<Pair> list = map.get(x);
        if (list == null) return false;
        int l = 0, r = list.size() - 1;
        while (l < r)
        {
            int m = (l + r) / 2;
            if (list.get(m).x <= y && list.get(m).y >= y)
            {
                return true;
            }
            if (list.get(m).y < y)
            {
                l = m+1;
            }
            else
            {
                r = m;
            }
        }
        
        return list.get(l).x <= y && list.get(l).y >= y;
    }
    
    public static class Pair implements Comparable<Pair>
    {
        int x, y;
        public Pair (int xx, int yy)
        {
            x = xx;
            y = yy;
        }
        
        public int hashCode()
        {
            return (x*7) ^ y;
        }

        public boolean equals(Object o)
        {
            if (!(o instanceof Pair)) return false;
            Pair p = (Pair)o;
            return x == p.x && y == p.y;
        }

        @Override
        public int compareTo(Pair o)
        {
            if (x == o.x)
            {
                return y - o.y;
            }
            else return x-o.x;
        }
    }
}