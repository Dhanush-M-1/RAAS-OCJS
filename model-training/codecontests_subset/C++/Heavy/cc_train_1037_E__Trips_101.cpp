#include <bits/stdc++.h>
using namespace std;
const int maxN = 2e5 + 11;
typedef int i_N[maxN];
int N, M, K;
set<int> adj[maxN];
i_N deg, mark;
int ans;
pair<int, int> edge[maxN];
void dfs(int u) {
  if (mark[u]++) return;
  ans--;
  for (set<int>::iterator it = adj[u].begin(); it != adj[u].end(); it++) {
    int v = *it;
    deg[v]--;
    adj[v].erase(u);
    if (deg[v] < K) dfs(v);
  }
  adj[u].clear();
}
int main() {
  ios_base::sync_with_stdio(0);
  cin >> N >> M >> K;
  for (int i = 1; i <= M; i++) {
    int u, v;
    cin >> u >> v;
    adj[u].insert(v);
    adj[v].insert(u);
    deg[u]++;
    deg[v]++;
    edge[i] = pair<int, int>(u, v);
  }
  ans = N;
  for (int i = 1; i <= N; i++)
    if (deg[i] < K) dfs(i);
  vector<int> v;
  for (int i = M; i; i--) {
    v.push_back(ans);
    int u = edge[i].first, v = edge[i].second;
    if (adj[u].find(v) != adj[u].end()) {
      deg[u]--;
      deg[v]--;
      adj[u].erase(v);
      adj[v].erase(u);
    }
    if (deg[u] < K) dfs(u);
    if (deg[v] < K) dfs(v);
  }
  reverse(v.begin(), v.end());
  for (int i = 0; i < M; i++) cout << v[i] << '\n';
}
