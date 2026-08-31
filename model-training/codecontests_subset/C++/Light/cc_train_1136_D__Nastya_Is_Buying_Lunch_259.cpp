#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, m;
  cin >> n >> m;
  vector<int> p(n);
  vector<set<int>> c(n);
  for (int i = 0; i < n; ++i) {
    cin >> p[i];
    --p[i];
  }
  for (int i = 0; i < m; ++i) {
    int u, v;
    cin >> u >> v;
    c[u - 1].emplace(v - 1);
  }
  vector<int> P;
  P.push_back(p[n - 1]);
  for (int i = n - 2; i >= 0; --i) {
    bool f = true;
    for (int pp : P) {
      if (c[p[i]].count(pp) == 0) {
        f = false;
        break;
      }
    }
    if (!f) {
      P.push_back(p[i]);
    }
  }
  cout << n - P.size();
  return 0;
}
