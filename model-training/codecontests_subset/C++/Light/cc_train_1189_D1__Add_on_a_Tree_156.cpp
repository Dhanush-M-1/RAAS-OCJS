#include <bits/stdc++.h>
#pragma GCC optimize("-O2")
using namespace std;
const int LIM = 1e5 + 5, MOD = 1e9 + 7;
const long double EPS = 1e-9;
vector<vector<int> > g;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  g.resize(n);
  for (int i = 0; i < n - 1; ++i) {
    int u, v;
    cin >> u >> v;
    u--, v--;
    g[u].push_back(v);
    g[v].push_back(u);
  }
  for (int i = 0; i < n; ++i) {
    if (g[i].size() == 2) {
      cout << "NO" << '\n';
      exit(0);
    }
  }
  cout << "YES" << '\n';
  return 0;
}
