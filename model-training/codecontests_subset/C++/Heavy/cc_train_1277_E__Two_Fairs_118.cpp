#include <bits/stdc++.h>
using namespace std;
vector<int> v[200005];
int vis[200005];
int ans[200005];
void dfs(int node, int f) {
  vis[node] = 1;
  for (int i = 0; i < v[node].size(); i++) {
    if (vis[v[node][i]]) continue;
    ans[v[node][i]] += f;
    dfs(v[node][i], f);
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int n, m, a, b;
    cin >> n >> m >> a >> b;
    for (int i = 0; i < m; i++) {
      int x, y;
      cin >> x >> y;
      v[x].push_back(y);
      v[y].push_back(x);
    }
    vis[a] = 1;
    vis[b] = 1;
    dfs(a, 1);
    for (int i = 0; i <= n; i++) {
      vis[i] = 0;
    }
    vis[a] = 1;
    vis[b] = 1;
    dfs(b, -1);
    long long pos = 0, neg = 0;
    for (int i = 0; i <= n; i++) {
      if (ans[i] > 0)
        pos++;
      else if (ans[i] < 0) {
        neg++;
      }
    }
    cout << pos * neg << '\n';
    for (int i = 0; i <= n; i++) {
      v[i].clear();
      vis[i] = 0;
      ans[i] = 0;
    }
  }
  return 0;
}
