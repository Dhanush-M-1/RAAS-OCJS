#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 99;
int n, x, rt, mark[N], deg[N], dist[N], par[N];
set<pair<int, int> > s;
vector<int> ans, g[N];
void update(int x) {
  deg[x]--;
  if (deg[x] % 2)
    s.erase(make_pair(dist[x], x));
  else
    s.insert(make_pair(dist[x], x));
}
void dfs(int x, int dis) {
  dist[x] = dis;
  deg[x] = (g[x].size() + (x != rt));
  if (deg[x] % 2 == 0)
    s.insert(make_pair(dis, x)), deg[x] = (g[x].size() + (x != rt));
  for (long long i = 0; i < g[x].size(); i++) dfs(g[x][i], dis + 1);
}
void dfs_del(int x) {
  ans.push_back(x);
  mark[x] = 1;
  for (long long i = 0; i < g[x].size(); i++)
    if (!mark[g[x][i]]) dfs_del(g[x][i]);
}
int main() {
  cin >> n;
  if (!(n % 2)) return cout << "NO", 0;
  cout << "YES" << endl;
  for (long long i = 1; i < n + 1; i++) {
    scanf("%d", &x);
    ;
    if (x == 0)
      rt = i;
    else
      g[x].push_back(i), par[i] = x;
  }
  dfs(rt, 0);
  while (s.size()) {
    int u = (*s.rbegin()).second;
    s.erase(make_pair(dist[u], u));
    dfs_del(u);
    if (u != rt) update(par[u]);
  }
  for (long long i = 0; i < ans.size(); i++) cout << ans[i] << " ";
  cout << endl;
  ;
}
