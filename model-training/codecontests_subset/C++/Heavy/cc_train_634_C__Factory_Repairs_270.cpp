#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC optimize("no-stack-protector")
#pragma GCC optimize("unroll-loops")
#pragma GCC target("sse,sse2,sse3,ssse3,popcnt,abm,mmx,tune=native")
#pragma GCC optimize("fast-math")
using namespace std;
template <typename T>
inline void uin(T &a, T b) {
  if (b < a) a = b;
}
template <typename T>
inline void uax(T &a, T b) {
  if (b > a) a = b;
}
const long long maxn = 228228;
long long A[maxn];
long long n, k, a, b, q;
struct node {
  long long sum;
  long long mod;
  long long l, r;
  node() { sum = mod = l = r = 0; }
};
vector<node> d;
void build(long long l, long long r, long long v = 1) {
  d[v].l = l;
  d[v].r = r;
  if (l == r) return;
  long long m = (l + r) >> 1;
  build(l, m, v << 1);
  build(m + 1, r, v << 1 | 1);
}
inline void init(long long _n) {
  long long ss = 1;
  while (ss < _n) ss <<= 1;
  ss <<= 1;
  d.resize(ss + 5, node());
  build(1, _n);
}
inline long long gets(long long v) {
  return d[v].sum + d[v].mod * (d[v].r - d[v].l + 1);
}
inline void push(long long v) {
  d[v << 1].mod += d[v].mod;
  d[v << 1 | 1].mod += d[v].mod;
  d[v].mod = 0;
  d[v].sum = gets(v << 1) + gets(v << 1 | 1);
}
void update(long long l, long long r, long long x, long long v = 1) {
  if (l > r || d[v].l > r || d[v].r < l) return;
  if (l <= d[v].l && d[v].r <= r) {
    d[v].mod += x;
  } else {
    push(v);
    update(l, r, x, v << 1);
    update(l, r, x, v << 1 | 1);
    push(v);
  }
}
long long get(long long i, long long v = 1) {
  if (d[v].l == d[v].r) return gets(v);
  push(v);
  long long m = (d[v].l + d[v].r) >> 1;
  if (i <= m) return get(i, v << 1);
  return get(i, v << 1 | 1);
}
inline void solve1(long long d, long long new_a) {
  update(1, d - k, -min(a, A[d]));
  update(d + 1, n, -min(b, A[d]));
  A[d] += new_a;
  update(1, d - k, min(a, A[d]));
  update(d + 1, n, min(b, A[d]));
}
inline void solve() {
  cin >> n >> k >> a >> b >> q;
  init(n);
  for (long long iter = 1; iter <= (long long)q; ++iter) {
    long long type;
    cin >> type;
    if (type == 1) {
      long long d, a;
      cin >> d >> a;
      solve1(d, a);
    } else {
      long long p;
      cin >> p;
      cout << get(p) << '\n';
    }
    if (type == 2) continue;
  }
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  solve();
  return 0;
}
