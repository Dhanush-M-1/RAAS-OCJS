#include <bits/stdc++.h>
using namespace std;
const long long N = 2e6 + 5, inf = 1LL << 62;
long long read() {
  long long x = 0, f = 1;
  char ch;
  while (!isdigit(ch = getchar())) (ch == '-') && (f = -f);
  for (x = ch ^ 48; isdigit(ch = getchar());
       x = (x << 3) + (x << 1) + (ch ^ 48))
    ;
  return x * f;
}
template <class T>
T Max(T a, T b) {
  return a > b ? a : b;
}
template <class T>
T Min(T a, T b) {
  return a < b ? a : b;
}
struct Edge {
  long long to, val;
  Edge *nxt;
  Edge(long long to, long long val, Edge *nxt) : to(to), val(val), nxt(nxt) {}
} * head[N];
void add(long long x, long long y, long long z) {
  head[x] = new Edge(y, z, head[x]);
}
long long n, a[N], b[N], f[N];
void dfs(long long x) {
  f[x] = b[x] - a[x];
  for (Edge *i = head[x]; i; i = i->nxt) {
    dfs(i->to);
    if (f[i->to] < 0) {
      if (inf / i->val <= -f[i->to])
        f[x] = -inf;
      else {
        f[x] += f[i->to] * i->val;
        if (f[x] < -inf) f[x] = -inf;
      }
    } else
      f[x] += f[i->to];
  }
}
signed main() {
  n = read();
  for (long long i = 1; i <= n; ++i) b[i] = read();
  for (long long i = 1; i <= n; ++i) a[i] = read();
  for (long long i = 2, fa, val; i <= n; ++i) fa = read(), add(fa, i, read());
  dfs(1);
  puts(f[1] >= 0 ? "YES" : "NO");
  return 0;
}
