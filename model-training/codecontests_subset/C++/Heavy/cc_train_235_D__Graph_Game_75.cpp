#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline bool upmin(T &x, T y) {
  return y < x ? x = y, 1 : 0;
}
template <typename T>
inline bool upmax(T &x, T y) {
  return x < y ? x = y, 1 : 0;
}
const long double eps = 1e-11;
const long double pi = acos(-1);
const int oo = 1 << 30;
const long long loo = 1ll << 62;
const int mods = 998244353;
const int MAXN = 600005;
const int INF = 0x3f3f3f3f;
inline int read() {
  int f = 1, x = 0;
  char c = getchar();
  while (c < '0' || c > '9') {
    if (c == '-') f = -1;
    c = getchar();
  }
  while (c >= '0' && c <= '9') {
    x = (x << 3) + (x << 1) + (c ^ 48);
    c = getchar();
  }
  return x * f;
}
double ans;
vector<int> e[MAXN];
int vis[MAXN], stk[MAXN], a[MAXN], id[MAXN], gf[MAXN], dis[MAXN], rt, top = 0,
                                                                      num = 0;
void dfs(int x, int father) {
  vis[x] = 1, stk[++top] = x;
  for (auto v : e[x]) {
    if (v == father) continue;
    if (vis[v]) {
      if (num) continue;
      int y;
      while (y = stk[top--]) {
        a[++num] = y, id[y] = num;
        if (y == v) break;
      }
    } else
      dfs(v, x);
  }
  if (stk[top] == x) top--;
}
void Dfs(int x, int father, int Gf) {
  gf[x] = Gf;
  dis[x] = dis[father] + 1;
  for (auto v : e[x])
    if (!id[v] && v != father) Dfs(v, x, Gf);
}
void getans(int x, int dep) {
  vis[x] = 1;
  if (x != rt) {
    if (gf[x] == gf[rt])
      ans += (double)1 / (double)dep;
    else {
      int a = dis[x] + dis[rt], b = abs(id[gf[x]] - id[gf[rt]]) - 1,
          c = num - 2 - b;
      ans += (double)1 / ((double)a + b) + (double)1 / ((double)a + c) -
             (double)1 / ((double)a + b + c);
    }
  }
  for (auto v : e[x])
    if (!vis[v]) getans(v, dep + 1);
}
int main() {
  int n = read();
  for (int i = 1; i <= n; i++) {
    int u = read() + 1, v = read() + 1;
    e[u].push_back(v), e[v].push_back(u);
  }
  dfs(1, 0);
  for (int i = 1; i <= num; i++) Dfs(a[i], 0, a[i]);
  ans = (double)n;
  for (int i = 1; i <= n; i++) {
    memset(vis, 0, sizeof vis);
    rt = i, getans(i, 1);
  }
  printf("%.10lf\n", ans);
  return 0;
}
