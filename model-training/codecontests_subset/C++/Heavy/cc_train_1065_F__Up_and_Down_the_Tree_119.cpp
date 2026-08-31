#include <bits/stdc++.h>
using namespace std;
const long long inf = 9.2e18;
const int maxn = 1e6 + 70;
const int INF = 2.1e9;
const int maxm = 1e6 + 70;
const int MOD = 1e9 + 7;
const double eps = 1e-7;
const double PI = acos(-1.0);
int n, m, k;
int fa[maxn], anc[maxn][26], dep[maxn], mind[maxn], top[maxn], cnt[maxn];
vector<int> G[maxn];
void dfs(int u) {
  if (!G[u].size())
    mind[u] = dep[u];
  else {
    mind[u] = INF;
    for (int i = 0; i < G[u].size(); i++) {
      int v = G[u][i];
      dep[v] = dep[u] + 1;
      dfs(v);
      mind[u] = min(mind[u], mind[v]);
    }
  }
}
void dfs2(int u) {
  if (!G[u].size()) {
    int fk;
    if (dep[u] <= k)
      fk = 1;
    else {
      fk = u;
      int c = 0, t = k;
      while (t) {
        if (t & 1) fk = anc[fk][c];
        t >>= 1;
        c++;
      }
    }
    top[u] = top[fk];
    cnt[top[u]]++;
  } else {
    if (mind[u] - k >= dep[u])
      top[u] = u;
    else {
      int fk, t = k - mind[u] + dep[u];
      if (dep[u] <= t)
        fk = 1;
      else {
        fk = u;
        int c = 0;
        while (t) {
          if (t & 1) fk = anc[fk][c];
          t >>= 1;
          c++;
        }
      }
      top[u] = top[fk];
    }
    for (int i = 0; i < G[u].size(); i++) {
      int v = G[u][i];
      dfs2(v);
    }
  }
}
int solve(int u) {
  int ans = 0;
  for (int i = 0; i < G[u].size(); i++) {
    int v = G[u][i];
    ans = max(ans, solve(v));
  }
  ans += cnt[u];
  return ans;
}
void bfs() {
  queue<int> Q;
  Q.push(1);
  int now = 0;
  while (!Q.empty()) {
    int u = Q.front();
    Q.pop();
    if (dep[u] > now) {
      cout << endl;
      now = dep[u];
    }
    cout << u << " ";
    for (int i = 0; i < G[u].size(); i++) {
      int v = G[u][i];
      Q.push(v);
    }
  }
  cout << endl;
}
int main() {
  while (cin >> n >> k) {
    for (int i = 0; i <= n; i++) G[i].clear();
    fa[1] = -1;
    for (int i = 2; i <= n; i++) {
      scanf("%d", &fa[i]);
      G[fa[i]].push_back(i);
    }
    dep[1] = 0;
    dfs(1);
    for (int i = 1; i <= n; i++) {
      anc[i][0] = fa[i];
      for (int j = 1; (1 << j) < n; j++) anc[i][j] = -1;
    }
    for (int j = 1; (1 << j) < n; j++) {
      for (int i = 1; i <= n; i++) {
        if (anc[i][j - 1] != -1) {
          anc[i][j] = anc[anc[i][j - 1]][j - 1];
        }
      }
    }
    memset(cnt, 0, (n + 1) * sizeof(int));
    top[1] = 1;
    dfs2(1);
    int ans = solve(1);
    printf("%d\n", ans);
  }
  return 0;
}
