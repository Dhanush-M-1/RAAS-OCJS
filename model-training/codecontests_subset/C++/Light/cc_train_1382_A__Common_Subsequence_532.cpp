#include <bits/stdc++.h>
using namespace std;
int main() {
  long long t;
  cin >> t;
  while (t--) {
    long long n, m;
    cin >> n >> m;
    long long a[n], b[m];
    for (long long i = 0; i < n; i++) cin >> a[i];
    for (long long i = 0; i < m; i++) cin >> b[i];
    long long flag = 0, ans{0};
    for (long long i = 0; i < n; i++) {
      for (long long j = 0; j < m; j++) {
        if (a[i] == b[j]) {
          flag = 1;
          ans = a[i];
          break;
        }
      }
    }
    if (flag != 1)
      cout << "NO" << endl;
    else
      cout << "YES" << endl
           << "1"
           << " " << ans << endl;
  }
  return 0;
}
