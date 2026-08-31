#include <bits/stdc++.h>
using namespace std;
int g[100005];
int main() {
  int n;
  memset(g, 0, sizeof(g));
  cin >> n;
  for (int i = 1; i < n; i++) {
    int u, v;
    cin >> u >> v;
    g[u]++;
    g[v]++;
  }
  for (int i = 1; i <= n; i++) {
    if (g[i] == 2) {
      cout << "NO";
      return 0;
    }
  }
  cout << "YES";
  return 0;
}
