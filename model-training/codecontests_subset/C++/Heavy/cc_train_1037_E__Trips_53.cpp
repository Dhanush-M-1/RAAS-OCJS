#include <bits/stdc++.h>
using namespace std;
using LL = long long;
constexpr int N = 2e5 + 5;
int ans[N];
int degree[N];
int is_good[N];
vector<pair<int, int>> E[N];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  int n, m, k;
  cin >> n >> m >> k;
  vector<pair<int, int>> e(m);
  for (int i = 0; i < m; i++) {
    auto& [x, y] = e[i];
    cin >> x >> y;
    x--;
    y--;
    degree[x]++;
    degree[y]++;
    E[x].push_back({y, i});
    E[y].push_back({x, i});
  }
  set<pair<int, int>> good;
  for (int i = 0; i < n; i++) good.insert({degree[i], i});
  fill_n(is_good, n, 1);
  auto keep_good = [&](int t) -> void {
    while (!good.empty() && good.begin()->first < k) {
      int x = good.begin()->second;
      good.erase(good.begin());
      for (const auto& [y, i] : E[x]) {
        if (is_good[y] && i < t) {
          good.erase({degree[y], y});
          degree[y]--;
          good.insert({degree[y], y});
        }
      }
      is_good[x] = 0;
    }
  };
  keep_good(m);
  for (int i = m - 1; i >= 0; i--) {
    ans[i] = good.size();
    const auto& [x, y] = e[i];
    if (is_good[x] && is_good[y]) {
      good.erase({degree[x], x});
      degree[x]--;
      good.insert({degree[x], x});
      good.erase({degree[y], y});
      degree[y]--;
      good.insert({degree[y], y});
      keep_good(i);
    }
  }
  for (int i = 0; i < m; i++) cout << ans[i] << "\n";
}
