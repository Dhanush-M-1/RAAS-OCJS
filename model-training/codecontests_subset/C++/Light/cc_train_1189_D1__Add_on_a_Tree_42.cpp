#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, u, v;
  cin >> n;
  vector<vector<int>> g(n);
  for (int i = 0; i < n - 1; i++) {
    cin >> u >> v;
    g[u - 1].push_back(v - 1);
    g[v - 1].push_back(u - 1);
  }
  for (int i = 0; i < n; i++) {
    if (g[i].size() == 2) {
      cout << "NO";
      return 0;
    }
  }
  cout << "YES";
}
