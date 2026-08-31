#include <bits/stdc++.h>
using namespace std;
double _eps = 1e-6;
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
vector<int> adj[2 * 100000 + 10];
vector<int> path;
bool vis[2 * 100000 + 10];
bool mark[2 * 100000 + 10];
void dfs(int v, int d) {
  if (v == d) {
    for (int x : path) mark[x] = 1;
    return;
  }
  if (!vis[v]) {
    vis[v] = 1;
    path.push_back(v);
    for (int x : adj[v]) dfs(x, d);
    path.pop_back();
  }
}
int mx = 0;
void df(int v) {
  if (!vis[v] && !mark[v]) {
    vis[v] = 1;
    mx++;
    for (int x : adj[v]) df(x);
  }
}
int main() {
  int T;
  cin >> T;
  for (int caseno = 1; caseno <= T; caseno++) {
    int a, b;
    int n, m;
    cin >> n >> m >> a >> b;
    for (int i = 1; i <= n; ++i) adj[i].clear();
    for (int i = 0; i < m; ++i) {
      int k, l;
      cin >> k >> l;
      adj[k].push_back(l);
      adj[l].push_back(k);
    }
    memset(vis, 0, sizeof(vis));
    memset(mark, 0, sizeof(mark));
    dfs(a, b);
    memset(vis, 0, sizeof(vis));
    dfs(b, a);
    mark[a] = mark[b] = 0;
    memset(vis, 0, sizeof(vis));
    mx = 0;
    mark[b] = 1;
    df(a);
    long long x = mx - 1;
    memset(vis, 0, sizeof(vis));
    mark[a] = 1;
    mark[b] = 0;
    mx = 0;
    df(b);
    long long y = mx - 1;
    cout << x * y;
    puts("");
  }
  return 0;
}
