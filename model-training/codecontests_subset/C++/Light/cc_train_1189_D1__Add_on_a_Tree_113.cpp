#include <bits/stdc++.h>
using namespace std;
int degree[100005];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n;
  cin >> n;
  for (int i = 1; i < n; ++i) {
    int u, v;
    cin >> u >> v;
    ++degree[u];
    ++degree[v];
  }
  for (int i = 1; i <= n; ++i) {
    if (degree[i] == 2) {
      cout << "NO";
      return 0;
    }
  }
  cout << "YES";
  return 0;
}
