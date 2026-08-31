import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class E {
  static class Item {
    int time;
    int alice;
    int bob;

    @Override
    public String toString() {
      return "Item{" +
          "time=" + time +
          ", alice=" + alice +
          ", bob=" + bob +
          '}';
    }
  }

  static PriorityQueue<Item> all;
  static PriorityQueue<Item> alice;
  static PriorityQueue<Item> bob;
  static int k;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n;
    n = in.nextInt();
    k = in.nextInt();
    Item[] items = new Item[n];
    for (int i = 0; i < n; i++) {
      items[i] = new Item();
      items[i].time = in.nextInt();
      items[i].alice = in.nextInt();
      items[i].bob = in.nextInt();
    }
    all = new PriorityQueue<Item>((a, b) -> b.time - a.time);
    alice = new PriorityQueue<>((a, b) -> a.time - b.time);
    bob = new PriorityQueue<>((a, b) -> a.time - b.time);


    Arrays.sort(items, (a, b) -> a.time - b.time);
    for (int i = 0; i < n; i++) {
      if (items[i].bob + items[i].alice == 2) {
        if (all.size() < k) {
          all.add(items[i]);
        }
      } else if (items[i].alice == 1) {
        if (alice.size() < k) {
          alice.add(items[i]);
        }
      } else if (items[i].bob == 1) {
        if (bob.size() < k) {
          bob.add(items[i]);
        }
      }
    }
    System.out.println(solve());
  }

  private static long solve() {
    if (alice.size() + all.size() < k) {
      return -1;
    }
    if (bob.size() + all.size() < k) {
      return -1;
    }
    long sum = 0;
    int count = 0;
    while (count < k) {
      if (alice.size() == 0 || bob.size() == 0) {
        if (all.size() + count < k) {
          return -1;
        }
        while (all.size() + count > k) {
          all.poll();
        }
        while (!all.isEmpty()) {
          sum += all.poll().time;
        }
        return sum;
      } else {
        if (all.size() == 0 || (alice.peek().time + bob.peek().time < all.peek().time)) {
//          System.out.println(alice.peek().toString() + " " + bob.peek());
          sum += alice.poll().time + bob.poll().time;
        } else {
          sum += all.poll().time;
        }
        count++;
      }
      while (all.size() + count > k) {
        all.poll();
      }
    }
    return sum;
  }
}
