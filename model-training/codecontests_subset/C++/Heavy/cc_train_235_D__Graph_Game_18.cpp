#include <bits/stdc++.h>
using namespace std;
const int inf = 0x20202020;
const int mod = 1000000007;
template <class T>
inline void read(T& x) {
  bool fu = 0;
  char c;
  for (c = getchar(); c <= 32; c = getchar())
    ;
  if (c == '-') fu = 1, c = getchar();
  for (x = 0; c > 32; c = getchar()) x = x * 10 + c - '0';
  if (fu) x = -x;
};
template <class T>
inline void read(T& x, T& y) {
  read(x);
  read(y);
}
template <class T>
inline void read(T& x, T& y, T& z) {
  read(x);
  read(y);
  read(z);
}
template <class T>
inline void read(T& x, T& y, T& z, T& q) {
  read(x);
  read(y);
  read(z);
  read(q);
}
const int DX[] = {1, 0, -1, 0}, DY[] = {0, 1, 0, -1};
long long powmod(long long a, long long b) {
  long long res = 1;
  a %= mod;
  for (; b; b >>= 1) {
    if (b & 1) res = res * a % mod;
    a = a * a % mod;
  }
  return res;
}
long long powmod(long long a, long long b, long long mod) {
  long long res = 1;
  a %= mod;
  for (; b; b >>= 1) {
    if (b & 1) res = res * a % mod;
    a = a * a % mod;
  }
  return res;
}
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
const int N = 111111, M = 111111;
int l, m, n, t, C, ctot;
int vis[N], cir[N], pt[N], dis[N], fa[N][22];
vector<int> a[N];
int dfs(int x, int f) {
  if (vis[x]) return x;
  vis[x] = 1;
  int t;
  for (int _tmp = ((int)(a[x]).size()) - 1, i = 0; i <= _tmp; ++i)
    if (a[x][i] != f) {
      if (t = dfs(a[x][i], x)) {
        cir[++ctot] = x;
        if (x == t) return 0;
        return t;
      }
    } else
      f = 0;
  return 0;
}
void dfs(int x) {
  for (int _tmp = ((int)(a[x]).size()) - 1, i = 0; i <= _tmp; ++i)
    if (!pt[a[x][i]]) {
      dis[a[x][i]] = dis[x] + 1;
      pt[a[x][i]] = pt[x];
      fa[a[x][i]][0] = x;
      dfs(a[x][i]);
    }
}
int lca(int x, int y) {
  if (dis[x] > dis[y]) swap(x, y);
  for (int _tmp = 0, i = 20; i >= _tmp; --i)
    if (fa[y][i] && dis[fa[y][i]] >= dis[x]) y = fa[y][i];
  if (x == y) return x;
  for (int _tmp = 0, i = 20; i >= _tmp; --i)
    if (fa[y][i] != fa[x][i]) y = fa[y][i], x = fa[x][i];
  return fa[y][0];
}
int main() {
  scanf("%d", &n);
  for (int _tmp = n, i = 1; i <= _tmp; ++i)
    scanf("%d%d", &l, &t), ++l, ++t, a[l].push_back(t), a[t].push_back(l);
  dfs(1, 0);
  for (int _tmp = ctot, i = 1; i <= _tmp; ++i) pt[cir[i]] = i;
  for (int _tmp = ctot, i = 1; i <= _tmp; ++i) dfs(cir[i]);
  for (int _tmp = 20, i = 1; i <= _tmp; ++i)
    for (int _tmp = n, j = 1; j <= _tmp; ++j)
      fa[j][i] = fa[fa[j][i - 1]][i - 1];
  double ans = 0;
  for (int _tmp = n, i = 1; i <= _tmp; ++i)
    for (int _tmp = n, j = 1; j <= _tmp; ++j)
      if (i != j) {
        if (pt[i] == pt[j]) {
          int p = dis[i] + dis[j] - 2 * dis[lca(i, j)] + 1;
          ans += 1.0 / p;
        } else {
          int p1 = dis[i] + dis[j], p2 = abs(pt[i] - pt[j]),
              p3 = ctot - abs(pt[i] - pt[j]);
          ans +=
              1.0 / (p1 + p2 + 1) + 1.0 / (p1 + p3 + 1) - 1.0 / (p1 + p2 + p3);
        }
      }
  printf("%.9lf\n", ans + n);
  return 0;
}
