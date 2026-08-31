#include <bits/stdc++.h>
using namespace std;
const int N = 200100;
int t, n, m, a, b, par1[N], par2[N], low[N], dfn[N], timer, cnt1, cnt2;
bool cut[N], vis[N], vis1[N], vis2[N], vis3[N], vis4[N];
vector<int> adj[N];
set<int> s;
int get1(int x) { return par1[x] == x ? x : par1[x] = get1(par1[x]); }
void mrg1(int x, int y) {
  x = get1(x);
  y = get1(y);
  if (x == y) return;
  if (rand() & 1) swap(x, y);
  par1[x] = y;
}
int get2(int x) { return par2[x] == x ? x : par2[x] = get2(par2[x]); }
void mrg2(int x, int y) {
  x = get2(x);
  y = get2(y);
  if (x == y) return;
  if (rand() & 1) swap(x, y);
  par2[x] = y;
}
void dfs(int u, int v) {
  low[u] = dfn[u] = ++timer;
  for (int x : adj[u]) {
    if (x == v) continue;
    if (!dfn[x]) {
      dfs(x, u);
      if (dfn[u] <= low[x]) cut[u] = 1;
      low[u] = min(low[u], low[x]);
    } else
      low[u] = min(low[u], dfn[x]);
  }
}
void _clear() {
  timer = cnt1 = cnt2 = 0;
  for (int i = 1; i <= n; i++) {
    par1[i] = par2[i] = i;
    low[i] = dfn[i] = cut[i] = vis[i] = vis1[i] = vis2[i] = vis3[i] = vis4[i] =
        0;
    adj[i].clear();
  }
}
void dfs1(int u, int p) {
  vis1[u] = 1;
  mrg1(u, p);
  for (auto x : adj[u])
    if (!vis1[x] && x != a) dfs1(x, p);
}
void dfs2(int u, int p) {
  vis2[u] = 1;
  mrg2(u, p);
  for (auto x : adj[u])
    if (!vis2[x] && x != b) dfs2(x, p);
}
void dfscnt1(int u) {
  vis3[u] = 1;
  cnt1++;
  for (auto x : adj[u])
    if (!vis3[x] && x != a) dfscnt1(x);
}
void dfscnt2(int u) {
  vis4[u] = 1;
  cnt2++;
  for (auto x : adj[u])
    if (!vis4[x] && x != b) dfscnt2(x);
}
int main() {
  scanf("%d", &t);
  while (t--) {
    scanf("%d%d%d%d", &n, &m, &a, &b);
    _clear();
    for (int i = 0; i < m; i++) {
      int x, y;
      scanf("%d%d", &x, &y);
      adj[x].push_back(y);
      adj[y].push_back(x);
    }
    dfs(1, 0);
    for (auto x : adj[1]) s.insert(low[x]);
    if ((int)(s.size()) != 1) cut[1] = 1;
    if (!cut[a] || !cut[b]) {
      printf("0\n");
      continue;
    }
    for (auto x : adj[a])
      if (!vis1[x]) dfs1(x, x);
    for (auto x : adj[b])
      if (!vis2[x]) dfs2(x, x);
    for (auto x : adj[a]) {
      int x1 = get1(x);
      int x2 = get1(b);
      if (x1 != x2 && !vis3[x]) dfscnt1(x);
    }
    for (auto x : adj[b]) {
      int x1 = get2(x);
      int x2 = get2(a);
      if (x1 != x2 && !vis4[x]) dfscnt2(x);
    }
    printf("%lld\n", 1LL * cnt1 * cnt2);
  }
}
