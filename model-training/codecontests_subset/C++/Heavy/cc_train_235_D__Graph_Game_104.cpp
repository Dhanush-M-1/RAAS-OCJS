#include <bits/stdc++.h>
using namespace std;
template <typename T>
void read(T &x) {
  x = 0;
  bool f = 0;
  char c = getchar();
  for (; !isdigit(c); c = getchar())
    if (c == '-') f = 1;
  for (; isdigit(c); c = getchar()) x = x * 10 + (c ^ 48);
  if (f) x = -x;
}
template <typename F>
inline void write(F x, char ed = '\n') {
  static short st[30];
  short tp = 0;
  if (x < 0) putchar('-'), x = -x;
  do st[++tp] = x % 10, x /= 10;
  while (x);
  while (tp) putchar('0' | st[tp--]);
  putchar(ed);
}
template <typename T>
inline void Mx(T &x, T y) {
  x < y && (x = y);
}
template <typename T>
inline void Mn(T &x, T y) {
  x > y && (x = y);
}
const int N = 3050;
vector<int> vec;
int To[N], h[N], to[N << 1], ne[N << 1], vis[N], tot, rt, m, n;
inline void add(int x, int y) { ne[++tot] = h[x], to[h[x] = tot] = y; }
void gethua(int x, int fa) {
  vis[x] = 1;
  for (int i = h[x]; i; i = ne[i]) {
    int y = to[i];
    if (y == fa) continue;
    if (rt != -1) return;
    To[x] = y;
    if (vis[y]) {
      rt = x, vec.push_back(x);
      for (int t = y; t != x; t = To[t]) vec.push_back(t);
      return;
    }
    gethua(y, x);
  }
}
double ans;
void dfs2(int x, int fa, int X, int Y, int Z) {
  ans = ans + 1.0 / (X + Y) + 1.0 / (X + Z) - 1.0 / (X + Y + Z);
  for (int i = h[x]; i; i = ne[i])
    if (vis[to[i]] == -1 && to[i] != fa) dfs2(to[i], x, X + 1, Y, Z);
}
int jue(int x) { return x > 0 ? x : -x; }
void dfs(int x, int fa, int X) {
  ans = ans + 1.0 / X;
  if (~vis[x]) {
    int sz = vec.size();
    for (int i = 0; i < sz; i++) {
      if (vec[i] == x) continue;
      dfs2(vec[i], x, X + 1, jue(i - vis[x]) - 1, sz - jue(i - vis[x]) - 1);
    }
    for (int i = h[x]; i; i = ne[i])
      if (vis[to[i]] == -1 && to[i] != fa) dfs(to[i], x, X + 1);
    return;
  }
  for (int i = h[x]; i; i = ne[i])
    if (to[i] != fa) dfs(to[i], x, X + 1);
}
int main() {
  read(n);
  rt = -1;
  for (int i = 1, x, y; i <= n; i++) read(x), read(y), add(x, y), add(y, x);
  gethua(0, -1);
  memset(vis, -1, sizeof(vis));
  for (int i = 0; i < (int)vec.size(); i++) vis[vec[i]] = i;
  for (int i = 0; i < n; i++) dfs(i, -1, 1);
  printf("%.10lf\n", ans);
  return 0;
}
