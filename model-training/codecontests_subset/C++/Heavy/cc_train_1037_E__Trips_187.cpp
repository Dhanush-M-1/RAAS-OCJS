#include <bits/stdc++.h>
#pragma GCC target("avx2")
#pragma GCC optimization("O3")
#pragma GCC optimization("unroll-loops")
using namespace std;
template <typename T>
void DBG(const char* name, T&& H) {
  cerr << name << " = " << H << ')' << '\n';
}
template <typename T, typename... Args>
void DBG(const char* names, T&& H, Args&&... args) {
  const char* NEXT = strchr(names + 1, ',');
  cerr.write(names, NEXT - names) << " = " << H << " |";
  DBG(NEXT + 1, args...);
}
using ll = long long;
using ld = long double;
const ll mod1 = 1e9 + 7;
const ld PI = acos(-1.0);
const ll maxN = 1e6 + 1;
const ll INF = 1e18;
void Solve() {
  int n, m, k;
  cin >> n >> m >> k;
  vector<int> deg(n + 1, 0);
  vector<pair<int, int>> friendship(m);
  vector<set<int>> graph(n + 1);
  for (int i = 0; i < m; i++) {
    int a, b;
    cin >> a >> b;
    deg[a]++, deg[b]++;
    graph[a].insert(b);
    graph[b].insert(a);
    friendship[i] = {a, b};
  }
  set<pair<int, int>> q;
  for (int i = 1; i <= n; i++) {
    q.insert({deg[i], i});
  }
  vector<int> ans(m, 0);
  for (int i = m - 1; i >= 0; i--) {
    while (q.size() && ((*q.begin()).first < k)) {
      int ver = (*q.begin()).second;
      for (auto j : graph[ver]) {
        graph[j].erase(ver);
        q.erase({deg[j], j});
        q.insert({deg[j] - 1, j});
        deg[j]--;
      }
      q.erase({deg[ver], ver});
    }
    ans[i] = q.size();
    int a = friendship[i].first;
    int b = friendship[i].second;
    if (q.count({deg[a], a}) && q.count({deg[b], b})) {
      q.erase({deg[a], a});
      q.erase({deg[b], b});
      graph[a].erase(b);
      graph[b].erase(a);
      deg[a]--;
      deg[b]--;
      q.insert({deg[a], a});
      q.insert({deg[b], b});
    }
  }
  for (auto i : ans) cout << i << '\n';
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int tt = 1;
  while (tt--) {
    Solve();
  }
  return 0;
}
