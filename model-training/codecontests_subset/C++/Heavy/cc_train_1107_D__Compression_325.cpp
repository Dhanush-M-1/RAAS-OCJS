#include <bits/stdc++.h>
using namespace std;
const long long N = 100005;
void inp_out() {}
int32_t main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  inp_out();
  {
    long long i, j, k, n, m, ans = 0, cnt = 0, sum = 0;
    cin >> n;
    string s[n];
    for (i = 0; i < n; i++) {
      cin >> s[i];
    }
    long long a[n][n];
    for (i = 0; i < n; i++) {
      long long p = 0;
      for (j = 0; j < n / 4; j++) {
        long long x;
        (s[i][j] >= 'A' and s[i][j] <= 'F') ? x = s[i][j] - 55
                                            : x = s[i][j] - '0';
        for (k = 0; k < 4; k++) {
          a[i][p + k] = (1 & (x >> (4 - k - 1)));
        }
        p += 4;
      }
    }
    for (i = 0; i < n; i++) {
      for (j = 1; j < n; j++) {
        a[i][j] += a[i][j - 1];
      }
    }
    for (i = 1; i < n; i++) {
      for (j = 0; j < n; j++) {
        a[i][j] += a[i - 1][j];
      }
    }
    ans = 1;
    for (k = 2; k <= n; k++) {
      if (n % k) continue;
      bool f = 1;
      for (i = k - 1; i < n; i += k) {
        for (j = k - 1; j < n; j += k) {
          long long temp = a[i][j];
          if (i - k >= 0) {
            temp -= a[i - k][j];
          }
          if (j - k >= 0) {
            temp -= a[i][j - k];
          }
          if (i - k >= 0 && j - k >= 0) {
            temp += a[i - k][j - k];
          }
          if (temp != 0 and temp != k * k) {
            f = 0;
          }
        }
      }
      if (f == 1) ans = max(ans, k);
    }
    cout << ans;
  }
  return 0;
}
