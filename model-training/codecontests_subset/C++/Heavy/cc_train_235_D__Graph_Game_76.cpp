#include <bits/stdc++.h>
using namespace std;
template <typename T, typename U>
inline void smin(T &a, U b) {
  if (a > b) a = b;
}
template <typename T, typename U>
inline void smax(T &a, U b) {
  if (a < b) a = b;
}
template <class T>
inline void gn(T &first) {
  char c, sg = 0;
  while (c = getchar(), (c > '9' || c < '0') && c != '-')
    ;
  for ((c == '-' ? sg = 1, c = getchar() : 0), first = 0; c >= '0' && c <= '9';
       c = getchar())
    first = (first << 1) + (first << 3) + c - '0';
  if (sg) first = -first;
}
template <class T>
inline void print(T first) {
  if (first < 0) {
    putchar('-');
    return print(-first);
  }
  if (first < 10) {
    putchar('0' + first);
    return;
  }
  print(first / 10);
  putchar(first % 10 + '0');
}
template <class T, class T1>
inline void gn(T &first, T1 &second) {
  gn(first);
  gn(second);
}
template <class T, class T1, class T2>
inline void gn(T &first, T1 &second, T2 &z) {
  gn(first);
  gn(second);
  gn(z);
}
template <class T>
inline void println(T first) {
  print(first);
  putchar('\n');
}
template <class T>
inline void printsp(T first) {
  print(first);
  putchar(' ');
}
template <class T1, class T2>
inline void print(T1 x1, T2 x2) {
  printsp(x1), println(x2);
}
template <class T1, class T2, class T3>
inline void print(T1 x1, T2 x2, T3 x3) {
  printsp(x1), printsp(x2), println(x3);
}
template <class T1, class T2, class T3, class T4>
inline void print(T1 x1, T2 x2, T3 x3, T4 x4) {
  printsp(x1), printsp(x2), printsp(x3), println(x4);
}
int power(int a, int b, int m, int ans = 1) {
  for (; b; b >>= 1, a = 1LL * a * a % m)
    if (b & 1) ans = 1LL * ans * a % m;
  return ans;
}
vector<int> adj[3333];
int n;
int deg[3333];
int col[3333];
int rc;
int q[3333], qf, qb;
int deep[3333];
int dst[3333][3333];
void dfs(int u, int fa = 0) {
  deep[u] = deep[fa] + 1;
  for (int v : adj[u]) {
    if (v == fa) continue;
    if (col[v] >= 0) continue;
    col[v] = col[u];
    dfs(v, u);
  }
}
void ser(int u, int fa, int root) {
  for (int v : adj[u]) {
    if (v == fa or col[u] != col[v]) continue;
    dst[root][v] = dst[root][u] + 1;
    ser(v, u, root);
  }
}
double ans;
void calc(int u, int v) {
  if (col[u] == col[v]) {
    ans += 1.0 / (dst[u][v] + 1);
    return;
  }
  int X = deep[u] + deep[v];
  int Y = abs(col[u] - col[v]) - 1;
  int Z = rc - Y - 2;
  ans += 1.0 / (X + Y) + 1.0 / (X + Z) - 1.0 / (X + Y + Z);
}
void solve() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    int u, v;
    gn(u);
    gn(v);
    u++;
    v++;
    adj[u].push_back(v);
    adj[v].push_back(u);
    deg[u]++;
    deg[v]++;
  }
  for (int i = 1; i <= n; i++)
    if (deg[i] == 1) q[qb++] = i;
  while (qb > qf) {
    int u = q[qf++];
    col[u] = -1;
    for (int v : adj[u]) {
      deg[v]--;
      if (deg[v] == 1) q[qb++] = v;
    }
  }
  for (int i = 1; i <= n; i++)
    if (col[i] == 0) col[i] = ++rc, dfs(i);
  for (int i = 1; i <= n; i++) {
    ser(i, 0, i);
    for (int j = 1; j <= n; j++) {
      calc(i, j);
    }
  }
  printf("%.10lf\n", ans);
}
int main() {
  solve();
  return 0;
}
