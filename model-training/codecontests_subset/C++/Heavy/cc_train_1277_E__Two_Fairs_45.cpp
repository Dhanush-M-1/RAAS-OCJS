#include <bits/stdc++.h>
using namespace std;
vector<int> g[200005];
int vis[200005];
long long int v;
void dfs(int s, int t) {
  v++;
  vis[s]++;
  for (auto x : g[s]) {
    if (vis[x] == 0 and x != t) dfs(x, t);
  }
}
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n, m, a, b;
    cin >> n >> m;
    cin >> a >> b;
    for (int i = 0; i <= n; i++) {
      g[i].clear();
      vis[i] = 0;
    }
    for (int i = 0; i < m; i++) {
      int x, y;
      cin >> x >> y;
      g[x].push_back(y);
      g[y].push_back(x);
    }
    long long x, y;
    v = 0;
    dfs(a, b);
    x = v;
    x = n - x - 1;
    v = 0;
    for (int i = 0; i <= n; i++) {
      vis[i] = 0;
    }
    dfs(b, a);
    y = v;
    y = n - y - 1;
    cout << x * y << endl;
  }
}
