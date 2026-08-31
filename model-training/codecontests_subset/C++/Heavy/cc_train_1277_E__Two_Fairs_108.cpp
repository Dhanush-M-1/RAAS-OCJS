#include <bits/stdc++.h>
using namespace std;
vector<int> g[200005];
int t;
int n, m, a, b;
bool visited[200005];
int val[200005];
bool flag = false;
void dfs1(int i, int v) {
  if (i == b) return;
  visited[i] = true;
  val[i] += v;
  for (auto it : g[i]) {
    if (!visited[it]) dfs1(it, v);
  }
}
void dfs2(int i, int v) {
  if (i == a) return;
  visited[i] = true;
  val[i] += v;
  for (auto it : g[i]) {
    if (!visited[it]) dfs2(it, v);
  }
}
int main() {
  cin >> t;
  while (t--) {
    cin >> n >> m >> a >> b;
    for (int i = 0; i <= n; i++) {
      visited[i] = false;
      val[i] = 0;
      g[i].clear();
    }
    for (int i = 0; i < m; i++) {
      int u, v;
      cin >> u >> v;
      g[u].push_back(v);
      g[v].push_back(u);
    }
    dfs1(a, 1);
    for (long long int i = 1; i <= n; i++) visited[i] = false;
    dfs2(b, -1);
    long long int aa = 0, bb = 0;
    for (long long int i = 1; i <= n; i++) {
      if (val[i] == 1) aa++;
      if (val[i] == -1) bb++;
    }
    cout << ((aa - 1) * (bb - 1)) << "\n";
  }
}
