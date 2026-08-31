#include <bits/stdc++.h>
using namespace std;
const int MOD = 1000000007;
const int MAX = 200005;
struct Segtree {
  int arr[4 * MAX];
  int tree[4 * MAX];
  void build(int node, int a, int b) {
    if (a == b) {
      tree[node] = arr[a];
      return;
    }
    build(2 * node, a, (a + b) / 2);
    build(2 * node + 1, (a + b) / 2 + 1, b);
    tree[node] = tree[node * 2] + tree[node * 2 + 1];
  }
  void update(int node, int a, int b, int i, int value) {
    if (a > i || b < i) {
      return;
    }
    if (a == b) {
      tree[node] = value;
      return;
    }
    update(2 * node, a, (a + b) / 2, i, value);
    update(2 * node + 1, (a + b) / 2 + 1, b, i, value);
    tree[node] = tree[node * 2] + tree[node * 2 + 1];
  }
  int query(int node, int a, int b, int i, int j) {
    if (a > j || b < i) {
      return 0;
    }
    if (i <= a && b <= j) {
      return tree[node];
    }
    int x = query(2 * node, a, (a + b) / 2, i, j);
    int y = query(2 * node + 1, (a + b) / 2 + 1, b, i, j);
    return x + y;
  }
};
int order[MAX];
Segtree bef;
Segtree aft;
int main() {
  int n, k, a, b, q;
  cin >> n >> k >> a >> b >> q;
  for (int i = 0; i < q; i++) {
    int qt;
    scanf("%d", &qt);
    if (qt == 1) {
      int day, ord;
      scanf("%d %d", &day, &ord);
      order[day] += ord;
      bef.update(1, 1, n, day, min(order[day], b));
      aft.update(1, 1, n, day, min(order[day], a));
    } else {
      int b;
      scanf("%d", &b);
      int bend = b + k - 1;
      cout << bef.query(1, 1, n, 1, b - 1) + aft.query(1, 1, n, bend + 1, n)
           << endl;
    }
  }
}
