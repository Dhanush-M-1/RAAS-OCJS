#include <bits/stdc++.h>
using namespace std;
const int maxn = 510;
const int mod = 1e9 + 9;
int a[maxn], b[maxn * 2];
bool vis[maxn];
int main() {
  memset(vis, false, sizeof(vis));
  int ans = 0;
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= n; i++) cin >> a[i];
  for (int i = 1; i <= m; i++) cin >> b[i];
  for (int i = 1; i <= m; i++) {
    memset(vis, false, sizeof(vis));
    for (int j = i - 1; j >= 1; j--)
      if (b[j] == b[i])
        break;
      else if (!vis[b[j]]) {
        ans += a[b[j]];
        vis[b[j]] = true;
      }
  }
  cout << ans << endl;
  return 0;
}
