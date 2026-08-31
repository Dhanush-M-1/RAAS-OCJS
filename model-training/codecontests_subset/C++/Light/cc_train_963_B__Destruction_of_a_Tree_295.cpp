#include <bits/stdc++.h>
using namespace std;
using GRAPH = std::vector<std::vector<int>>;
GRAPH G;
vector<int> P;
vector<int> D;
vector<int> V;
void dfs(int u) {
  for (auto v : G[u]) {
    dfs(v);
  }
  V.push_back(u);
}
int main() {
  int n{};
  cin >> n;
  G.resize(n + 1);
  P.resize(n + 1, 0);
  D.resize(n + 1, 0);
  int root{};
  for (int i = 1; i <= n; ++i) {
    cin >> P[i];
    if (P[i] == 0) {
      root = i;
    } else {
      ++D[i];
    }
    ++D[P[i]];
    G[P[i]].push_back(i);
  }
  dfs(root);
  vector<int> ans;
  vector<int> e;
  for (auto v : V) {
    if (D[v] % 2 == 1) {
      if (v == root) {
        cout << "NO\n";
        return 0;
      }
      e.push_back(v);
    } else {
      ans.push_back(v);
      --D[P[v]];
    }
  }
  cout << "YES" << endl;
  for (auto u : ans) {
    cout << u << endl;
  }
  for (int i = e.size() - 1; i >= 0; --i) {
    cout << e[i] << endl;
  }
}
