#include <bits/stdc++.h>
using ll = int64_t;
using namespace std;
const int N = 1e6 + 5;
int n;
int a[N];
basic_string<int> g[N];
int32_t main() {
  cin.tie(0)->sync_with_stdio(0);
  cin >> n;
  for (int i = 1, u, v; i < n; i++) {
    cin >> u >> v;
    g[u] += v;
    g[v] += u;
  }
  for (int i = 1; i <= n; i++) {
    if (g[i].size() == 2) {
      cout << "NO";
      return 0;
    }
  }
  cout << "YES";
}
