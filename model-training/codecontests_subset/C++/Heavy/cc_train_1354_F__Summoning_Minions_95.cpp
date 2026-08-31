#include <bits/stdc++.h>
using namespace std;
int gcd(int a, int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
int n, k, tab[75][75], d, linkx[75], linky[75], tx[75], ty[75];
bool visx[75], visy[75];
bool dfs(int x) {
  visx[x] = true;
  for (int i = 0; i < n; i++) {
    if (!visy[i] && tx[x] + ty[i] == tab[x][i]) {
      visy[i] = true;
      if (linky[i] == -1 || dfs(linky[i])) {
        linkx[x] = i, linky[i] = x;
        return true;
      }
    }
  }
  return false;
}
void update() {
  d = 1e7;
  for (int i = 0; i < n; i++) {
    if (!visx[i]) continue;
    for (int j = 0; j < n; j++) {
      if (visy[j]) continue;
      d = min(d, tx[i] + ty[j] - tab[i][j]);
    }
  }
  for (int i = 0; i < n; i++)
    if (visx[i]) tx[i] -= d;
  for (int i = 0; i < n; i++)
    if (visy[i]) ty[i] += d;
  return;
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int t;
  cin >> t;
  while (t--) {
    cin >> n >> k;
    pair<int, int> ar[n];
    memset(linkx, -1, sizeof(linkx));
    memset(linky, -1, sizeof(linky));
    memset(ty, 0, sizeof(ty));
    for (int i = 0; i < n; i++) cin >> ar[i].first >> ar[i].second;
    for (int i = 0; i < k; i++) {
      for (int j = 0; j < n; j++) {
        tab[j][i] = ar[j].first + ar[j].second * i;
      }
    }
    for (int i = 0; i < n; i++) tx[i] = tab[i][k - 1];
    for (int i = k; i < n; i++) {
      for (int j = 0; j < n; j++) tab[j][i] = ar[j].second * (k - 1);
    }
    for (int i = 0; i < n; i++) {
      while (!dfs(i)) {
        update();
        memset(visx, 0, sizeof(visx));
        memset(visy, 0, sizeof(visy));
      }
    }
    int ans[75];
    for (int i = 0; i < n; i++) {
      ans[linkx[i]] = i;
    }
    cout << n * 2 - k << '\n';
    for (int i = 0; i < k - 1; i++) cout << ans[i] + 1 << " ";
    for (int i = k; i < n; i++) cout << ans[i] + 1 << " " << -ans[i] - 1 << " ";
    cout << ans[k - 1] + 1 << '\n';
  }
  return 0;
}
