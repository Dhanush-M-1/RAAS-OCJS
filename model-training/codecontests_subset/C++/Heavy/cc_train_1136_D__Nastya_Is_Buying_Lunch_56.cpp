#include <bits/stdc++.h>
using namespace std;
const double pi = 3.14159265358979323846;
#pragma GCC optimize("-O2")
template <class T>
using min_heap = priority_queue<T, std::vector<T>, std::greater<T> >;
const int LM = 3e5;
int a[LM + 2], pos[LM + 2], marked[LM + 2], ans, n, m;
vector<int> adj[LM + 2];
int main() {
  ios_base::sync_with_stdio(0);
  cout.tie(0);
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    pos[a[i]] = i;
  }
  for (int i = 1; i <= m; i++) {
    int u, v;
    cin >> u >> v;
    adj[u].push_back(v);
  }
  for (int i = 0; i <= n - 2; i++) {
    int ps = n - 1 - i, cn = 0;
    for (auto u : adj[a[ps]]) {
      if (pos[u] > ps and !marked[u]) {
        cn++;
      }
    }
    if (cn == i + 1 - ans) {
      ans++;
      marked[a[ps]] = 1;
    }
  }
  cout << ans << endl;
}
