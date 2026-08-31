#include <bits/stdc++.h>
using namespace std;
void dfs(vector<vector<long long> > &adj, vector<long long> &visited,
         long long src, long long b) {
  visited[src] = 1;
  if (src == b) return;
  for (long long i = 0; i < adj[src].size(); i++) {
    if (!visited[adj[src][i]]) dfs(adj, visited, adj[src][i], b);
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  long long t;
  cin >> t;
  while (t--) {
    long long v, e, a, b;
    cin >> v >> e >> a >> b;
    vector<vector<long long> > adj(v + 1);
    for (long long i = 0; i < e; i++) {
      long long v1, v2;
      cin >> v1 >> v2;
      adj[v1].push_back(v2);
      adj[v2].push_back(v1);
    }
    vector<long long> visited(v + 1, 0);
    vector<long long> visited2(v + 1, 0);
    dfs(adj, visited, a, b);
    dfs(adj, visited2, b, a);
    long long n1 = 0, n2 = 0;
    for (long long i = 0; i < v + 1; i++) {
      if (!visited[i] && visited2[i])
        n1++;
      else if (visited[i] && !visited2[i])
        n2++;
    }
    cout << n1 * n2 << "\n";
  }
  return 0;
}
