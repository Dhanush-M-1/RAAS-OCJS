#include <bits/stdc++.h>
using namespace std;
int n, m, k, a[1000010], h[1000010], pre[1000010];
int main() {
  cin >> n >> m >> k;
  for (int i = 1; i <= m; i++) {
    int tmp;
    scanf("%d", &tmp);
    h[tmp] = 1;
  }
  if (h[0]) return cout << -1 << endl, 0;
  int now = 0, len = 0;
  for (int i = 0; i <= n; i++) {
    if (h[i])
      now++, pre[i] = pre[i - 1];
    else
      now = 0, pre[i] = i;
    len = max(len, now);
  }
  for (int i = 1; i <= k; i++) scanf("%d", &a[i]);
  if (len >= k) return cout << -1 << endl, 0;
  long long ans = 1LL << 60;
  for (int i = len + 1; i <= k; i++) {
    long long ret = 0, now = 0;
    while (now < n) {
      now = pre[now];
      ret += a[i];
      now = now + i;
    }
    ans = min(ans, ret);
  }
  cout << ans << endl;
}
