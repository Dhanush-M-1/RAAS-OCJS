#include <bits/stdc++.h>
#pragma GCC optimize("O3")
#pragma GCC optimize("Ofast")
using namespace std;
long long int t, n, m, a[1005], b[1005];
map<long long int, long long int> cnt1, cnt2;
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  cin >> t;
  while (t--) {
    cin >> n >> m;
    cnt1.clear();
    cnt2.clear();
    for (long long int i = 1; i <= n; i++) {
      cin >> a[i];
      cnt1[a[i]]++;
    }
    for (long long int i = 1; i <= m; i++) {
      cin >> b[i];
      cnt2[b[i]]++;
    }
    for (long long int i = 1; i <= 1005; i++) {
      if (cnt1[i] && cnt2[i]) {
        cout << "YES" << '\n';
        cout << 1 << ' ' << i << '\n';
        goto End;
      }
    }
    cout << "NO" << '\n';
  End:
    n = 0;
  }
}
