#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 500;
long long n, m, k, s[N], a[N], pre[N];
bool b[N];
int main() {
  ios::sync_with_stdio(false);
  cin >> n >> m >> k;
  for (int i = 1; i <= m; i++) cin >> s[i], b[s[i]] = 1;
  for (int i = 1; i <= k; i++) cin >> a[i];
  for (int i = 1; i < n; i++)
    if (b[i] == 0)
      pre[i] = i;
    else
      pre[i] = pre[i - 1];
  if (b[0]) {
    printf("-1");
    return 0;
  }
  long long ans = 200000000000000000;
  for (int i = 1; i <= k; i++) {
    long long now = 0, sum = 0;
    while (now < n) {
      sum += a[i];
      if (now >= pre[now] + i) {
        sum = 200000000000000000;
        break;
      }
      now = pre[now] + i;
    }
    ans = min(ans, sum);
  }
  if (ans == 200000000000000000) ans = -1;
  printf("%lld", ans);
}
