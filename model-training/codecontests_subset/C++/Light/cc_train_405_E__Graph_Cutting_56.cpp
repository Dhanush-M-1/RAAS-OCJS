#include <bits/stdc++.h>
using namespace std;
const long long Maxn = 1e5 + 7;
const long long Inf = 1e9 + 7;
vector<long long> V[Maxn];
vector<pair<long long, pair<long long, long long> > > ans;
map<pair<long long, long long>, bool> mark;
bool vis[Maxn];
void True(long long u, long long v) {
  mark[make_pair(u, v)] = mark[make_pair(v, u)] = true;
}
long long dfs(long long u, long long dad) {
  if (vis[u]) return mark[make_pair(u, dad)];
  vis[u] = true;
  long long son = -1;
  for (long long i = 0; i < V[u].size(); i++) {
    long long v = V[u][i];
    if (v == dad || mark[make_pair(u, v)]) continue;
    bool t = dfs(v, u);
    if (t)
      continue;
    else if (son != -1 && !mark[make_pair(son, u)]) {
      ans.push_back(make_pair(son, make_pair(u, v)));
      True(u, v);
      True(u, son);
      son = -1;
    } else
      son = v;
  }
  if (son == -1) return 0;
  ans.push_back(make_pair(son, make_pair(u, dad)));
  True(u, son);
  True(u, dad);
  return 1;
}
int main() {
  long long n, m;
  cin >> n >> m;
  for (long long i = 1; i <= m; i++) {
    long long u, v;
    cin >> u >> v;
    V[u].push_back(v), V[v].push_back(u);
  }
  if (m % 2) {
    cout << "No solution" << endl;
    return 0;
  }
  dfs(1, -1);
  for (long long i = 0; i < ans.size(); i++)
    cout << ans[i].first << " " << ans[i].second.first << " "
         << ans[i].second.second << endl;
}
