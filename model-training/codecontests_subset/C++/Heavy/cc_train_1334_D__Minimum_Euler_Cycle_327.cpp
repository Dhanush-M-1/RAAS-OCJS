#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  long long t;
  cin >> t;
  while (t--) {
    long long n, l, r;
    cin >> n >> l >> r;
    if (n == 1) {
      cout << "1" << endl;
      continue;
    }
    long long x = 2 * (n - 1);
    long long c = 0;
    r = r - l + 1;
    while (x > 0 && l - x > 0) {
      l -= x;
      c++;
      x -= 2;
    }
    long long f;
    for (long long i = c + 1;; i++) {
      f = 0;
      long long k = i;
      if (i == c + 1) {
        if (l % 2 == 1) {
          k += (l + 1) / 2;
        } else {
          k += l / 2;
          f = 1;
        }
      } else
        k++;
      while (k <= n) {
        if (!f)
          cout << i << " ";
        else {
          cout << k << " ";
          k++;
        }
        r--;
        if (r == 0) break;
        f = !f;
      }
      if (r == 0) break;
      if (i == n) {
        cout << "1";
        break;
      }
    }
    cout << endl;
  }
}
