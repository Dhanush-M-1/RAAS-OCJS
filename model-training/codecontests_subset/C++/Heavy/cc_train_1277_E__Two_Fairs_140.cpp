#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 10;
int q, num;
vector<int> v[maxn];
bool vis[maxn];
void dfs(int x) {
  for (int i = 0; i < v[x].size(); i++) {
    if (!vis[v[x][i]]) {
      num++;
      vis[v[x][i]] = 1;
      dfs(v[x][i]);
    }
  }
}
int main() {
  cin >> q;
  while (q--) {
    int n, m, a, b;
    long long ans;
    cin >> n >> m >> a >> b;
    for (int i = 1; i <= n; i++) {
      v[i].clear();
      vis[i] = 0;
    }
    for (int i = 1; i <= m; i++) {
      int x, y;
      cin >> x >> y;
      v[x].push_back(y);
      v[y].push_back(x);
    }
    vis[b] = vis[a] = 1, num = 0;
    dfs(a);
    ans = n - 2 - num;
    fill(vis + 1, vis + 1 + n, 0);
    vis[b] = vis[a] = 1, num = 0;
    dfs(b);
    ans *= (n - 2) - num;
    cout << ans << endl;
  }
  return 0;
}
