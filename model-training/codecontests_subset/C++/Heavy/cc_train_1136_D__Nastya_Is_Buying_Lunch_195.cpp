#include <bits/stdc++.h>
using namespace std;
const int MAXN = 3e5 + 5;
set<int> can;
vector<int> p;
vector<int> g[MAXN];
int n, m, res;
signed main() {
  cin >> n >> m;
  p.resize(n);
  for (int i = 0; i < n; ++i) {
    cin >> p[i];
  }
  for (int i = 0; i < m; ++i) {
    int u, v;
    cin >> u >> v;
    g[v].push_back(u);
  }
  for (int x : g[p[n - 1]]) {
    can.insert(x);
  }
  for (int i = n - 2; i >= 0; --i) {
    if (can.count(p[i]))
      ++res, can.erase(p[i]);
    else {
      vector<int> to;
      for (int x : g[p[i]]) {
        if (can.count(x)) to.push_back(x);
      }
      can.clear();
      for (int x : to) {
        can.insert(x);
      }
    }
  }
  cout << res << endl;
  return 0;
}
