#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 5;
int N, M;
vector<int> adj[maxn];
int cnt = 0, num[maxn];
vector<pair<int, pair<int, int>>> res;
bool dfs(int u, int p = 0) {
  num[u] = ++cnt;
  int cur = 0;
  for (int v : adj[u]) {
    if (v == p) continue;
    if ((num[v] != 0 && num[v] < num[u]) || (num[v] == 0 && dfs(v, u))) {
      if (cur == 0)
        cur = v;
      else
        res.push_back(make_pair(cur, make_pair(u, v))), cur = 0;
    }
  }
  if (cur == 0)
    return true;
  else {
    if (p != 0) res.push_back(make_pair(p, make_pair(u, cur)));
    return false;
  }
}
signed main(void) {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> N >> M;
  for (int i = 1; i <= M; ++i) {
    int u, v;
    cin >> u >> v;
    adj[u].push_back(v);
    adj[v].push_back(u);
  }
  if (M & 1) {
    cout << "No solution";
    return 0;
  }
  for (int i = 1; i <= N; ++i) {
    if (num[i] == 0) dfs(i);
  }
  for (auto& x : res)
    cout << x.first << ' ' << x.second.first << ' ' << x.second.second << '\n';
}
