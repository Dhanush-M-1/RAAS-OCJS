#include <bits/stdc++.h>
using namespace std;
int N;
long long a[100005], b[100005];
struct Edge {
  int v, k;
  Edge(int v = 0, int k = 0) : v(v), k(k) {}
};
vector<Edge> adj[100005];
void dfs(int u) {
  for (int v, w, k = 0; k < adj[u].size(); k++) {
    v = adj[u][k].v;
    w = adj[u][k].k;
    dfs(v);
    if (b[v] >= a[v])
      b[u] += b[v] - a[v];
    else {
      if (((long long)(1e15) + a[u]) / w <= a[v] - b[v])
        b[1] = -(long long)(1e15);
      else
        b[u] -= w * (a[v] - b[v]);
    }
  }
}
int main() {
  cin >> N;
  for (int i = 1; i <= N; i++) cin >> b[i];
  for (int i = 1; i <= N; i++) cin >> a[i];
  for (int u, k, v = 2; v <= N; v++) {
    cin >> u >> k;
    adj[u].push_back(Edge(v, k));
  }
  dfs(1);
  if (b[1] >= a[1])
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
