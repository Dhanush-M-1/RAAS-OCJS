import java.util.*;
import java.io.*;
public class KingsPath
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        Cell start = new Cell(in.nextInt(), in.nextInt());
        Cell end = new Cell(in.nextInt(), in.nextInt());
        
        TreeMap<Cell, ArrayList<Cell>> map = new TreeMap<Cell, ArrayList<Cell>>();
        ArrayList<Cell> cells = new ArrayList<Cell>();
        
        int[] dr = {1, 1, 0, -1, -1, -1, 0, 1};
        int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};
        
        int n = in.nextInt();
        for(int x = 0; x < n; x++)
        {
            int r = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            
            for(int y = a; y <= b; y++)
            {
                Cell current = new Cell(r, y);
                if(!map.containsKey(current))
                {
                    map.put(current, new ArrayList<Cell>());
                    
                    cells.add(current);
                    
                    for(int z = 0; z < dr.length; z++)
                    {
                        Cell next = new Cell(current.r + dr[z], current.c + dc[z]);
                        if(map.containsKey(next))
                        {
                            map.get(current).add(next);
                            map.get(next).add(current);
                        }
                    }
                }
            }
        }
        
        Collections.sort(cells);
        
        ArrayDeque<Cell> queue = new ArrayDeque<Cell>();
        queue.add(start);
        
        boolean[] visited = new boolean[cells.size()];
        int index = Collections.binarySearch(cells, start);
        visited[index] = true;
        
        int moves = 0;
        while(queue.size() > 0)
        {
            int size = queue.size();
            for(int a = 0; a < size; a++)
            {
                Cell current = queue.remove();
                
                if(current.equals(end))
                {
                    System.out.println(moves);
                    return;
                }
                
                ArrayList<Cell> adj = map.get(current);
                
                for(int b = 0; b < adj.size(); b++)
                {
                    index = Collections.binarySearch(cells, adj.get(b));
                    
                    if(!visited[index])
                    {
                        visited[index] = true;
                        queue.add(adj.get(b));
                    }
                }
            }
            
            moves++;
        }
        
        System.out.println("-1");
    }
}

class Cell implements Comparable<Cell>
{
    int r;
    int c;
    
    public Cell(int r, int c)
    {
        this.r = r;
        this.c = c;
    }
    
    public boolean equals(Object o)
    {
        Cell C = (Cell)o;
        return (r == C.r && c == C.c);
    }
    
    public int compareTo(Cell o)
    {
        if(r != o.r)
        {
            return r - o.r;
        }
        else
        {
            return c - o.c;
        }
    }
}