#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 10;
const int mod = 1e9 + 7;
int n, m, kase, u, v;
struct Edge {
  int to, from, nex;
} edge[maxn << 1];
int head[maxn], ecnt;
void add_edge(int u, int v) {
  edge[++ecnt] = {v, u, head[u]};
  head[u] = ecnt;
}
mt19937 mt(time(0));
set<int> se;
int rk[maxn], tot, p[maxn], rt;
bool vis[maxn];
bool dfs(int u) {
  vis[u] = true;
  rk[++tot] = u;
  for (int i = head[u]; i; i = edge[i].nex) {
    int v = edge[i].to;
    if (!p[v]) {
      p[v] = u;
      if (!dfs(v)) return false;
    } else if (!vis[v])
      return false;
  }
  return vis[u] = false, true;
}
bool check(int u) {
  memset(p, 0, n + 2 << 2);
  p[u] = -1;
  tot = 0;
  if (!dfs(u)) return false;
  int i = 1;
  for (; i <= n && p[i]; ++i)
    ;
  return i > n;
}
int cov[maxn], Cov[maxn], ok[maxn];
int main() {
  scanf("%d", &kase);
  while (kase--) {
    scanf("%d %d", &n, &m);
    memset(head, 0, n + 2 << 2);
    ecnt = 0;
    for (int i = 1; i <= m; i++) {
      scanf("%d %d", &u, &v);
      add_edge(u, v);
    }
    int T = min(60, n);
    se.clear();
    for (int i = 1; i <= T; i++) {
      int rd = mt() % n + 1;
      if (se.find(rd) != se.end()) i--;
      se.insert(rd);
    }
    rt = 0;
    for (auto it : se)
      if (check(it)) {
        rt = it;
        break;
      }
    memset(cov, 0, n + 2 << 2);
    memset(Cov, 0, n + 2 << 2);
    memset(ok, 0, n + 2 << 2);
    if (!rt) {
      puts("-1");
      continue;
    }
    for (int i = 1; i <= m; i++)
      if (u = edge[i].from, v = edge[i].to, p[v] != u)
        ++cov[u], --cov[v], Cov[u] ^= i, Cov[v] ^= i;
    for (int i = n; i; i--) v = rk[i], cov[p[v]] += cov[v], Cov[p[v]] ^= Cov[v];
    for (int i = 1; i <= n; i++)
      v = rk[i], ok[v] = i == 1 || (cov[v] == 1 && ok[edge[Cov[v]].to]);
    vector<int> ans;
    for (int i = 1; i <= n; i++)
      if (ok[i]) ans.push_back(i);
    if (ans.size() * 5 < n)
      printf("-1");
    else
      for (auto it : ans) printf("%d ", it);
    puts("");
  }
  return 0;
}
