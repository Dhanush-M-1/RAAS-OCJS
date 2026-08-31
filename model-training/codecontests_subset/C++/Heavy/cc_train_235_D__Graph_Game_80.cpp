#include <bits/stdc++.h>
using namespace std;
const int N = 3005, M = N << 1;
int n, tot, len, du[N], now[N], prep[M], son[M];
double ans;
void read(int &x) {
  x = 0;
  int f = 1;
  char ch;
  for (ch = getchar(); !isdigit(ch); ch = getchar())
    if (ch == '-') f = -1;
  for (; isdigit(ch); ch = getchar()) x = x * 10 + ch - '0';
  x *= f;
}
void link(int u, int v) {
  tot++, prep[tot] = now[u], now[u] = tot, son[tot] = v;
}
void init() {
  read(n);
  tot = 0, memset(now, 0, sizeof(now));
  for (int u, v, i = 1; i <= n; i++) {
    read(u), u++, read(v), v++;
    link(u, v), link(v, u), du[u]++, du[v]++;
  }
}
void topsort() {
  int q[N], top;
  top = 0;
  for (int i = 1; i <= n; i++)
    if (du[i] == 1) q[++top] = i;
  for (int i = 1; i <= top; i++) {
    int x = q[i];
    for (int j = now[x]; j; j = prep[j]) {
      int y = son[j];
      if ((--du[y]) == 1) q[++top] = y;
    }
  }
  len = n - top;
}
int d1[N], d2[N];
bool vis[N];
void dfs(int x, int y) {
  if (!d1[x])
    d1[x] = y;
  else
    d2[x] = y;
  vis[x] = 1;
  for (int i = now[x]; i; i = prep[i]) {
    int to = son[i];
    if (!vis[to]) dfs(to, y + 1);
  }
  vis[x] = 0;
}
void solve() {
  ans = 0;
  for (int i = 1; i <= n; i++) {
    memset(d1, 0, sizeof(d1));
    memset(d2, 0, sizeof(d2));
    dfs(i, 1);
    for (int j = 1; j <= n; j++) {
      if (!d2[j])
        ans += 1.0 / d1[j];
      else
        ans += 1.0 / d1[j] + 1.0 / d2[j] - 2.0 / (d1[j] + d2[j] - 2 + len);
    }
  }
  printf("%.7lf\n", ans);
}
void judge() {
  freopen("dierti.in", "r", stdin);
  freopen("dierti.out", "w", stdout);
}
int main() {
  init();
  topsort();
  solve();
  return 0;
}
