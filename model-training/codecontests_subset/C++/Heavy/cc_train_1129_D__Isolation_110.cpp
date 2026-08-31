#include <bits/stdc++.h>
using namespace std;
template <class T>
inline T lowbit(T x) {
  return x & (-x);
}
template <class T>
T gcd(T a, T b) {
  return b ? gcd(b, a % b) : a;
}
template <class T>
inline T Pow(T a, T b, T p) {
  T ret = 1;
  a %= p;
  for (; b; b >>= 1, a = a * a % p)
    if (b & 1) (ret *= a) %= p;
  return ret;
}
template <class T>
inline void read(T &ret) {
  T x = 0, f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = x * 10 + ch - '0';
    ch = getchar();
  }
  ret = x * f;
}
const int N = 1e5 + 10, M = 1e3 + 10;
const long long Z = 998244353;
struct node {
  int prev, w;
} lk[N];
int head[N], sz = 0;
void add(int x, int loc) {
  lk[++sz] = {head[x], loc};
  head[x] = sz;
}
int n, m, a[N], b[N], Prev[N];
int blo, bl[N];
long long f[N], g[M][M], sum[M];
inline long long __g(int x, int y) {
  if (y > blo * 2)
    return g[x][blo * 2];
  else if (y >= 0)
    return g[x][y];
  else
    return 0;
}
void modify(int x, int val, int up) {
  b[x] = val;
  int cur = 0;
  fill(g[bl[x]], g[bl[x]] + blo * 2 + 1, 0);
  for (int i = (min(up, ((bl[x] + 1) * blo) - 1)); i >= (((bl[x]) * blo));
       i--) {
    cur += b[i];
    (g[bl[x]][cur + blo] += f[i - 1]) %= Z;
  }
  sum[bl[x]] = cur;
  for (int i = (1); i <= (blo * 2); i++) (g[bl[x]][i] += g[bl[x]][i - 1]) %= Z;
}
long long query(int x) {
  long long ret = 0;
  long long cur = 0;
  for (int i = (bl[x]); i >= (0); i--) {
    (ret += __g(i, m - cur + blo)) %= Z;
    cur += sum[i];
  }
  return ret;
}
int main() {
  read(n);
  read(m);
  for (int i = (1); i <= (n); i++) {
    read(a[i]);
    add(a[i], i);
  }
  for (int i = (1); i <= (n); i++)
    for (int j = head[i]; j; j = lk[j].prev) Prev[lk[j].w] = lk[lk[j].prev].w;
  blo = ceil(sqrt(n / 6.0));
  for (int i = (1); i <= (n); i++) bl[i] = i / blo;
  f[0] = 1;
  for (int i = (1); i <= (n); i++) {
    int p = Prev[i], pp = Prev[p];
    if (pp) modify(pp, 0, i);
    if (p) modify(p, -1, i);
    modify(i, 1, i);
    f[i] = query(i);
  }
  printf("%lld\n", f[n]);
}
