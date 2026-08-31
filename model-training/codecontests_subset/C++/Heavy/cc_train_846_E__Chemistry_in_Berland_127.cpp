#include <bits/stdc++.h>
using namespace std;
const int MOD = 1000000007, MOD2 = 1000000009;
const int INF = 0x3f3f3f3f;
const long long BINF = 0x3f3f3f3f3f3f3f3fLL;
int n;
long long demand[100005], supply[100005];
vector<pair<int, long long> > g[100005];
void dfs(int u, int p = -1) {
  if (supply[u] < demand[u])
    demand[u] = demand[u] - supply[u], supply[u] = 0;
  else
    supply[u] = supply[u] - demand[u], demand[u] = 0;
  for (auto e : g[u]) {
    int v = e.first;
    if (v - p) {
      dfs(v, u);
      if (demand[v] > 4e18 / e.second) cout << "NO" << endl, exit(0);
      long long wow = demand[v] * e.second;
      if (demand[u] + wow > 4e18) cout << "NO" << endl, exit(0);
      demand[u] += wow;
      supply[u] += supply[v];
    }
  }
  if (supply[u] < demand[u])
    demand[u] = demand[u] - supply[u], supply[u] = 0;
  else
    supply[u] = supply[u] - demand[u], demand[u] = 0;
}
int solve() {
  cin >> n;
  for (int i = 0; i < n; i++) cin >> supply[i];
  for (int i = 0; i < n; i++) cin >> demand[i];
  for (int i = 1; i < n; i++) {
    int p;
    long long hi;
    cin >> p >> hi;
    p--;
    g[p].push_back({i, hi});
  }
  dfs(0);
  cout << (demand[0] > 0 ? "NO" : "YES") << endl;
  return 0;
}
int main() {
  ios::sync_with_stdio(0);
  solve();
  return 0;
}
