#include <bits/stdc++.h>
using namespace std;
const double INF = 1e18;
struct Tree {
  int n;
  vector<vector<int>> g;
  vector<int> parent;
  vector<long long> target;
  vector<long long> current;
  vector<long long> rate;
  Tree(int n) : n(n) {
    g.assign(n, vector<int>());
    parent.assign(n, -1);
    current.assign(n, 0);
    target.assign(n, 0);
    rate.assign(n, 0);
  }
  void addNodeCurrent(int i, long long v) { current[i] = v; }
  void addNodeTarget(int i, long long v) { target[i] = v; }
  void addEdge(int u, int v, int k) {
    g[u].push_back(v);
    g[v].push_back(u);
    rate[u] = k;
  }
  bool solve(int root) {
    vector<int> order;
    deque<int> queue;
    queue.push_back(root);
    parent[root] = -2;
    while (!queue.empty()) {
      int u = queue.front();
      queue.pop_front();
      order.push_back(u);
      for (int v : g[u]) {
        if (parent[v] == -1) {
          parent[v] = u;
          queue.push_back(v);
        }
      }
    }
    bool success = true;
    for (int i = order.size() - 1; i >= 1; i--) {
      int u = order[i];
      int p = parent[u];
      if (current[u] >= target[u]) {
        current[p] += (current[u] - target[u]);
        current[u] = target[u];
      } else if (current[u] < target[u]) {
        if (INF / rate[u] > (target[u] - current[u])) {
          current[p] -= (target[u] - current[u]) * rate[u];
          current[u] = target[u];
          if (current[p] < -INF) {
            success = false;
            break;
          }
        } else {
          success = false;
          break;
        }
      }
    }
    return success && (current[0] >= target[0]);
  }
};
int main() {
  int n;
  cin >> n;
  Tree tree(n);
  for (int i = 0; i < n; i++) {
    long long w;
    cin >> w;
    tree.addNodeCurrent(i, w);
  }
  for (int i = 0; i < n; i++) {
    long long w;
    cin >> w;
    tree.addNodeTarget(i, w);
  }
  for (int i = 1; i < n; i++) {
    int v, k;
    cin >> v >> k;
    v--;
    tree.addEdge(i, v, k);
  }
  bool ans = tree.solve(0);
  cout << (ans ? "YES" : "NO") << endl;
  return 0;
}
