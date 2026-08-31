#include <bits/stdc++.h>
using namespace std;
const int MAX = 1e5 + 1;
int d[MAX];
void solve() {
  int n;
  cin >> n;
  for (int i = 1; i < n; ++i) {
    int u, v;
    cin >> u >> v;
    d[u]++;
    d[v]++;
  }
  for (int i = 1; i <= n; ++i) {
    if (d[i] == 2) {
      cout << "NO\n";
      return;
    }
  }
  cout << "YES\n";
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  solve();
  return 0;
}
