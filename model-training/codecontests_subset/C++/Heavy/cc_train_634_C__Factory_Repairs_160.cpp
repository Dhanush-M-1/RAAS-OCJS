#include <bits/stdc++.h>
using namespace std;
long long pwr(long long base, long long p, long long mod = (1000000007LL)) {
  long long ans = 1;
  while (p) {
    if (p & 1) ans = (ans * base) % mod;
    base = (base * base) % mod;
    p /= 2;
  }
  return ans;
}
int n, k;
long long a, b, tree[2][4 * 200003];
void update(int node, int s, int e, int pos, int val) {
  if (s > e || pos < s || pos > e) return;
  if (s == e) {
    tree[0][node] = min(b, tree[0][node] + val);
    tree[1][node] = min(a, tree[1][node] + val);
    return;
  }
  int mid = (s + e) / 2;
  update((2 * (node)), s, mid, pos, val);
  update((2 * (node) + 1), mid + 1, e, pos, val);
  tree[0][node] = tree[0][(2 * (node))] + tree[0][(2 * (node) + 1)];
  tree[1][node] = tree[1][(2 * (node))] + tree[1][(2 * (node) + 1)];
}
long long query(int type, int node, int s, int e, int lo, int hi) {
  if (s > e || s > hi || lo > e) return 0;
  if (s >= lo && e <= hi) return tree[type][node];
  int mid = (s + e) / 2;
  return query(type, (2 * (node)), s, mid, lo, hi) +
         query(type, (2 * (node) + 1), mid + 1, e, lo, hi);
}
int main() {
  int q;
  scanf("%d%d%I64d%I64d%d", &n, &k, &a, &b, &q);
  while (q--) {
    int type;
    scanf("%d", &type);
    if (type == 1) {
      int day, extra;
      scanf("%d%d", &day, &extra);
      update(1, 1, n, day, extra);
    } else {
      int day;
      scanf("%d", &day);
      long long ans =
          query(0, 1, 1, n, 1, day - 1) + query(1, 1, 1, n, day + k, n);
      printf("%I64d\n", ans);
    }
  }
  return 0;
}
