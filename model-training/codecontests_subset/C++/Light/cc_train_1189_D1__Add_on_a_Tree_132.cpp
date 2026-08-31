#include <bits/stdc++.h>
using namespace std;
const long long mod = 1000000007;
void solve() {
  int n, u, v;
  cin >> n;
  vector<int> Adj[n];
  for (int i = 1; i < n; ++i) {
    cin >> u >> v;
    --u;
    --v;
    Adj[u].push_back(v);
    Adj[v].push_back(u);
  }
  for (int i = 0; i < n; ++i) {
    if (Adj[i].size() == 2) {
      cout << "NO\n";
      return;
    }
  }
  cout << "YES\n";
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int t = 1;
  while (t--) solve();
  return 0;
}
