#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 1;
vector<int> g[N];
pair<pair<int, int>, int> dfs(int v, int k, int &best, int hv = 0) {
  if (g[v].empty()) {
    best = max(best, 1);
    return {{1, hv}, 1};
  }
  pair<int, int> sum = {0, N};
  int bestdp = 0;
  for (auto u : g[v]) {
    auto res = dfs(u, k, best, hv + 1);
    if (res.first.second - hv > k) {
      bestdp = max(bestdp, res.second);
      continue;
    }
    sum.first += res.first.first;
    sum.second = min(sum.second, res.first.second);
    bestdp = max(bestdp, res.second - res.first.first);
  }
  best = max(best, sum.first + bestdp);
  return {sum, sum.first + bestdp};
}
void solve() {
  int n, k;
  cin >> n >> k;
  for (int i = 2; i <= n; i++) {
    int p;
    cin >> p;
    g[p].push_back(i);
  }
  int res = 0;
  dfs(1, k, res);
  cout << res;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0), cout.tie(0);
  solve();
}
