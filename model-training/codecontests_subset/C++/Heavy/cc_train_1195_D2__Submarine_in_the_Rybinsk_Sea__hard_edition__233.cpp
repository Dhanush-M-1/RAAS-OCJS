#include <bits/stdc++.h>
using namespace std;
long long n, i, a[100001], ct[100001], maxi, num[100], w[100], m[20][20], pa,
    pb, k, j, ans;
int main() {
  cin >> n;
  for (i = 1; i <= n; i++) {
    cin >> a[i];
    j = 1;
    while (a[i]) {
      num[j] = a[i] % 10;
      a[i] /= 10;
      j++;
    }
    j--;
    w[j]++;
    maxi = max(maxi, j);
    for (k = 1; k <= j; k++) {
      m[j][k] += num[k];
    }
  }
  for (i = 1; i <= maxi; i++) {
    for (j = 1; j <= maxi; j++) {
      pa = 1;
      pb = 1;
      for (k = 1; k <= i + j; k++) {
        if ((k % 2 == 1 && pb <= j) || pa > i) {
          ct[k] += m[j][pb] * w[i];
          pb++;
        } else {
          ct[k] += m[i][pa] * w[j];
          pa++;
        }
      }
    }
  }
  for (i = 2 * maxi; i >= 1; i--) {
    ans *= 10;
    ans %= 998244353;
    ct[i] %= 998244353;
    ans += ct[i];
    ans %= 998244353;
  }
  cout << ans;
}
