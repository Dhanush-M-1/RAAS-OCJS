#include <bits/stdc++.h>
using namespace std;
using ll = long long;
constexpr int kMaxN = 2e5 + 3;
vector<int> edges[kMaxN];
bitset<kMaxN> visited;
int nim[kMaxN];
int mext[kMaxN];
int levels[kMaxN];
vector<int> nim_nodes[kMaxN];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n, m;
  cin >> n >> m;
  vector<int> h(n);
  for (int i = 0; i < n; ++i) {
    cin >> h[i];
  }
  for (int i = 0; i < m; ++i) {
    int u, v;
    cin >> u >> v;
    --u, --v;
    edges[u].emplace_back(v);
  }
  memset(mext, -1, sizeof(mext));
  function<void(int)> dfs = [&](int u) {
    if (visited[u]) {
      return;
    }
    visited[u] = true;
    for (int v : edges[u]) {
      dfs(v);
    }
    for (int v : edges[u]) {
      mext[nim[v]] = u;
    }
    int k = 0;
    while (mext[k] == u) {
      ++k;
    }
    nim[u] = k;
    levels[k] ^= h[u];
    nim_nodes[k].emplace_back(u);
  };
  for (int i = 0; i < n; ++i) {
    dfs(i);
  }
  if (count(levels, levels + kMaxN, 0) == kMaxN) {
    cout << "LOSE\n";
    return 0;
  }
  cout << "WIN\n";
  int last_level = n;
  while (levels[last_level] == 0) {
    --last_level;
  }
  assert(last_level >= 0);
  int node = -1;
  for (int u : nim_nodes[last_level]) {
    if ((h[u] ^ levels[nim[u]]) <= h[u]) {
      h[u] ^= levels[nim[u]];
      node = u;
      levels[nim[u]] = 0;
      break;
    }
  }
  assert(node != -1);
  for (int v : edges[node]) {
    h[v] ^= levels[nim[v]];
    levels[nim[v]] = 0;
  }
  assert(count(levels, levels + kMaxN, 0) == kMaxN);
  for (int i = 0; i < n; ++i) {
    cout << h[i] << ' ';
  }
  cout << '\n';
  return 0;
}
