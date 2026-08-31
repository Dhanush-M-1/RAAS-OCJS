// 勝手に変えてごめん！

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
 
public class Main
{
 
  static Integer[] x = new Integer[114514];
  static boolean used[] = new boolean[114514];
 
  public static void main(String[] args) throws IOException
  {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in), 1);
    String s = r.readLine();
    String[] sl = s.split("[\\s]+");
 
    int n = Integer.parseInt(sl[0]);
    int m = Integer.parseInt(sl[1]);
 
    HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<Integer, HashMap<Integer, Integer>>();
 
    for(int i = 0; i <= n; i++)
    {
      map.put(i, new HashMap<Integer, Integer>());
    }
 
    for(int i = 0; i < m; i++)
    {
      s = r.readLine();
      sl = s.split("[\\s]+");
      int left = Integer.parseInt(sl[0]);
      int right = Integer.parseInt(sl[1]);
      int dist = Integer.parseInt(sl[2]);
 
      HashMap<Integer, Integer> h = map.get(left);
      h.put(right, dist);
      h = map.get(right);
      h.put(left, - dist);
    }
 
    for(int i = 1; i <= n; i++)
    {
      x[i] = null;
    }
 
    for(int v = 1; v <= n; v++)
    {
      if(used[v]) continue;
      x[v] = 0;
      sub(map, v);
    }
 
 	/*
    for(int i = 1; i <= n; i++)
    {
      HashMap<Integer, Integer> h = map.get(i);
      for(Entry<Integer, Integer> e : h.entrySet())
      {
        if(x[e.getKey()] != x[i] + e.getValue())
        {
          System.out.println("No");
          System.exit(0);
        }
      }
    }
    */
 
    System.out.println("Yes");
 
  }
 
  public static void sub(HashMap<Integer, HashMap<Integer, Integer>> map, int i)
  {
    if(used[i]) return;
    used[i] = true;
    HashMap<Integer, Integer> h = map.get(i);
    for(Entry<Integer, Integer> e : h.entrySet())
    {
      if(x[e.getKey()] == null)
      {
        x[e.getKey()] = x[i] + e.getValue();
      	sub(map, e.getKey());
      }
      else
      {
        if(x[e.getKey()] != x[i] + e.getValue())
        {
          System.out.println("No");
          System.exit(0);
        }
      }
    }
  }
}