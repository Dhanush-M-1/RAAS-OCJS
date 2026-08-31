#include <bits/stdc++.h>
using namespace std;
template <class T>
inline void in(T &x) {
  x = 0;
  short f = 1;
  char c = getchar();
  while (c < '0' || c > '9') {
    if (c == '-') f = -1;
    c = getchar();
  }
  while (c >= '0' && c <= '9') x = x * 10 + (c ^ '0'), c = getchar();
  x *= f;
}
template <class T>
inline void out(T x, const char c = '\n') {
  static short st[30];
  short m = 0;
  if (x < 0) putchar('-'), x = -x;
  do st[++m] = x % 10, x /= 10;
  while (x);
  while (m) putchar(st[m--] | '0');
  putchar(c);
}
template <class T, class... Args>
inline void in(T &x, Args &...args) {
  in(x);
  in(args...);
}
template <class T, class... Args>
inline void out(const T &x, const Args &...args) {
  out(x, ' ');
  out(args...);
}
template <class T>
inline void prt(T a[], int n) {
  for (register int i = 0; i < n; ++i) out(a[i], ' ');
  putchar('\n');
}
template <class T>
inline void clr(T a[], int n) {
  memset(a, 0, sizeof(T) * n);
}
template <class T>
inline void clr(T *a, T *b) {
  memset(a, 0, sizeof(T) * (b - a));
}
template <class T>
inline bool ckmax(T &a, const T &b) {
  return a < b ? a = b, 1 : 0;
}
template <class T>
inline bool ckmin(T &a, const T &b) {
  return a > b ? a = b, 1 : 0;
}
namespace MOD_CALC {
const int md = 998244353;
inline int add(const int a, const int b) {
  return a + b >= md ? a + b - md : a + b;
}
inline int sub(const int a, const int b) {
  return a - b < 0 ? a - b + md : a - b;
}
inline int mul(const int a, const int b) { return (long long)a * b % md; }
inline void inc(int &a, const int b) { (a += b) >= md ? a -= md : 0; }
inline void dec(int &a, const int b) { (a -= b) < 0 ? a += md : 0; }
inline int qpow(int a, int b) {
  int r = 1;
  for (; b; b >>= 1, a = mul(a, a))
    if (b & 1) r = mul(r, a);
  return r;
}
inline int mdinv(const int a) { return qpow(a, md - 2); }
}  // namespace MOD_CALC
using namespace MOD_CALC;
namespace i207M {
int n;
vector<int> E[3005];
int du[3005];
int sz;
void topo() {
  static int q[3005];
  int hd = 1, tl = 0;
  for (register int i = 1; i <= n; ++i)
    if (du[i] == 1) q[++tl] = i;
  while (hd <= tl) {
    int x = q[hd++];
    for (const auto &v : E[x])
      if (--du[v] == 1) q[++tl] = v;
  }
  for (register int i = 1; i <= n; ++i)
    if (du[i] == 2) ++sz;
}
double ans;
bool vis[3005];
void dfs(int x, int d, int h) {
  if (vis[x]) return;
  vis[x] = 1;
  h += (du[x] == 2);
  if (h >= 2)
    ans += 1.0 / d + 1.0 / (d - h + 2 + sz - h) - 1.0 / (d + sz - h);
  else
    ans += 1.0 / d;
  for (const auto &v : E[x]) dfs(v, d + 1, h);
}
signed main() {
  in(n);
  for (register int i = 1, a, b; i <= n; ++i) {
    in(a, b);
    ++a, ++b;
    E[a].push_back(b), E[b].push_back(a);
    ++du[a], ++du[b];
  }
  topo();
  for (register int i = 1; i <= n; ++i) {
    memset(vis, 0, sizeof(vis));
    dfs(i, 1, 0);
  }
  printf("%.10f\n", ans);
  return 0;
}
}  // namespace i207M
signed main() {
  i207M::main();
  return 0;
}
