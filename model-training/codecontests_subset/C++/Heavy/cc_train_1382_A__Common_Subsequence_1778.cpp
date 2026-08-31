#include <bits/stdc++.h>
using namespace std;
long long int find_ans(long long int x, long long int k, long long int a[],
                       long long int n) {
  long long int ans = 0;
  for (long long int i = 0; i < n; i++) ans += pow(abs(a[i] - x), k);
  return ans;
}
int32_t main() {
  long long int tt;
  cin >> tt;
  while (tt--) {
    long long int n, m;
    cin >> n >> m;
    long long int a[n], b[m];
    for (long long int i = 0; i < n; i++) cin >> a[i];
    for (long long int i = 0; i < m; i++) cin >> b[i];
    long long int ans = -1;
    for (long long int i = 0; i < n; i++) {
      for (long long int j = 0; j < m; j++) {
        if (a[i] == b[j]) {
          ans = a[i];
          break;
        }
      }
    }
    if (ans == -1) {
      cout << "NO";
    } else {
      cout << "YES\n";
      cout << "1 " << ans;
    }
    cout << "\n";
  }
  return 0;
}
