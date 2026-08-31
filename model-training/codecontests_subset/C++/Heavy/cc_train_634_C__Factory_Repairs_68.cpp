#include <bits/stdc++.h>
using namespace std;
struct segment_tree {
 private:
  int n, m;
  vector<long long> tree;
  void update_tree(int a, int b, int pos, int node, long long value) {
    if (a > b || a > pos || b < pos) return;
    if (a == b) {
      tree[node] += value;
      tree[node] = min(tree[node], (long long)(m));
      return;
    }
    update_tree(a, (a + b) >> 1, pos, node << 1, value);
    update_tree(((a + b) >> 1) + 1, b, pos, (node << 1) | 1, value);
    tree[node] = tree[node << 1] + tree[(node << 1) | 1];
  }
  long long query_tree(int a, int b, int i, int j, int node) {
    if (a > b || a > j || b < i) return 0;
    if (a >= i && b <= j) return tree[node];
    return query_tree(a, (a + b) >> 1, i, j, node << 1) +
           query_tree(((a + b) >> 1) + 1, b, i, j, (node << 1) | 1);
  }

 public:
  void initialize(int k, int p) {
    n = k;
    m = p;
    tree.assign((n << 2) + 5, 0);
  }
  void update(int pos, long long value) { update_tree(1, n, pos, 1, value); }
  long long query(int l, int r) { return query_tree(1, n, l, r, 1); }
};
int n, k, a, b, q;
segment_tree lt, rt;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int type, x, y;
  scanf("%d %d %d %d %d", &n, &k, &a, &b, &q);
  lt.initialize(n, b);
  rt.initialize(n, a);
  while (q--) {
    scanf("%d", &type);
    if (type == 1) {
      scanf("%d %d", &x, &y);
      lt.update(x, y);
      rt.update(x, y);
    } else {
      scanf("%d", &x);
      printf("%lld\n", lt.query(1, x - 1) + rt.query(x + k, n));
    }
  }
  return 0;
}
