#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3F3F3F3F;
const int NULO = -1;
const double EPS = 1e-10;
int cmp() __attribute__((always_inline));
int cmp(double x, double y = 0, double tol = EPS) {
  return (x <= y + tol) ? (x + tol < y) ? -1 : 0 : 1;
}
void dfs(int i, vector<vector<int> >& graph, vector<bool>& vis, int proibido) {
  vis[i] = true;
  for (auto p : graph[i]) {
    if (!vis[p] && p != proibido) dfs(p, graph, vis, proibido);
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int T;
  cin >> T;
  while (T--) {
    int n, m, a, b;
    cin >> n >> m >> a >> b;
    vector<vector<int> > graph(n);
    vector<bool> vis(n, false);
    for (int i = 0; i < m; i++) {
      int x, y;
      cin >> x >> y;
      graph[x - 1].push_back(y - 1);
      graph[y - 1].push_back(x - 1);
    }
    dfs(a - 1, graph, vis, b - 1);
    long long sumA = 0, sumB = 0;
    for (int i = 0; i < n; i++)
      if (!vis[i]) sumA++;
    sumA--;
    vis.assign(n, false);
    dfs(b - 1, graph, vis, a - 1);
    for (int i = 0; i < n; i++)
      if (!vis[i]) sumB++;
    sumB--;
    cout << sumA * sumB << '\n';
  }
  return 0;
}
