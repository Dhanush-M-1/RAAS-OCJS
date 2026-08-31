#include <bits/stdc++.h>
using namespace std;
template <class T>
inline void umax(T &a, T b) {
  if (a < b) a = b;
}
template <class T>
inline void umin(T &a, T b) {
  if (a > b) a = b;
}
template <class T>
inline T abs(T a) {
  return a > 0 ? a : -a;
}
template <class T>
inline T gcd(T a, T b) {
  return __gcd(a, b);
}
template <class T>
inline T lcm(T a, T b) {
  return a / gcd(a, b) * b;
}
const int inf = 1e9 + 143;
const long long longinf = 1e18 + 143;
inline int read() {
  int x;
  scanf(" %d", &x);
  return x;
}
const int N = 101001;
const int LOG = 17;
const int mod = 1e9 + 7;
inline int add(int x, int y) { return (x + y >= mod) ? x + y - mod : x + y; }
inline int mul(int x, int y) { return (long long)x * y % mod; }
struct info {
  int a, b, c;
  info() : a(0), b(0), c(0) {}
  info(int _a, int _b, int _c) : a(_a), b(_b), c(_c) {}
  info operator+(const info &other) {
    return info(add(a, other.a), add(b, other.b), add(c, other.c));
  }
  info operator-(const info &other) {
    return info(add(a, mod - other.a), add(b, mod - other.b),
                add(c, mod - other.c));
  }
  info operator*(const int &x) {
    info res;
    res.a = add(a, mul(b, mul(2, x)));
    res.a = add(res.a, mul(c, mul(x, x)));
    res.b = add(b, mul(c, x));
    res.c = c;
    return res;
  }
  void newnode() { ++c; }
};
vector<pair<int, int> > g[N];
info down[N], up[N];
int d[N], de[N];
int anc[N][LOG];
void dfs1(int u, int p) {
  anc[u][0] = p;
  for (int i = 1; i < LOG; i++) anc[u][i] = anc[anc[u][i - 1]][i - 1];
  for (__typeof((g[u]).begin()) it = (g[u]).begin(); it != (g[u]).end(); it++) {
    int v = it->first;
    int c = it->second;
    if (v != p) {
      d[v] = add(d[u], c);
      de[v] = de[u] + 1;
      dfs1(v, u);
      down[u] = down[u] + (down[v] * c);
    }
  }
  down[u].newnode();
}
void dfs2(int u, int p) {
  info sum;
  for (__typeof((g[u]).begin()) it = (g[u]).begin(); it != (g[u]).end(); it++) {
    int v = it->first;
    int c = it->second;
    if (v != p) {
      sum = sum + (down[v] * c);
    }
  }
  for (__typeof((g[u]).begin()) it = (g[u]).begin(); it != (g[u]).end(); it++) {
    int v = it->first;
    int c = it->second;
    if (v != p) {
      up[v] = sum - (down[v] * c) + up[u];
      up[v].newnode();
      up[v] = up[v] * c;
      dfs2(v, u);
    }
  }
}
int getlca(int u, int v) {
  if (de[u] < de[v]) swap(u, v);
  for (int i = 0; i < LOG; i++) {
    if ((de[u] - de[v]) & (1 << i)) u = anc[u][i];
  }
  if (u == v) return u;
  for (int i = LOG - 1; i >= 0; i--)
    if (anc[u][i] != anc[v][i]) {
      u = anc[u][i];
      v = anc[v][i];
    }
  return anc[u][0];
}
int main() {
  int n = read();
  for (int i = 1; i < n; i++) {
    int u = read(), v = read(), c = read();
    g[u].push_back(pair<int, int>(v, c));
    g[v].push_back(pair<int, int>(u, c));
  }
  dfs1(1, 0);
  dfs2(1, 0);
  int q = read();
  while (q--) {
    int u = read(), v = read();
    int lca = getlca(u, v);
    int dist = add(d[u], add(d[v], mod - mul(2, d[lca])));
    if (lca == v) {
      info toall = up[u] + down[u];
      info unsub = up[v] * dist;
      0;
      printf("%d\n", add(toall.a, mod - mul(2, unsub.a)));
    } else {
      info toall = up[u] + down[u];
      info sub = down[v] * dist;
      0;
      printf("%d\n", mod - add(toall.a, mod - mul(2, sub.a)));
    }
  }
  return 0;
}
