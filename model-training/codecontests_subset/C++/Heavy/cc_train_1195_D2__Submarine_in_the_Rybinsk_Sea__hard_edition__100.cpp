#include <bits/stdc++.h>
using namespace std;
long long f = 0;
int mod = 998244353;
long long fast_expo(long long x, long long y) {
  long long res = 1;
  x = x % mod;
  while (y > 0) {
    if (y & 1) res = (res * x) % mod;
    y = y >> 1;
    x = (x * x) % mod;
  }
  return (res % mod);
}
int main() {
  long long n;
  cin >> n;
  vector<string> a;
  long long h[11] = {0};
  for (long long i = 0; i < n; i++) {
    string x;
    cin >> x;
    a.push_back(x);
    h[a[a.size() - 1].size()]++;
  }
  long long dp[1000001] = {0};
  for (long long i = 0; i < n; i++) {
    for (long long j = a[i].size() - 1; j >= 0; j--) {
      long long pos = a[i].size() - j;
      for (long long k = 1; k <= 10; k++) {
        if (pos > min(pos, k)) {
          dp[pos + min(pos, k)] =
              (dp[pos + min(pos, k)] + (2 * h[k] * (a[i][j] - 48))) % mod;
        } else {
          dp[pos + min(pos, k)] =
              ((dp[pos + min(pos, k)]) % mod + (h[k] * (a[i][j] - 48)) % mod) %
              mod;
          dp[pos + min(pos, k) - 1] = ((dp[pos + min(pos, k) - 1] % mod +
                                        (h[k] * (a[i][j] - 48)) % mod) %
                                       mod);
        }
      }
    }
  }
  long long maxi = 0;
  for (long long i = 1; i <= 100000; i++) {
    if (dp[i] > 0) maxi = max(maxi, i);
  }
  string ans;
  long long sum = 0;
  long long P = 10;
  long long power = 0;
  for (int i = 1; i < maxi; i++) {
    long long rem = dp[i] % 10;
    long long c = dp[i] / 10;
    sum = (sum % mod + rem * (fast_expo(10, power))) % mod;
    dp[i + 1] = (dp[i + 1] + c) % mod;
    power++;
  }
  sum = (sum % mod + (((dp[maxi]) % mod) * (fast_expo(10, power)))) % mod;
  cout << sum << "\n";
}
