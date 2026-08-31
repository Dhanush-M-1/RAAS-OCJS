#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<vector<int>> g(n);
  int f, t;
  for (int i = 0; i < n - 1; ++i) {
    cin >> f >> t;
    f--;
    t--;
    g[f].push_back(t);
    g[t].push_back(f);
  }
  for (int i = 0; i < n; ++i) {
    if (g[i].size() == 2) {
      cout << "NO\n";
      return 0;
    }
  }
  cout << "YES\n";
  return 0;
}
