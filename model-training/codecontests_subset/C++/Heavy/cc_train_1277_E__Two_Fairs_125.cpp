#include <bits/stdc++.h>
using namespace std;
int n, m, a, b;
int vis[200010];
vector<int> g[200010];
int atual = 0;
int dfs(int i, int ignore) {
  if (vis[i] == atual) return 0;
  vis[i] = atual;
  if (ignore) {
    if (i == a) return 0;
  } else if (i == b) {
    return 0;
  }
  int ans = 1;
  for (auto x : g[i]) {
    ans += dfs(x, ignore);
  }
  return ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    cin >> n >> m >> a >> b;
    for (int i = 0; i <= n; i++) {
      g[i].clear();
    }
    for (int i = 0; i < m; i++) {
      int x, y;
      cin >> x >> y;
      g[x].push_back(y);
      g[y].push_back(x);
    }
    atual++;
    long long ans1 = 0;
    dfs(a, 0);
    for (int i = 1; i <= n; i++) {
      ans1 += (vis[i] != atual);
    }
    atual++;
    cerr << "\033[31m"
         << "ans1"
         << " = " << ans1 << "\033[0m" << '\n';
    ;
    long long ans2 = 0;
    dfs(b, 1);
    for (int i = 1; i <= n; i++) {
      ans2 += (vis[i] != atual);
    }
    cerr << "\033[31m"
         << "ans2"
         << " = " << ans2 << "\033[0m" << '\n';
    ;
    cout << ans1 * ans2 << '\n';
  }
  return 0;
}
