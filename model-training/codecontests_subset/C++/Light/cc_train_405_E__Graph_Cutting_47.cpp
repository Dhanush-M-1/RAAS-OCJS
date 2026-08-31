#include <bits/stdc++.h>
using namespace std;
const int MAXN = 100010;
int N, M;
set<int> adj[MAXN];
bool vis[MAXN];
void dfs(int u, int p) {
  vis[u] = true;
  set<int> s = adj[u];
  for (typeof(s.begin()) it = s.begin(); it != s.end(); it++) {
    int t = (*it);
    if (!vis[t]) {
      dfs(t, u);
    }
  }
  if (adj[u].size() & 1) {
    adj[u].erase(p);
  }
  for (typeof(adj[u].begin()) it = adj[u].begin(); it != adj[u].end(); it++) {
    cout << (*it) << ' ' << u << ' ';
    adj[*it].erase(u);
    it++;
    cout << (*it) << '\n';
    adj[*it].erase(u);
  }
}
int main() {
  cin >> N >> M;
  if (M & 1) {
    cout << "No solution\n";
    return 0;
  }
  for (int i = 0; i < M; i++) {
    int a, b;
    cin >> a >> b;
    adj[a].insert(b);
    adj[b].insert(a);
  }
  dfs(1, 0);
}
