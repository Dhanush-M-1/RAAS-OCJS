#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long n, k, i, x = 2;
  cin >> n;
  long long a[n][2], b[n][2];
  for (i = 0; i < n; i++) {
    cin >> a[i][0] >> a[i][1];
  }
  if (n < 3) {
    cout << n << "\n";
    return;
  } else {
    for (i = 1; i < n - 1; i++) {
      b[i][0] = a[i][0] - a[i][1];
      b[i][1] = a[i][0] + a[i][1];
    }
    for (i = 1; i < n - 1; i++) {
      if (b[i][0] > a[i - 1][0])
        x++;
      else if (b[i][1] < a[i + 1][0]) {
        a[i][0] += a[i][1];
        x++;
      }
    }
  }
  cout << x << "\n";
}
int32_t main() {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  long long t = 1;
  for (long long i = 1; i <= t; i++) {
    solve();
  }
  return 0;
}
