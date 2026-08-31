#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 7;
vector<int> g[N];
int sz[N];
bool vis[N];
int lvl[N];
void dfs(int node, int par) {
  for (int nxt : g[node]) {
    if (nxt == par) continue;
    lvl[nxt] = lvl[node] + 1;
    dfs(nxt, node);
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  int root;
  for (int i = 1; i <= n; i++) {
    int x;
    cin >> x;
    if (!x) {
      root = i;
      continue;
    }
    g[x].push_back(i);
    g[i].push_back(x);
  }
  memset(sz, 0, sizeof(sz));
  memset(vis, 0, sizeof(vis));
  memset(lvl, 0, sizeof(lvl));
  dfs(root, 0);
  set<pair<int, int> > ss;
  for (int i = 1; i <= n; i++) {
    sz[i] = g[i].size();
    if (sz[i] % 2 == 0) {
      ss.insert(make_pair(lvl[i], i));
    }
  }
  vector<int> vec;
  while (ss.size()) {
    pair<int, int> p = *ss.rbegin();
    int node = p.second;
    vec.push_back(node);
    vis[node] = true;
    ss.erase(prev(ss.end()));
    for (int nxt : g[node]) {
      if (vis[nxt]) continue;
      sz[nxt]--;
      if (sz[nxt] & 1) {
        ss.erase(make_pair(lvl[nxt], nxt));
      } else
        ss.insert(make_pair(lvl[nxt], nxt));
    }
  }
  if (vec.size() != n) {
    cout << "NO\n";
    return 0;
  }
  cout << "YES\n";
  for (int x : vec) {
    cout << x << endl;
  }
  return 0;
}
