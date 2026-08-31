#include <bits/stdc++.h>
using namespace std;
long long int b[1000005], last[1000005], c[1000005];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int i, n, m, k, ans, f, j, x, cnt;
  cin >> n >> m >> k;
  for (i = 0; i < m; i++) {
    cin >> x;
    b[x] = 1;
  }
  for (i = 1; i <= k; i++) cin >> c[i];
  if (b[0] == 1) {
    cout << -1 << endl;
    return 0;
  }
  for (i = 0; i <= n; i++) {
    if (b[i])
      last[i] = last[i - 1];
    else
      last[i] = i;
  }
  ans = 1e18;
  for (i = 1; i <= k; i++) {
    cnt = 0;
    f = 1;
    for (j = 0; j < n;) {
      cnt++;
      if (j + i >= n) break;
      if (last[j + i] == j) {
        f = 0;
        break;
      } else
        j = last[j + i];
    }
    if (f) {
      ans = min(ans, cnt * c[i]);
    }
  }
  if (ans != 1e18)
    cout << ans << endl;
  else
    cout << -1 << endl;
}
