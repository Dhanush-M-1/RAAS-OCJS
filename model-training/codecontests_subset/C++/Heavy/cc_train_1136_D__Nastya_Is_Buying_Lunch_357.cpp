#include <bits/stdc++.h>
using namespace std;
const int MAXN = 300005;
int n, m;
int p[MAXN];
set<pair<int, int> > G;
void init() {
  cin >> n >> m;
  for (int i = 1; i <= n; i++) cin >> p[i];
  for (int i = 0; i < m; i++) {
    int u, v;
    cin >> u >> v;
    G.insert({u, v});
  }
}
void solve() {
  int ans = 0;
  for (int i = n - 1; i >= 1; i--)
    if (G.count({p[i], p[n]})) {
      int j = i;
      while (j < n - 1 && G.count({p[j], p[j + 1]})) {
        swap(p[j], p[j + 1]);
        j++;
      }
      if (G.count({p[n - 1], p[n]})) {
        swap(p[n - 1], p[n]);
        n--;
        ans++;
      }
    }
  cout << ans << '\n';
}
int main() {
  cin.tie(0);
  cin.sync_with_stdio(0);
  init();
  solve();
}
