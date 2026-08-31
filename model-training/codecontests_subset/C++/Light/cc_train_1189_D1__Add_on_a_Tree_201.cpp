#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  cin.sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  long long n;
  cin >> n;
  vector<vector<long long>> graph(n + 1);
  if (n == 2) {
    cout << "YES"
         << "\n";
    return 0;
  }
  for (long long i = 0; i < n - 1; i++) {
    long long u, v;
    cin >> u >> v;
    graph[u].push_back(v);
    graph[v].push_back(u);
  }
  for (long long i = 0; i < graph.size(); i++) {
    if (graph[i].size() == 1) continue;
    if (graph[i].size() == 2) {
      cout << "NO"
           << "\n";
      return 0;
    }
  }
  cout << "YES"
       << "\n";
}
