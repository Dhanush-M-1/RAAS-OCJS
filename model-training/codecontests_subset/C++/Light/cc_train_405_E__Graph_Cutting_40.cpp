#include <bits/stdc++.h>
using namespace std;
const int MAX_N = 100000 + 20;
vector<int> adj[MAX_N];
int mark[MAX_N];
int lvl[MAX_N];
vector<pair<int, pair<int, int> > > ans;
int n, m;
void readInput() {
  cin >> n >> m;
  for (int i = 0; i < m; i++) {
    int v, u;
    cin >> v >> u;
    --v, u--;
    adj[v].push_back(u);
    adj[u].push_back(v);
  }
  for (int i = 0; i < n; ++i) lvl[i] = MAX_N;
}
int dfs(int v) {
  if (mark[v]) return -1;
  mark[v] = 1;
  vector<int> seq;
  for (int i = 0; i < adj[v].size(); ++i) {
    int u = adj[v][i];
    if (lvl[u] < lvl[v]) continue;
    lvl[u] = (lvl[u] == MAX_N ? lvl[v] + 1 : lvl[u]);
    int ver = dfs(u);
    if (ver != -1)
      ans.push_back(make_pair(v, make_pair(u, ver)));
    else
      seq.push_back(u);
  }
  while (seq.size() > 1) {
    int u = seq.back();
    seq.pop_back();
    int ver = seq.back();
    seq.pop_back();
    ans.push_back(make_pair(u, make_pair(v, ver)));
  }
  return (seq.size() == 1 ? seq.back() : -1);
}
int main() {
  readInput();
  if (m % 2) {
    cout << "No solution" << endl;
    return 0;
  }
  lvl[0] = 0;
  dfs(0);
  for (int i = 0; i < ans.size(); ++i)
    cout << ans[i].first + 1 << ' ' << ans[i].second.first + 1 << ' '
         << ans[i].second.second + 1 << endl;
  return 0;
}
