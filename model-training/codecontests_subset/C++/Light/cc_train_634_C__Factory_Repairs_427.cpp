#include <bits/stdc++.h>
using namespace std;
int n, k, a, b, q, c[200010], tem, x, y;
struct node {
  int t1, t2;
} tree[200010];
void add(int s, int v, int t) {
  if (t == 1)
    while (s <= n) {
      tree[s].t1 += v;
      s += s & (-s);
    }
  else
    while (s <= n) {
      tree[s].t2 += v;
      s += s & (-s);
    }
}
int sum(int s, int t) {
  int res = 0;
  if (t == 1)
    while (s) {
      res += tree[s].t1;
      s -= s & (-s);
    }
  else
    while (s) {
      res += tree[s].t2;
      s -= s & (-s);
    }
  return res;
}
int main() {
  scanf("%d%d%d%d%d", &n, &k, &a, &b, &q);
  memset(tree, 0, sizeof(tree));
  memset(c, 0, sizeof(c));
  for (int i = 0; i < q; i++) {
    scanf("%d", &tem);
    if (tem == 1) {
      scanf("%d%d", &x, &y);
      if (c[x] < a) add(x, min(y, a - c[x]), 2);
      if (c[x] < b) add(x, min(y, b - c[x]), 1);
      c[x] += y;
    } else {
      scanf("%d", &x);
      int ans = 0;
      if (x != 1) ans += sum(x - 1, 1);
      if (x + k <= n) ans += sum(n, 2) - sum(x + k - 1, 2);
      printf("%d\n", ans);
    }
  }
}
