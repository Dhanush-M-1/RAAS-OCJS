#include <bits/stdc++.h>
using namespace std;
const long long inf = 1e18;
const long long maxn = 2e5 + 10;
long long n, a[maxn], ans[maxn];
long long read() {
  long long x = 0, f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = x * 10 + ch - '0';
    ch = getchar();
  }
  return x * f;
}
void print(long long x) {
  if (x < 0) putchar('-'), x = -x;
  if (x > 9) print(x / 10);
  putchar(x % 10 + '0');
}
void write(long long x) {
  print(x);
  puts("");
}
struct Segment_Tree {
  struct Seg {
    long long mn, f;
  } tree[maxn << 2];
  void update(long long k) {
    tree[k].mn = min(tree[k << 1].mn, tree[k << 1 | 1].mn);
  }
  void down(long long k) {
    if (tree[k].f) {
      tree[k << 1].f += tree[k].f;
      tree[k << 1 | 1].f += tree[k].f;
      tree[k << 1].mn += tree[k].f;
      tree[k << 1 | 1].mn += tree[k].f;
      tree[k].f = 0;
    }
  }
  void build(long long k, long long l, long long r) {
    tree[k].f = 0;
    if (l == r) {
      tree[k].mn = a[l];
      return;
    }
    long long mid = (l + r) >> 1;
    build(k << 1, l, mid);
    build(k << 1 | 1, mid + 1, r);
    update(k);
  }
  void change(long long k, long long l, long long r, long long x, long long y,
              long long v) {
    if (x > y) return;
    if (x <= l && r <= y) {
      tree[k].mn += v;
      tree[k].f += v;
      return;
    }
    down(k);
    long long mid = (l + r) >> 1;
    if (x <= mid) change(k << 1, l, mid, x, y, v);
    if (mid < y) change(k << 1 | 1, mid + 1, r, x, y, v);
    update(k);
  }
  void erase(long long k, long long l, long long r, long long x) {
    if (l == r) {
      tree[k].mn = inf;
      tree[k].f = 0;
      return;
    }
    down(k);
    long long mid = (l + r) >> 1;
    if (x <= mid)
      erase(k << 1, l, mid, x);
    else
      erase(k << 1 | 1, mid + 1, r, x);
    update(k);
  }
  long long query(long long k, long long l, long long r) {
    if (l == r) return l;
    down(k);
    long long mid = (l + r) >> 1;
    if (!tree[k << 1 | 1].mn)
      return query(k << 1 | 1, mid + 1, r);
    else
      return query(k << 1, l, mid);
  }
} T;
signed main() {
  n = read();
  for (long long i = 1; i <= n; i++) a[i] = read();
  T.build(1, 1, n);
  for (long long i = 1; i <= n; i++) {
    long long pos = T.query(1, 1, n);
    ans[pos] = i;
    T.change(1, 1, n, pos + 1, n, -i);
    T.erase(1, 1, n, pos);
  }
  for (long long i = 1; i <= n; i++) printf("%lld ", ans[i]);
  puts("");
  return 0;
}
