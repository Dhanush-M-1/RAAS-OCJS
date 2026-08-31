#include <bits/stdc++.h>
using namespace std;
const int N = int(3e5) + 10;
const int K = int(2e6) + 10;
const int MOD = int(1e9) + 7;
const int INF = int(1e9) + 5;
const long long INF64 = 1e18;
int p[N];
vector<int> adj[N];
set<int> s;
void solve() {
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= n; i++) cin >> p[i];
  for (int i = 1; i <= m; i++) {
    int u, v;
    cin >> u >> v;
    adj[u].push_back(v);
  }
  int ret = 0;
  s.insert(p[n]);
  for (int i = n - 1; i > 0; i--) {
    int cnt = 0;
    for (auto x : adj[p[i]]) {
      if (s.find(x) != s.end()) cnt++;
    }
    if (int((s).size()) == cnt) {
      ret++;
    } else {
      s.insert(p[i]);
    }
  }
  cout << ret << '\n';
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t;
  t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
