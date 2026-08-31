#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
const int N = 3e5 + 9;
set<int> g[N], gr[N];
int a[N];
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
  }
  int x = a[n];
  for (int i = 1; i <= m; i++) {
    int u, v;
    cin >> u >> v;
    g[u].insert(v);
    gr[v].insert(u);
  }
  int cur = n;
  for (int i = n - 1; i > 0; i--) {
    bool can = 1;
    int u = a[i];
    for (int j = i; j < cur; j++) {
      if (g[u].find(a[j + 1]) == g[u].end()) {
        can = 0;
        break;
      } else {
        swap(a[j], a[j + 1]);
      }
    }
    if (can) cur--;
  }
  cout << n - cur << endl;
  return 0;
}
