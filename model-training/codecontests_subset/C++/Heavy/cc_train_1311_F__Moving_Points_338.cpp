#include <bits/stdc++.h>
#pragma GCC optimize(2)
#pragma GCC optimize(3)
using namespace std;
inline int read() {
  int x = 0, neg = 1;
  char op = getchar();
  while (!isdigit(op)) {
    if (op == '-') neg = -1;
    op = getchar();
  }
  while (isdigit(op)) {
    x = 10 * x + op - '0';
    op = getchar();
  }
  return neg * x;
}
inline void print(int x) {
  if (x < 0) {
    putchar('-');
    x = -x;
  }
  if (x >= 10) print(x / 10);
  putchar(x % 10 + '0');
}
const int N = 200005;
struct ele {
  int x;
  long long v;
  friend bool operator<(const ele &a, const ele &b) { return a.x < b.x; }
} a[N];
int b[N], tot;
int n;
struct Bitcount {
  int c[N];
  void add(int x, int v) {
    while (x < N) {
      c[x] += v;
      x += (x & -x);
    }
  }
  int qry(int x) {
    int ret = 0;
    if (x < 0) return 0;
    while (x > 0) {
      ret += c[x];
      x -= (x & -x);
    }
    return ret;
  }
  int query(int l, int r) { return qry(r) - qry(l - 1); }
} bitc;
struct Bitsum {
  long long c[N];
  void add(int x, long long v) {
    while (x < N) {
      c[x] += v;
      x += (x & -x);
    }
  }
  long long qry(int x) {
    long long ret = 0;
    if (x < 0) return 0;
    while (x > 0) {
      ret += c[x];
      x -= (x & -x);
    }
    return ret;
  }
  long long query(int l, int r) { return qry(r) - qry(l - 1); }
} bits;
int main() {
  n = read();
  for (register int i = 1; i <= n; i++) {
    a[i].x = read();
  }
  for (register int i = 1; i <= n; i++) {
    a[i].v = read();
    b[++tot] = a[i].v;
  }
  sort(b + 1, b + tot + 1);
  tot = unique(b + 1, b + tot + 1) - (b + 1);
  sort(a + 1, a + n + 1);
  for (register int i = 1; i <= n; i++) {
    a[i].v = lower_bound(b + 1, b + tot + 1, a[i].v) - b;
  }
  long long ans = 0ll;
  for (register int i = n; i >= 1; i--) {
    long long possum = bits.query(a[i].v, N - 1);
    long long posnum = bitc.query(a[i].v, N - 1);
    ans += possum - 1ll * a[i].x * posnum;
    bits.add(a[i].v, a[i].x);
    bitc.add(a[i].v, 1);
  }
  printf("%lld\n", ans);
  return 0;
}
