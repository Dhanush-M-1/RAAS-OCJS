#include <bits/stdc++.h>
using namespace std;
void brute_force(long long n) {
  set<int> graph[n + 1];
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      if (i == j) continue;
      graph[i].insert(j);
    }
  }
  int node = 1;
  vector<int> ans = {node};
  long long edges = n * (n - 1);
  while (edges != 0) {
    bool has_bridge = false;
    int bridge_neighbor = -1;
    int goto_neighbor = -1;
    for (auto neighbor : graph[node]) {
      if (graph[neighbor].size() < 1) {
        has_bridge = true;
        bridge_neighbor = neighbor;
      } else {
        goto_neighbor = neighbor;
        break;
      }
    }
    if (goto_neighbor == -1) {
      goto_neighbor = bridge_neighbor;
    }
    ans.push_back(goto_neighbor);
    graph[node].erase(goto_neighbor);
    node = goto_neighbor;
    edges--;
  }
  for (auto x : ans) {
    cout << x << " ";
  }
  cout << endl;
}
vector<int> ans;
void go(long long level, long long l, long long r, long long offset) {
  if (level == 0) return;
  long long prefix = (level - 1) * 2;
  if (l <= prefix) {
    long long idx = 1;
    for (int i = 2; i <= level; i++) {
      if (l <= idx && idx <= r) ans.push_back(1 + offset);
      idx++;
      if (l <= idx && idx <= r) ans.push_back(i + offset);
      idx++;
    }
  }
  if (r - prefix >= 1) {
    go(level - 1, l - prefix, r - prefix, offset + 1);
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int T;
  cin >> T;
  while (T--) {
    long long n, l, r;
    cin >> n >> l >> r;
    ans.clear();
    go(n, l, r, 0);
    if (r == n * (n - 1) + 1) ans.push_back(1);
    for (int i = 0; i < ans.size(); i++) {
      if (i) cout << " ";
      cout << ans[i];
    }
    cout << endl;
  }
  return 0;
}
