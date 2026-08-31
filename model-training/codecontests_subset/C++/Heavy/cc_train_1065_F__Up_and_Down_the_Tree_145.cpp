#include <bits/stdc++.h>
using namespace std;
int tot, fa[1000005][20], in[1000005], ans, dp[1000005], st[1000005], hd, cl, x,
    n, k, i, j, deg[1000005], dfn[1000005], low[1000005], sum[1000005],
    col[1000005], vis[1000005];
vector<int> son[1000005], to[1000005];
queue<int> q;
void add(int x, int y) { son[x].push_back(y); }
inline int find(int x, int y) {
  for (int i = 19; ~i; --i)
    if ((y >> i) & 1) x = fa[x][i];
  return x;
}
void tarjan(int now) {
  dfn[now] = low[now] = ++tot;
  st[++hd] = now;
  vis[now] = 1;
  for (int T, i = 0; i < son[now].size(); ++i) {
    if (!dfn[T = son[now][i]])
      tarjan(T), low[now] = min(low[now], low[T]);
    else if (vis[T])
      low[now] = min(low[now], low[T]);
  }
  if (low[now] == dfn[now]) {
    ++cl;
    while (now != st[hd + 1]) {
      sum[cl] += in[st[hd]];
      vis[st[hd]] = 0;
      col[st[hd]] = cl;
      --hd;
    }
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin >> n >> k;
  for (i = 2; i <= n; ++i) cin >> fa[i][0], ++in[fa[i][0]], add(fa[i][0], i);
  fa[1][0] = 1;
  for (i = 1; i <= 19; ++i)
    for (j = 1; j <= n; ++j) fa[j][i] = fa[fa[j][i - 1]][i - 1];
  for (i = 1; i <= n; in[i] = (in[i] == 0), ++i)
    if (!in[i]) add(i, find(i, k));
  for (tarjan(i = 1); i <= n; ++i) {
    for (j = 0; j < son[i].size(); ++j) {
      if (col[son[i][j]] != col[i]) {
        to[col[i]].push_back(col[son[i][j]]);
        ++deg[col[son[i][j]]];
      }
    }
  }
  for (i = 1; i <= cl; ++i)
    if (!deg[i]) q.push(i);
  while (q.size()) {
    x = q.front();
    q.pop();
    dp[x] += sum[x];
    ans = max(ans, dp[x]);
    for (i = 0; i < to[x].size(); ++i) {
      if (!--deg[to[x][i]]) q.push(to[x][i]);
      dp[to[x][i]] = max(dp[to[x][i]], dp[x]);
    }
  }
  cout << ans;
  return 0;
}
