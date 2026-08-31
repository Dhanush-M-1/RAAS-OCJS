#include <bits/stdc++.h>
using namespace std;
long long q, n, l, r, sum[100005];
signed main() {
  cin >> q;
  while (q--) {
    cin >> n >> l >> r;
    long long s = n * (n - 1), p = 0;
    if (l == s + 1) {
      puts("1");
      continue;
    }
    sum[0] = 0;
    for (long long i = 1; i < n; i++) sum[i] = sum[i - 1] + 2 * (n - i);
    for (p = 1; p < n; p++)
      if (sum[p] >= l) break;
    if (r < s + 1)
      for (long long i = l; i <= r; i++) {
        if (i % 2 == 1)
          cout << p << ' ';
        else
          cout << p + (i - sum[p - 1]) / 2 << ' ';
        if (i == sum[p]) p++;
      }
    else {
      for (long long i = l; i < r; i++) {
        if (i % 2 == 1)
          cout << p << ' ';
        else
          cout << p + (i - sum[p - 1]) / 2 << ' ';
        if (i == sum[p]) p++;
      }
      cout << 1;
    }
    puts("");
  }
  return 0;
}
