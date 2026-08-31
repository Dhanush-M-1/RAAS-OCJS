#include <bits/stdc++.h>
using namespace std;
vector<vector<long long int>> graph;
int solve() {
  long long int n;
  cin >> n;
  graph.resize(n + 1);
  n--;
  while (n--) {
    long long int a, b;
    cin >> a >> b;
    graph[a].push_back(b);
    graph[b].push_back(a);
  }
  long long int flag = 0;
  for (auto adj : graph) {
    if (adj.size() == 2) flag = 1;
  }
  if (flag)
    cout << "NO\n";
  else
    cout << "YES\n";
  return 0;
}
int main() {
  ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  int t = 1;
  while (t--) solve();
  return 0;
}
