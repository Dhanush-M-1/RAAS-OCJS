#include <bits/stdc++.h>
using namespace std;
long long a[1000010];
bool b[1000010];
int pre[1000010];
int main() {
  ios::sync_with_stdio(false);
  int n, m, k;
  cin >> n >> m >> k;
  for (int i = 0; i < m; i++) {
    int s;
    cin >> s;
    b[s] = true;
  }
  for (int i = 1; i <= k; i++) cin >> a[i];
  if (b[0]) {
    cout << -1 << "\n";
    return 0;
  }
  int last = 0, maxd = 0;
  pre[0] = 0;
  for (int i = 1; i <= n; i++) {
    if (!b[i]) {
      last = i;
      pre[i] = i;
    } else {
      pre[i] = last;
      maxd = max(maxd, min(n, i + 1) - pre[i]);
    }
  }
  if (maxd > k) {
    cout << -1 << "\n";
    return 0;
  }
  long long ans = 1000000000000000;
  for (int i = max(1, maxd); i <= k; i++) {
    int cur = 0, cnt = 0;
    while (cur < n) {
      if (b[cur]) {
        cur = pre[cur] + i;
      } else
        cur = cur + i;
      cnt++;
    }
    if (ans > a[i] * cnt) ans = a[i] * cnt;
  }
  cout << ans << "\n";
}
