#include <bits/stdc++.h>
using namespace std;
int Int() {
  int x;
  scanf("%d", &x);
  return x;
}
long long Long() {
  long long x;
  scanf("%lld", &x);
  return x;
}
double Double() {
  double x;
  scanf("%lf", &x);
  return x;
}
const int N = 2 * (int)1e5 + 5;
const long long MOD = (int)1e9 + 7;
int us[N], vs[N], ans[N], degree[N];
bool can[N];
set<pair<int, int> > trip;
vector<pair<int, int> > g[N];
int main() {
  int n = Int(), m = Int(), k = Int();
  memset(can, true, sizeof can);
  for (int i = 1; i <= m; i++) {
    us[i] = Int(), vs[i] = Int();
    g[us[i]].push_back({vs[i], i});
    g[vs[i]].push_back({us[i], i});
    degree[us[i]]++;
    degree[vs[i]]++;
  }
  for (int i = 1; i <= n; i++) {
    trip.insert({degree[i], i});
  }
  while (!trip.empty() and trip.begin()->first < k) {
    int u = trip.begin()->second;
    for (auto j : g[u]) {
      if (can[j.first]) {
        trip.erase({degree[j.first], j.first});
        degree[j.first]--;
        trip.insert({degree[j.first], j.first});
      }
    }
    trip.erase({degree[u], u});
    can[u] = false;
  }
  for (int i = m; i > 0; i--) {
    ans[i] = trip.size();
    if (can[us[i]] and can[vs[i]]) {
      trip.erase({degree[us[i]], us[i]});
      degree[us[i]]--;
      trip.insert({degree[us[i]], us[i]});
      trip.erase({degree[vs[i]], vs[i]});
      degree[vs[i]]--;
      trip.insert({degree[vs[i]], vs[i]});
      while (!trip.empty() and trip.begin()->first < k) {
        int u = trip.begin()->second;
        for (auto j : g[u]) {
          if (j.second >= i) continue;
          if (can[j.first]) {
            trip.erase({degree[j.first], j.first});
            degree[j.first]--;
            trip.insert({degree[j.first], j.first});
          }
        }
        trip.erase({degree[u], u});
        can[u] = false;
      }
    }
  }
  for (int i = 1; i <= m; i++) {
    cout << ans[i] << '\n';
  }
  return 0;
}
