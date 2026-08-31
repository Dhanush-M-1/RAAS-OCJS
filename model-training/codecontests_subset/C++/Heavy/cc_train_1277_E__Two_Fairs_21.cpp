#include <bits/stdc++.h>
using namespace std;
const long long int INF = 3000000000000000000;
void dfs(vector<long long int> adj[], bool vis[], long long int n,
         long long int l) {
  vis[n] = true;
  for (auto x : adj[n]) {
    if (x != l && n != l) {
      if (!vis[x]) {
        dfs(adj, vis, x, l);
      }
    }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t = 1, xp = 1;
  cin >> t;
  while (t--) {
    long long int i = 0, h, j = 0, x = 0, y = 0, n, m, k = 0, l = 0, r = 0,
                  o = 0, cnt1 = INT_MAX, cnt2 = 0, cnt3 = INT_MIN, cnt4 = 0,
                  min1 = INT_MIN;
    cin >> n >> m >> l >> r;
    vector<long long int> adj[n];
    bool vis[n];
    for (i = 0; i < m; i++) {
      cin >> x >> y;
      x--;
      y--;
      adj[x].push_back(y);
      adj[y].push_back(x);
    }
    l--;
    r--;
    memset(vis, false, sizeof(vis));
    vis[l] = true;
    vis[r] = true;
    dfs(adj, vis, l, r);
    bool vis1[n];
    memset(vis1, false, sizeof(vis1));
    vis1[l] = true;
    vis1[r] = true;
    dfs(adj, vis1, r, l);
    for (i = 0; i < n; i++) {
      if (!vis[i]) cnt2++;
      if (!vis1[i]) cnt4++;
    }
    cout << cnt2 * cnt4 << endl;
  }
}
