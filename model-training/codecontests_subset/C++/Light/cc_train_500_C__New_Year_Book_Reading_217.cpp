#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, m, i, j, cnt, ar[1002], w[1002], b[1002], vis[1002], ans = 0;
  memset(vis, 0, sizeof(vis));
  cin >> n >> m;
  for (i = 0; i < n; i++) cin >> w[i];
  for (i = 0; i < m; i++) {
    cin >> b[i];
    b[i]--;
  }
  cnt = 0;
  for (i = 0; i < m; i++)
    if (!vis[b[i]]) {
      ar[cnt] = b[i];
      cnt++;
      vis[b[i]] = 1;
    }
  for (i = 0; i < n; i++)
    if (!vis[i]) {
      ar[cnt] = i;
      cnt++;
    }
  for (i = 0; i < m; i++) {
    int in = 0;
    while (ar[in] != b[i]) {
      ans += w[ar[in]];
      in++;
    }
    for (j = in; j > 0; --j) ar[j] = ar[j - 1];
    ar[0] = b[i];
  }
  cout << ans;
  return 0;
}
