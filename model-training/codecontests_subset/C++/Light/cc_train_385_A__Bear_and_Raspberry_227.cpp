#include <bits/stdc++.h>
using namespace std;
long long a[200010];
long long pref[200010];
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long n, k;
  cin >> n >> k;
  for (long long i = 1; i <= n; i++) cin >> a[i];
  long long ans = 0;
  for (long long i = 0; i < n; i++) ans = max(ans, a[i] - a[i + 1] - k);
  cout << ans << "\n";
  return 0;
}
