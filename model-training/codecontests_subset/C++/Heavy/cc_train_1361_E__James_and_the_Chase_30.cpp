#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7, inf = 1061109567;
const long long infll = 4557430888798830399;
const int N = 1e5 + 5, MAX = 8888;
int n, m;
vector<int> g[N];
int d[N], cnt[N];
void add(int &x, int y) {
  x += y;
  if (x >= MAX) x = MAX;
}
bool vis[N], realVis[N];
bool good;
void dfs2(int u) {
  if (!good) return;
  realVis[u] = vis[u] = 1;
  for (auto v : g[u]) {
    if (!realVis[v])
      dfs2(v);
    else {
      if (!vis[v]) {
        good = 0;
        return;
      }
    }
  }
  vis[u] = 0;
}
bool dp[N];
int root, dep[N], backCnt[N], backLead[N], atDep[N];
vector<int> child[N];
priority_queue<int> pq[N];
void dfs0(int u) {
  atDep[dep[u]] = u;
  for (auto v : g[u]) {
    if (dep[v] == -1) {
      dep[v] = dep[u] + 1;
      dfs0(v);
      child[u].push_back(v);
      if (pq[v].size() > pq[u].size()) pq[u].swap(pq[v]);
      while (pq[v].size()) {
        pq[u].push(pq[v].top());
        pq[v].pop();
      }
    } else {
      if (dep[v] < dep[u]) {
        pq[u].push(dep[v]);
      }
    }
  }
  while (pq[u].size() && pq[u].top() == dep[u]) pq[u].pop();
  backCnt[u] = pq[u].size();
  if (pq[u].size())
    backLead[u] = atDep[pq[u].top()];
  else
    backLead[u] = -1;
}
void dfs1(int u) {
  if (u == root)
    dp[u] = 1;
  else {
    if (backCnt[u] != 1)
      dp[u] = 0;
    else
      dp[u] = dp[backLead[u]];
  }
  for (auto v : child[u]) dfs1(v);
}
void proc() {
  cin >> n >> m;
  for (int i = 0; i < n; i++) g[i].clear();
  for (int i = 0; i < m; i++) {
    int u, v;
    cin >> u >> v;
    u--, v--;
    g[u].push_back(v);
  }
  int cnt = min(n, 100);
  root = -1;
  vector<int> vers;
  for (int i = 0; i < n; i++) vers.push_back(i);
  for (int i = 0; i < n; i++) {
    int other = rand() % vers.size();
    swap(vers[i], vers[other]);
  }
  for (int i = 0; i < cnt; i++) {
    for (int j = 0; j < n; j++) realVis[j] = vis[j] = 0;
    good = 1;
    dfs2(vers[i]);
    if (good) {
      root = vers[i];
      break;
    }
  }
  if (root == -1) {
    cout << "-1\n";
    return;
  }
  for (int i = 0; i < n; i++) {
    dep[i] = -1;
    dp[i] = 0;
    backCnt[i] = 0;
    backLead[i] = -1;
    child[i].clear();
    while (pq[i].size()) pq[i].pop();
  }
  dep[root] = 0;
  dfs0(root);
  dfs1(root);
  int ans = 0;
  for (int i = 0; i < n; i++)
    if (dp[i]) ans++;
  if (ans * 5 >= n) {
    for (int i = 0; i < n; i++)
      if (dp[i]) cout << i + 1 << " ";
    cout << "\n";
  } else
    cout << "-1\n";
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  srand(time(0));
  int t;
  cin >> t;
  while (t--) proc();
  return 0;
}
