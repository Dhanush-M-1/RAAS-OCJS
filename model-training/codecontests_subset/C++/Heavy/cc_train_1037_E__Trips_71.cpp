#include <bits/stdc++.h>
using namespace std;
using lint = long long;
const int INF = 0x3f3f3f3f;
const double EPS = 1e-16;
int N, M, K;
int edges[200010][2], degree[200010];
set<int> graph[200010];
set<tuple<int, int>> nodes;
int ans[200010];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout << setprecision(8) << fixed;
  cin >> N >> M >> K;
  for (int m = 0; m < M; m++) cin >> edges[m][0] >> edges[m][1];
  for (int m = 0; m < M; m++) {
    graph[edges[m][0]].insert(edges[m][1]);
    graph[edges[m][1]].insert(edges[m][0]);
    degree[edges[m][0]]++;
    degree[edges[m][1]]++;
  }
  for (int n = 1; n <= N; n++) {
    nodes.insert({degree[n], n});
  }
  for (int day = M - 1; day >= 0; day--) {
    while (nodes.size() && get<0>(*nodes.begin()) < K) {
      int cur = get<1>(*nodes.begin());
      nodes.erase(nodes.begin());
      for (const int &nxt : graph[cur]) {
        if (nodes.count({degree[nxt], nxt})) {
          nodes.erase({degree[nxt], nxt});
          nodes.insert({--degree[nxt], nxt});
        }
      }
    }
    if (nodes.empty()) break;
    ans[day] = nodes.size();
    if (nodes.count({degree[edges[day][0]], edges[day][0]}) &&
        nodes.count({degree[edges[day][1]], edges[day][1]})) {
      for (int e = 0; e < 2; e++) {
        nodes.erase({degree[edges[day][e]], edges[day][e]});
        degree[edges[day][e]]--;
        nodes.insert({degree[edges[day][e]], edges[day][e]});
        graph[edges[day][e]].erase(edges[day][1 - e]);
      }
    }
  }
  for (int ai = 0; ai < M; ai++) {
    cout << ans[ai] << '\n';
  }
  return 0;
}
