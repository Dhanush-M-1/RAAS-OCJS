import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

class Camel {
  public int k;
  public int l;
  public int r;
  public int dif;

  Camel(int k, int l, int r) {
    this.k = k;
    this.l = l;
    this.r = r;
    dif = l - r;
  }
}

public class Main {

  static int t, n;
  static long ans;
  static int[] dp;
  static List<Camel> lcamels, rcamels;
  static String x;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);

    String[] in = br.readLine().split(" ");
    t = Integer.parseInt(in[0]);

    for (int i = 0; i < t; i++) {
      in = br.readLine().split(" ");
      n = Integer.parseInt(in[0]);

      lcamels = new ArrayList<>();
      rcamels = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        in = br.readLine().split(" ");
        int k = Integer.parseInt(in[0]);
        int l = Integer.parseInt(in[1]);
        int r = Integer.parseInt(in[2]);
        if (l >= r) {
          lcamels.add(new Camel(k - 1, l, r));
        } else {
          rcamels.add(new Camel(k, l, r));
        }
      }

      out.println(solve());
    }

    br.close();

    out.flush();
  }

  public static long solve() {

    long ret = 0;

    if (!lcamels.isEmpty()) {
      Collections.sort(lcamels, new MyComparatorKAsce());
      ret += lcamels.stream().mapToLong(c -> c.r).sum();

      PriorityQueue<Camel> pq = new PriorityQueue<>(new MyComparatorDifAsce());
      int cnt = 0;
      for (int i = 0; i < n; i++) {
        while (cnt < lcamels.size() && lcamels.get(cnt).k <= i) {
          pq.add(lcamels.get(cnt++));
        }
        while (pq.size() > i + 1) {
          pq.poll();
        }
      }

      while (!pq.isEmpty()) {
        ret += pq.poll().dif;
      }
    }

    if (!rcamels.isEmpty()) {
      Collections.sort(rcamels, new MyComparatorKDesc());
      ret += rcamels.stream().mapToLong(c -> c.l).sum();

      PriorityQueue<Camel> pq = new PriorityQueue<>(new MyComparatorDifDesc());
      int cnt = 0;
      while (cnt < rcamels.size() && rcamels.get(cnt).k == n) {
        cnt++;
      }
      for (int i = 0; i < n; i++) {
        while (cnt < rcamels.size() && rcamels.get(cnt).k >= n - i - 1) {
          pq.add(rcamels.get(cnt++));
        }
        while (pq.size() > i + 1) {
          pq.poll();
        }
      }

      while (!pq.isEmpty()) {
        ret += -pq.poll().dif;
      }
    }

    return ret;
  }
}

// 昇順
class MyComparatorKAsce implements Comparator {
  @Override
  public int compare(Object obj0, Object obj1) {
    Camel cls0 = (Camel) obj0;
    Camel cls1 = (Camel) obj1;

    if (cls0.k > cls1.k) {
      return 1;
    } else if (cls0.k < cls1.k) {
      return -1;
    } else {
      return 0;
    }
  }
}

// 降順
class MyComparatorKDesc implements Comparator {
  @Override
  public int compare(Object obj0, Object obj1) {
    Camel cls0 = (Camel) obj0;
    Camel cls1 = (Camel) obj1;

    if (cls0.k < cls1.k) {
      return 1;
    } else if (cls0.k > cls1.k) {
      return -1;
    } else {
      return 0;
    }
  }
}

// 昇順
class MyComparatorDifAsce implements Comparator {
  @Override
  public int compare(Object obj0, Object obj1) {
    Camel cls0 = (Camel) obj0;
    Camel cls1 = (Camel) obj1;

    if (cls0.dif > cls1.dif) {
      return 1;
    } else if (cls0.dif < cls1.dif) {
      return -1;
    } else {
      return 0;
    }
  }
}

// 降順
class MyComparatorDifDesc implements Comparator {
  @Override
  public int compare(Object obj0, Object obj1) {
    Camel cls0 = (Camel) obj0;
    Camel cls1 = (Camel) obj1;

    if (cls0.dif < cls1.dif) {
      return 1;
    } else if (cls0.dif > cls1.dif) {
      return -1;
    } else {
      return 0;
    }
  }
}
