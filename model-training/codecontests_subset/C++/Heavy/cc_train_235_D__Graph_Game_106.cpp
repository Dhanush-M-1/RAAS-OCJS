#include <bits/stdc++.h>
using namespace std;
int hed[3005], to[3005 << 1], nxt[3005 << 1], q[3005], cnt, tot;
bool in[3005], used[3005];
int n, deg[3005], C;
double ans;
void ins(int x, int y) {
  nxt[++tot] = hed[x];
  to[tot] = y;
  hed[x] = tot;
}
void dfs(int x, int len, int lcn) {
  used[x] = 1;
  if (lcn <= 1)
    ans += 1.0 / len;
  else
    ans += 1.0 / len + 1.0 / (len - 2 * lcn + C + 2) - 1.0 / (len + C - lcn);
  for (int i = hed[x]; i; i = nxt[i])
    if (!used[to[i]]) dfs(to[i], len + 1, lcn + in[to[i]]);
}
int main() {
  scanf("%d", &n);
  for (int u, v, i = 1; i <= n; ++i) {
    scanf("%d%d", &u, &v);
    ins(u, v);
    ins(v, u);
    ++deg[u];
    ++deg[v];
  }
  for (int i = 0; i < n; ++i)
    if (deg[i] == 1) q[++cnt] = i;
  for (int x = 1; x <= cnt; ++x)
    for (int i = hed[q[x]]; i; i = nxt[i])
      if ((--deg[to[i]]) == 1) q[++cnt] = to[i];
  for (int i = 0; i < n; ++i)
    if (deg[i] > 1) in[i] = 1;
  C = n - cnt;
  for (int i = 0; i < n; ++i) {
    memset(used, 0, sizeof(used));
    dfs(i, 1, in[i]);
  }
  printf("%.8lf\n", ans);
  return 0;
}
