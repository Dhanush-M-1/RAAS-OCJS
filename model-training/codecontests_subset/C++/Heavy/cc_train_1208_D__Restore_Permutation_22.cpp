#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 10;
int ans[maxn];
int n;
long long a[maxn];
const int maxnode = maxn << 2;
long long sum[maxnode], add[maxnode];
struct Node {
  int l, r;
  int mid() { return (l + r) >> 1; }
} node[maxnode];
void Pushup(int rt) { sum[rt] = sum[rt << 1] + sum[rt << 1 | 1]; }
void Pushdown(int rt, int m) {
  if (add[rt]) {
    add[rt << 1] += add[rt];
    add[rt << 1 | 1] += add[rt];
    sum[rt << 1] += add[rt] * (m - (m >> 1));
    sum[rt << 1 | 1] += add[rt] * (m >> 1);
    add[rt] = 0;
  }
}
void build(int l, int r, int rt) {
  node[rt].l = l;
  node[rt].r = r;
  add[rt] = 0;
  if (l == r) {
    sum[rt] = (long long)l;
    return;
  }
  int m = node[rt].mid();
  build(l, m, rt << 1);
  build(m + 1, r, rt << 1 | 1);
  Pushup(rt);
}
void update(int c, int l, int r, int rt) {
  if (node[rt].l == l && node[rt].r == r) {
    add[rt] += c;
    sum[rt] += (long long)c * (r - l + 1);
    return;
  }
  if (node[rt].l == node[rt].r) return;
  Pushdown(rt, node[rt].r - node[rt].l + 1);
  int m = node[rt].mid();
  if (r <= m)
    update(c, l, r, rt << 1);
  else if (l > m)
    update(c, l, r, rt << 1 | 1);
  else {
    update(c, l, m, rt << 1);
    update(c, m + 1, r, rt << 1 | 1);
  }
  Pushup(rt);
}
int res;
void query(int l, int r, int rt, long long x) {
  if (l == r) {
    res = l;
    return;
  }
  int m = node[rt].mid();
  Pushdown(rt, m);
  if (sum[rt << 1] > x && sum[rt << 1] > 0)
    query(l, m, rt << 1, x);
  else
    query(m + 1, r, rt << 1 | 1, x - sum[rt << 1]);
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%lld", &a[i]);
  build(1, n, 1);
  for (int i = n; i; i--) {
    query(1, n, 1, a[i]);
    ans[i] = res;
    update(-res, res, res, 1);
  }
  for (int i = 1; i <= n; i++) printf("%d ", ans[i]);
  return 0;
}
