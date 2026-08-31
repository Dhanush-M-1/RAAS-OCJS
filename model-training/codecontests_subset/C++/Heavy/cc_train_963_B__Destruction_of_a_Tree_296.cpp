#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const int mod = 1e9 + 7;
const double eps = 1e-6;
const int N = 1 << 18;
vector<int> G[N];
int deg[N], d[N];
bool vis[N];
void dfs(int u, int fa, int dep) {
  d[u] = dep;
  for (auto& v : G[u])
    if (v != fa) dfs(v, u, dep + 1);
}
int main() {
  int n;
  cin >> n;
  int rt = 0;
  for (int i = 1; i <= n; i++) {
    static int p;
    cin >> p;
    if (p)
      G[p].push_back(i), G[i].push_back(p), ++deg[i], ++deg[p];
    else
      rt = i;
  }
  dfs(rt, 0, 0);
  priority_queue<pair<int, int> > q;
  for (int i = 1; i <= n; i++)
    if (deg[i] % 2 == 0) q.push({d[i], i});
  vector<int> ans;
  while (!q.empty()) {
    pair<int, int> tmp = q.top();
    q.pop();
    int u = tmp.second;
    if (deg[u] & 1 || vis[u]) continue;
    vis[u] = 1;
    ans.push_back(u);
    for (auto& v : G[u])
      if (--deg[v] % 2 == 0) q.push({d[v], v});
  }
  if (ans.size() != n) return cout << "NO", 0;
  cout << "YES" << endl;
  for (auto& t : ans) cout << t << endl;
  return 0;
}
