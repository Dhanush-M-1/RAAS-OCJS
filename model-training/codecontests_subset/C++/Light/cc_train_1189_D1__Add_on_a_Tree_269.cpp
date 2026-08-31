#include <bits/stdc++.h>
using namespace std;
const int limit = 1000000;
int n;
vector<int> g[limit];
int main() {
  ios::sync_with_stdio(false);
  cin >> n;
  for (int i = 0; i < n - 1; i++) {
    int u, v;
    cin >> u >> v;
    g[u].push_back(v);
    g[v].push_back(u);
  }
  for (int u = 1; u <= n; u++) {
    vector<int> &ar = g[u];
    if (int(ar.size()) == 2) {
      cout << "NO" << endl;
      exit(0);
    }
  }
  cout << "YES" << endl;
}
