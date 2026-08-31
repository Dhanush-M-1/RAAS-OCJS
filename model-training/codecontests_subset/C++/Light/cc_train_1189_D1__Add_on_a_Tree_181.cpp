#include <bits/stdc++.h>
using namespace std;
int deg[200000];
int main() {
  int n;
  cin >> n;
  for (int i = 0; i < n - 1; ++i) {
    int u, v;
    cin >> u >> v;
    deg[u]++;
    deg[v]++;
  }
  for (int i = 1; i <= n; ++i) {
    if (deg[i] == 2) {
      cout << "NO\n";
      return 0;
    }
  }
  cout << "YES\n";
}
