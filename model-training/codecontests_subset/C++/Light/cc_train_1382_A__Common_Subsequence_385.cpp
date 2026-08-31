#include <bits/stdc++.h>
using namespace std;
long long const MAXN = 2e5 + 10;
long long n, m, T, a[MAXN], b[MAXN];
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> T;
  while (T--) {
    long long m;
    cin >> n >> m;
    for (long long i = 1; i <= n; ++i) cin >> a[i];
    for (long long i = 1; i <= m; ++i) cin >> b[i];
    long long flg = 0;
    for (long long i = 1; i <= n; ++i)
      for (long long j = 1; j <= m; ++j)
        if (a[i] == b[j]) flg = a[i];
    if (!flg)
      cout << "NO\n";
    else {
      cout << "YES\n";
      cout << 1 << " " << flg << endl;
    }
  }
  return 0;
}
