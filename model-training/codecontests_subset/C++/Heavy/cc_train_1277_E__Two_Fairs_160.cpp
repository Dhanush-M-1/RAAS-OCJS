#include <bits/stdc++.h>
using namespace std;
bool visited1[200002];
bool visited2[200002];
int node1, node2, mark[200002];
vector<int> from_node1, from_node2, adj[200002];
void run_dfs1(int node) {
  if (node == node2) return;
  if (visited1[node]) return;
  visited1[node] = true;
  from_node1.push_back(node);
  for (int x : adj[node]) run_dfs1(x);
}
void run_dfs2(int node) {
  if (node == node1) return;
  if (visited2[node]) return;
  visited2[node] = true;
  from_node2.push_back(node);
  for (int x : adj[node]) run_dfs2(x);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int i, m, n, t, x, y;
  long long int cnt1, cnt2;
  cin >> t;
  while (t--) {
    cin >> n >> m >> node1 >> node2;
    for (i = 1; i <= n; i++) {
      adj[i].clear();
      mark[i] = 0;
      visited1[i] = false;
      visited2[i] = false;
    }
    while (m--) {
      cin >> x >> y;
      adj[x].push_back(y);
      adj[y].push_back(x);
    }
    from_node1.clear();
    from_node2.clear();
    run_dfs1(node1);
    run_dfs2(node2);
    cnt1 = cnt2 = 0LL;
    for (int node : from_node1) ++mark[node];
    for (int node : from_node2) ++mark[node];
    for (int node : from_node1) {
      if (mark[node] == 1) ++cnt1;
    }
    for (int node : from_node2) {
      if (mark[node] == 1) ++cnt2;
    }
    cout << (cnt1 - 1LL) * (cnt2 - 1LL) << '\n';
  }
  return 0;
}
