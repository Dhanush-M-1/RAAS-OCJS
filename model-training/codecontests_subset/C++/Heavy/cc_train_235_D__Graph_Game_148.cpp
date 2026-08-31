#include <bits/stdc++.h>
long long gi() {
  long long x = 0, f = 1;
  char ch = getchar();
  while (!isdigit(ch)) f ^= ch == '-', ch = getchar();
  while (isdigit(ch)) x = x * 10 + ch - '0', ch = getchar();
  return f ? x : -x;
}
std::mt19937 rnd(time(NULL));
template <class T>
void cxk(T& a, T b) {
  a = a > b ? a : b;
}
template <class T>
void cnk(T& a, T b) {
  a = a < b ? a : b;
}
int fir[3010], dis[6010], nxt[6010], id;
void link(int a, int b) { nxt[++id] = fir[a], fir[a] = id, dis[id] = b; }
int cir[3010], stk[3010], tp, ins[3010], vis[3010], m, pos[3010], dep[3010];
void getcycle(int x, int fa = -1) {
  vis[x] = 1;
  stk[++tp] = x;
  ins[x] = tp;
  for (int i = fir[x]; i; i = nxt[i]) {
    if (dis[i] == fa) continue;
    if (!vis[dis[i]])
      getcycle(dis[i], x);
    else if (ins[dis[i]] && !m)
      for (int j = ins[dis[i]]; j <= tp; ++j) cir[++m] = stk[j];
  }
  ins[x] = 0;
  --tp;
}
int dist[3010][3010];
void DFS(int x) {
  for (int i = fir[x]; i; i = nxt[i]) {
    if (pos[dis[i]]) continue;
    dep[dis[i]] = dep[x] + 1;
    pos[dis[i]] = pos[x];
    DFS(dis[i]);
  }
}
void getdist(int x, int* di, int fa = -1) {
  for (int i = fir[x]; i; i = nxt[i])
    if (!di[dis[i]]) {
      di[dis[i]] = di[x] + 1;
      getdist(dis[i], di, x);
    }
}
int main() {
  int n = gi(), a, b;
  for (int i = 1; i <= n; ++i)
    a = gi() + 1, b = gi() + 1, link(a, b), link(b, a);
  getcycle(1);
  for (int i = 1; i <= m; ++i) pos[cir[i]] = i;
  for (int i = 1; i <= m; ++i) DFS(cir[i]);
  double ans = 0;
  for (int i = 1; i <= n; ++i) dist[i][i] = 1, getdist(i, dist[i]);
  for (int i = 1; i <= n; ++i)
    for (int j = i + 1; j <= n; ++j)
      if (pos[i] == pos[j])
        ans += 1. / dist[i][j];
      else {
        int a = abs(pos[i] - pos[j]), b = m - a;
        ans += 1. / (dep[i] + dep[j] + a + 1);
        ans += 1. / (dep[i] + dep[j] + b + 1);
        ans -= 1. / (dep[i] + dep[j] + m);
      }
  printf("%.10lf\n", 2 * ans + n);
  return 0;
}
