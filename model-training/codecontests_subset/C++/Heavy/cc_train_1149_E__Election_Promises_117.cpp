#include <bits/stdc++.h>
using namespace std;
const int MX = 200005;
int n, m, u, v, a[MX], b[MX], ex[MX], x[MX];
vector<int> adj[MX], in[MX];
void dfs(int u) {
  if (b[u] != -1) return;
  for (int v : adj[u]) dfs(v);
  for (int v : adj[u]) ex[b[v]] = u;
  b[u] = 0;
  while (ex[b[u]] == u) b[u]++;
  in[b[u]].push_back(u);
  x[b[u]] ^= a[u];
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> m;
  for (int i = 0; i < n; i++) cin >> a[i + 1];
  while (m--) {
    cin >> u >> v;
    adj[u].push_back(v);
  }
  memset(b, -1, sizeof(b));
  for (int i = 0; i < n; i++) dfs(i + 1);
  for (int i = n; i + 1; i--)
    if (x[i]) {
      int s = 0;
      for (int j = 0; j < 30; j++)
        if (x[i] & (1 << j)) s = j;
      for (int u : in[i])
        if (a[u] & (1 << s)) {
          a[u] ^= x[i];
          for (int v : adj[u]) ex[b[v]] = v;
          for (int j = 0; j < i; j++) a[ex[j]] ^= x[j];
          break;
        }
      cout << "WIN" << '\n';
      for (int i = 0; i < n; i++) cout << a[i + 1] << " ";
      cout << '\n';
      return 0;
    }
  cout << "LOSE" << '\n';
  return 0;
}
