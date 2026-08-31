#include <bits/stdc++.h>
using namespace std;
void dfs(int u, int p, const vector<vector<int> >& g, vector<int>& depth) {
  depth[u] = depth[p] + 1;
  for (int v : g[u]) {
    if (v == p) {
      continue;
    }
    dfs(v, u, g, depth);
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n;
  cin >> n;
  if (n % 2 == 0) {
    cout << "NO";
    return 0;
  }
  vector<vector<int> > g(n);
  vector<int> deg(n, 0);
  int root = -1;
  for (int i = 0; i < n; ++i) {
    int p;
    cin >> p;
    --p;
    if (p == -1) {
      root = i;
    } else {
      g[p].push_back(i);
      g[i].push_back(p);
      ++deg[i];
      ++deg[p];
    }
  }
  vector<int> depth(n);
  depth[root] = 0;
  dfs(root, root, g, depth);
  priority_queue<pair<int, int> > pq;
  for (int i = 0; i < n; ++i) {
    if (deg[i] % 2 == 0) {
      pq.push(make_pair(depth[i], i));
    }
  }
  vector<int> res;
  vector<bool> deleted(n, false);
  while (!pq.empty()) {
    int u = pq.top().second;
    pq.pop();
    if (deleted[u] || deg[u] & 1) {
      continue;
    }
    deg[u] = 0;
    deleted[u] = true;
    res.push_back(u);
    for (int v : g[u]) {
      if (!deleted[v]) {
        --deg[v];
        if (deg[v] % 2 == 0) {
          pq.push(make_pair(depth[v], v));
        }
      }
    }
  }
  cout << "YES\n";
  for (int u : res) {
    cout << u + 1 << '\n';
  }
}
