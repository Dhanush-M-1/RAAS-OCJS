#include <bits/stdc++.h>
using namespace std;
long long int gcd(long long int a, long long int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int tcase;
  cin >> tcase;
  for (int tc = 1; tc <= tcase; tc++) {
    long long int n, l, r, count = 0, i = 0, j;
    cin >> n >> l >> r;
    while (count < l and count < n * (n - 1)) {
      count += 2 * (n - i - 1);
      i++;
    }
    if (count > l) {
      --i;
      count -= 2 * (n - i - 1);
    }
    if (count == n * (n - 1)) {
      if (l == count + 1)
        cout << "1\n";
      else if (l == r)
        cout << n << '\n';
      else
        cout << n << " 1\n";
    } else {
      long long int dif = l - count, start;
      count = 0;
      if (dif == 0) {
        cout << n << ' ';
        count++;
        start = ++i + 1;
      } else if (dif % 2)
        start = (++i) + dif / 2 + 1;
      else {
        start = (++i) + dif / 2;
        cout << start << ' ';
        start++;
        count++;
      }
      for (j = start; j <= n; j++) {
        if (count == r - l + 1) break;
        cout << i << ' ';
        count++;
        if (count == r - l + 1) break;
        cout << j << ' ';
        count++;
      }
      for (i = i + 1; i <= n; i++) {
        for (j = i + 1; j <= n; j++) {
          if (count == r - l + 1) break;
          cout << i << ' ';
          count++;
          if (count == r - l + 1) break;
          cout << j << ' ';
          count++;
        }
        if (count == r - l + 1) break;
      }
      if (count != r - l + 1) cout << "1";
      cout << '\n';
    }
  }
}
