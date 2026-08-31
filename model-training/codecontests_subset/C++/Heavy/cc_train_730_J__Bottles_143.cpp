#include <bits/stdc++.h>
using namespace std;
const long long INF = 0x7f7f7f7f;
long long n, m, a[105], b[105];
long long ans1 = INF, ans2 = INF;
long long f[10005], g[10005];
signed main() {
  memset(f, INF, sizeof(f));
  cin >> n;
  for (long long i = 1; i <= n; cin >> a[i++])
    ;
  for (long long i = 1; i <= n; cin >> b[i++])
    ;
  for (long long i = 1; i <= n; i++) m += b[i];
  f[0] = 0;
  for (long long i = 1; i <= n; i++)
    for (long long j = m; j >= b[i]; j--)
      if (f[j - b[i]] + 1 < f[j])
        f[j] = f[j - b[i]] + 1, g[j] = g[j - b[i]] + a[i];
      else if (f[j - b[i]] + 1 == f[j] && g[j - b[i]] + a[i] > g[j])
        g[j] = g[j - b[i]] + a[i];
  long long sum = 0;
  for (long long i = 1; i <= n; i++) sum += a[i];
  for (long long i = sum; i <= m; i++)
    if (f[i] < ans1)
      ans1 = f[i], ans2 = g[i];
    else if (f[i] == ans1 && g[i] > ans2)
      ans2 = g[i];
  cout << ans1 << ' ' << sum - ans2 << endl;
}
