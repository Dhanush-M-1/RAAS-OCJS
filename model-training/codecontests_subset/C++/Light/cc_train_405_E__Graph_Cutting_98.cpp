#include <bits/stdc++.h>
using namespace std;
int const mxn = 2e5 + 10;
int r;
vector<pair<int, pair<int, int> > > ans, ans2;
vector<int> adj[mxn];
vector<int> back[mxn];
int mark[mxn];
void dfs(int v, int p) {
  mark[v] = 1;
  for (auto u : adj[v]) {
    if (!mark[u]) {
      dfs(u, v);
    } else if (u != p) {
      back[u].push_back(v);
    }
  }
  for (int i = 0; i < back[v].size() - back[v].size() % 2; i += 2) {
    ans.push_back({back[v][i], {v, back[v][i + 1]}});
  }
  if (back[v].size() % 2 == 1 and back[v][back[v].size() - 1] != r)
    ans.push_back({back[v][back[v].size() - 1], {v, p}});
  else
    back[p].push_back(v);
  return;
}
int main() {
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= m; i++) {
    int a, b;
    cin >> a >> b;
    adj[a].push_back(b);
    adj[b].push_back(a);
  }
  for (int i = 1; i <= n; i++) {
    if (!mark[i]) {
      r = i;
      dfs(i, 0);
    }
  }
  if (m % 2 == 0) {
    for (auto i : ans) {
      if (i.first != 0 and i.second.first != 0 and i.second.second != 0)
        ans2.push_back(i);
    }
    for (auto i : ans2) {
      cout << i.first << " " << i.second.first << " " << i.second.second
           << endl;
    }
  } else
    cout << "No solution";
}
