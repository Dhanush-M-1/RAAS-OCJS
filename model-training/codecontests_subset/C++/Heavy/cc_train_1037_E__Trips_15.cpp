#include <bits/stdc++.h>
using namespace std;
const int INF = 2147483647;
const long long INFL = 9223372036854775807LL;
const double EPSILON = 0.00000001;
const long long MOD = 1000000007;
vector<int> adj[200000 + 5];
unordered_map<int, int> removed[200000 + 5];
int degree[200000 + 5];
bool node_removed[200000 + 5];
int ans = 0;
void remove_edge(int u, int v, int k) {
  degree[u]--;
  degree[v]--;
  removed[u][v] = true;
  removed[v][u] = true;
}
void remove_edges(int start, int k) {
  queue<int> q;
  assert(degree[start] < k);
  assert(not node_removed[start]);
  q.push(start);
  node_removed[start] = true;
  ans--;
  while (!q.empty()) {
    int top = q.front();
    q.pop();
    for (int x : adj[top]) {
      if (not removed[top][x]) {
        remove_edge(top, x, k);
        if (not node_removed[x] and degree[x] < k) {
          node_removed[x] = true;
          ans--;
          q.push(x);
        }
      }
    }
  }
}
int32_t main() {
  int n, m, k;
  cin >> n >> m >> k;
  vector<pair<int, int>> edges;
  memset(node_removed, false, sizeof(node_removed));
  ;
  ans = n;
  for (int i = 0; i < m; i++) {
    int u, v;
    scanf("%d", &u);
    ;
    scanf("%d", &v);
    ;
    u--;
    v--;
    adj[u].push_back(v);
    adj[v].push_back(u);
    edges.push_back({u, v});
    removed[u][v] = false;
    removed[v][u] = false;
  }
  for (int i = 0; i < n; i++) {
    degree[i] = (int)(adj[i]).size();
  }
  for (int i = 0; i < n; i++) {
    if (not node_removed[i] and degree[i] < k) {
      remove_edges(i, k);
    }
  }
  vector<int> out;
  for (int i = (int)(edges).size() - 1; i >= 0; i--) {
    out.push_back(ans);
    int u = edges[i].first, v = edges[i].second;
    if (not removed[u][v]) {
      remove_edge(u, v, k);
      if (not node_removed[u] and degree[u] < k) {
        remove_edges(u, k);
      }
      if (not node_removed[v] and degree[v] < k) {
        remove_edges(v, k);
      }
    }
  }
  for (int i = (int)(out).size() - 1; i >= 0; i--) {
    printf("%d\n", out[i]);
  }
  return 0;
}
