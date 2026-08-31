#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:102400000,102400000")
using namespace std;
const long long inf = 1000000000000;
const int N = 200005;
const long long LLMAX = 2e18;
const long long MOD = 1000000009ll;
const double eps = 1e-8;
const int MAXN = 1e6 + 10;
int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
int read() {
  int x = 0, f = 1;
  char ch = getchar();
  while ((ch < '0') || (ch > '9')) {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while ((ch >= '0') && (ch <= '9')) {
    x = x * 10 + (ch - '0');
    ch = getchar();
  }
  return x * f;
}
int n, ans[N];
long long a[N];
struct SegmentTree {
  int l, r, id;
  long long v, add;
} tree[N * 4];
void push_up(int i) {
  if (tree[i << 1 | 1].v == tree[i << 1].v) {
    if (tree[i << 1 | 1].id > tree[i << 1].id) {
      tree[i].id = tree[i << 1 | 1].id;
      tree[i].v = tree[i << 1 | 1].v;
    } else {
      tree[i].id = tree[i << 1].id;
      tree[i].v = tree[i << 1].v;
    }
  } else {
    if (tree[i << 1].v < tree[i << 1 | 1].v) {
      tree[i].id = tree[i << 1].id;
      tree[i].v = tree[i << 1].v;
    } else {
      tree[i].id = tree[i << 1 | 1].id;
      tree[i].v = tree[i << 1 | 1].v;
    }
  }
  return;
}
void build(int p, int l, int r) {
  tree[p].l = l, tree[p].r = r;
  if (l == r) {
    tree[p].v = a[l];
    tree[p].id = r;
    return;
  }
  int mid = (l + r) >> 1;
  build(p << 1, l, mid);
  build(p << 1 | 1, mid + 1, r);
  push_up(p);
}
void spread(int p) {
  if (tree[p].add) {
    tree[p << 1].add += tree[p].add;
    tree[p << 1 | 1].add += tree[p].add;
    tree[p << 1].v += tree[p].add;
    tree[p << 1 | 1].v += tree[p].add;
    tree[p].add = 0;
  }
}
void change(int p, int l, int r, long long d) {
  if (l <= tree[p].l && r >= tree[p].r) {
    tree[p].v += d;
    tree[p].add += d;
    return;
  }
  spread(p);
  int mid = (tree[p].l + tree[p].r) >> 1;
  if (l <= mid) change(p << 1, l, r, d);
  if (r > mid) change(p << 1 | 1, l, r, d);
  push_up(p);
}
int main(int argc, char const *argv[]) {
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) scanf("%lld", &a[i]);
  build(1, 1, n);
  for (int i = 1; i <= n; ++i) {
    ans[tree[1].id] = i;
    int d = tree[1].id;
    change(1, d, d, 10000000000000);
    change(1, d + 1, n, -i);
  }
  for (int i = 1; i <= n; ++i) {
    printf("%d%c", ans[i], " \n"[i == n]);
  }
  return 0;
}
