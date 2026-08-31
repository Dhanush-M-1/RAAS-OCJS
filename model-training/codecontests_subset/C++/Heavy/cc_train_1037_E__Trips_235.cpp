#include <bits/stdc++.h>
using namespace std;
map<long long int, long long int> m1, m2;
const long long int N = 3 * 1e5;
vector<long long int>::iterator itr, itr1;
int main() {
  int n, m, k;
  cin >> n >> m >> k;
  vector<pair<int, int> > Edges(m);
  vector<int> Ans(m);
  vector<int> degree(n);
  vector<vector<pair<int, int> > > adj(n);
  set<pair<int, int> > Good_set;
  vector<int> in_good_set(n, true);
  for (int i = 0; i < m; i++) {
    cin >> Edges[i].first >> Edges[i].second;
    Edges[i].first--;
    Edges[i].second--;
    adj[Edges[i].first].push_back({Edges[i].second, i});
    adj[Edges[i].second].push_back({Edges[i].first, i});
    degree[Edges[i].first]++;
    degree[Edges[i].second]++;
  }
  for (int i = 0; i < n; i++) {
    Good_set.insert({degree[i], i});
  }
  while (!Good_set.empty() && Good_set.begin()->first < k) {
    int node = Good_set.begin()->second;
    for (auto &y : adj[node]) {
      int x = y.first;
      if (in_good_set[x]) {
        Good_set.erase({degree[x], x});
        --degree[x];
        Good_set.insert({degree[x], x});
      }
    }
    Good_set.erase({degree[node], node});
    in_good_set[node] = false;
  }
  for (int i = m - 1; i >= 0; i--) {
    Ans[i] = Good_set.size();
    int u = Edges[i].first, v = Edges[i].second;
    if (in_good_set[u] && in_good_set[v]) {
      Good_set.erase({degree[u], u});
      --degree[u];
      Good_set.insert({degree[u], u});
      Good_set.erase({degree[v], v});
      --degree[v];
      Good_set.insert({degree[v], v});
      while (!Good_set.empty() && Good_set.begin()->first < k) {
        int node = Good_set.begin()->second;
        for (auto &y : adj[node]) {
          int x = y.first;
          if (y.second >= i) continue;
          if (in_good_set[x]) {
            Good_set.erase({degree[x], x});
            --degree[x];
            Good_set.insert({degree[x], x});
          }
        }
        Good_set.erase({degree[node], node});
        in_good_set[node] = false;
      }
    }
  }
  for (int i = 0; i < m; i++) {
    cout << Ans[i] << "\n";
  }
  return 0;
}
