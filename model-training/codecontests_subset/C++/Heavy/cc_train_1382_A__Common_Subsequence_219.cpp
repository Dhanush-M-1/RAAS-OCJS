#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long t, n, m, i;
  cin >> t;
  while (t--) {
    cin >> n >> m;
    long long a[n];
    long long b[m];
    long long flag = 0, ans;
    map<long long, long long> m1;
    for (i = 0; i < n; i++) {
      cin >> a[i];
      m1[a[i]] = 1;
    }
    for (i = 0; i < m; i++) {
      cin >> b[i];
      if (m1.find(b[i]) != m1.end() && flag == 0) {
        ans = b[i];
        flag = 1;
      }
    }
    if (flag == 1)
      cout << "YES"
           << "\n"
           << "1 " << ans << "\n";
    else
      cout << "NO"
           << "\n";
  }
  cerr << (1000 * clock()) / CLOCKS_PER_SEC << "ms";
  return 0;
}
